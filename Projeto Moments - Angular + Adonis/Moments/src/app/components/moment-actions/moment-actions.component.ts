import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Moment } from 'src/app/Moment'; // Certifique-se que Moment está correto
import { MomentService } from 'src/app/services/moment.service';
import { MomentFormComponent } from '../moment-form/moment-form.component';
import { MatDialog} from '@angular/material/dialog'


@Component({
  selector: 'app-moment-actions',
  templateUrl: './moment-actions.component.html',
  styleUrls: ['./moment-actions.component.css']
})
export class MomentActionsComponent {

  @Input() moment!: Moment
  @Output() deleted = new EventEmitter<number>();

  constructor(private momentService: MomentService, private dialog: MatDialog) { }

  deleteMoment(): void {


    if (confirm('Tem certeza que deseja excluir esse momento?')) {
      this.momentService.deleteMoment(this.moment.id!).subscribe({
        next: () => {
          console.log('Momento excluído com sucesso!');
          this.deleted.emit(this.moment.id)
        },
        error: (err) => {
          console.error('Erro ao excluir o momento:', err);
        }
      });

    }
  }

  upDateMoment(): void {
    const dialogRef = this.dialog.open(MomentFormComponent, {
      width: '400px',
      height: '600px',
      data: { ...this.moment } // Passar o momento como dado para o modal
    });
  
    // Após fechar o modal, processar os dados atualizados
    dialogRef.afterClosed().subscribe((updatedMoment) => {
      if (updatedMoment) {
        this.momentService.updateMoment(this.moment.id!, updatedMoment).subscribe({
          next: (response) => {
            console.log('Momento atualizado com sucesso!', response);
            // Atualize os dados localmente ou recarregue a lista
          },
          error: (err) => {
            console.error('Erro ao atualizar o momento:', err);
          }
        });
      }
    });
  }
}