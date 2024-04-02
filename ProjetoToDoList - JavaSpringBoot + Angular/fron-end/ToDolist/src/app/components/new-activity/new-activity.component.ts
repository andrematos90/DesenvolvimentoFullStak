import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { error } from 'console';
import { List } from 'src/app/interfaces/List';
import { NewActivityService } from 'src/app/services/new-activity.service';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { ListService } from 'src/app/services/list.service';
import { ListUpDateService } from 'src/app/services/list-up-date.service';



@Component({
  selector: 'app-new-activity',
  templateUrl: './new-activity.component.html',
  styleUrls: ['./new-activity.component.css']
})
export class NewActivityComponent implements OnInit {

  //variaveis
  exampleHeader!: any;

  @Output() showNewActivityModal : EventEmitter<boolean> = new EventEmitter();




   data : List = {
    activity: '',
    description: '',
    completed: false,
    exceeded: false,
    deadLine: new Date()
  }

  dataSource:List[]=[]



  constructor(private activityService : NewActivityService, private listUpDateService : ListUpDateService) { }

  ngOnInit(): void {

  }

  /*função que emite o evento para o componente pai e altera o valor da variavel
  que mostra o modal*/
  closeModal(){
    this.showNewActivityModal.emit(false);

  }



  // Método para preencher a data na propriedade deadLine
  setDeadline(event: MatDatepickerInputEvent<Date>) {
    if(event.value != null){
      this.data.deadLine = event.value;
    } else{
      this.data.deadLine = new Date();
    }
  }

  //função que envia os dados para o service
  createActivity(){
    this.activityService.saveActivity(this.data).subscribe(
      response => {
        console.log("dados enviados com sucesso!", response);
        this.listUpDateService.emitListUpdate();

      },
      error => {
        console.error("Erro ao enviar dados", error);
      }
    )

    this.closeModal();

  }

}
