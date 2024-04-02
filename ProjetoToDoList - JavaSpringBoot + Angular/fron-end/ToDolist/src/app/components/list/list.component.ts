import { List } from 'src/app/interfaces/List';
import { ListService } from './../../services/list.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { Subscription } from 'rxjs';
import { ListUpDateService } from 'src/app/services/list-up-date.service';
import { MatDialog } from '@angular/material/dialog';
import { DeleteDialogComponent } from '../delete-dialog/delete-dialog.component';



@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  dataSource: List[] = []
  displayedColumns: string[] = ['activity', 'description', 'deadLine', 'exceeded', 'completed', 'actions'];

  showNewActivityModal: boolean = false;
  private listUpdateSubscription!: Subscription;

  @ViewChild(MatTable) table!: MatTable<List>;

  constructor(private listService: ListService, private listUpdateService: ListUpDateService, public dialog: MatDialog
    ) { }

  ngOnInit(): void {
    this.listService.getList().subscribe(response => {
      this.dataSource = response
    });

    // Assinar o Observable para receber atualizações da lista
    this.listUpdateSubscription = this.listUpdateService.getListUpdate().subscribe(() => {
      // Lógica para atualizar a lista
      this.updateList();
    });


  }


  ngOnDestroy(): void {
    // Não se esqueça de cancelar a inscrição quando o componente for destruído para evitar vazamentos de memória
    this.listUpdateSubscription.unsubscribe();
  }


  updateList(): void {
    // Coloque aqui a lógica para buscar e renderizar a lista novamente
    this.listService.getList().subscribe(response => {
      this.dataSource = response
    });

  }
  //função faz o modal abrir
  openCreateActivityModal() {
    this.showNewActivityModal = true;
  }

  //função que recebe do componente filho o valor da variavel "showNewActivityModal" e fecha o modal
  closeCreateActivityModal(showNewActivityModal: boolean) {
    this.showNewActivityModal = showNewActivityModal
  }

  openDialog(): void {
    this.dialog.open(DeleteDialogComponent,
       {
      width: '250px',

    });
  }

}


