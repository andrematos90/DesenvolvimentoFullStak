import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Moment } from 'src/app/Moment'; // Certifique-se que Moment está correto
import { MomentService } from 'src/app/services/moment.service';

@Component({
  selector: 'app-moment-actions',
  templateUrl: './moment-actions.component.html',
  styleUrls: ['./moment-actions.component.css']
})
export class MomentActionsComponent {

  @Input() moment!:Moment
  @Output() deleted = new EventEmitter<number>();

  constructor(private momentService: MomentService) {}

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
}
