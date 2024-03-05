import { Component, OnInit, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-new-activity',
  templateUrl: './new-activity.component.html',
  styleUrls: ['./new-activity.component.css']
})
export class NewActivityComponent implements OnInit {

  exampleHeader!: any;
  @Output() showNewActivityModal : EventEmitter<boolean> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {

  }

  /*função que emite o evento para o componente pai e altera o valor da variavel
  que mostra o modal*/
  closeModal(){
    this.showNewActivityModal.emit(false);

  }

}
