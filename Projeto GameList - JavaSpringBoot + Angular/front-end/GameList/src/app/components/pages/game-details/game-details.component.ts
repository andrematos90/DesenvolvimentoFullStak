import { Component, OnInit } from '@angular/core';
import { StateService } from 'src/app/services/state.service';


@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.css']
})
export class GameDetailsComponent implements OnInit {

  show: boolean = true;

  constructor(private stateService : StateService) { }

  ngOnInit(): void {



  }

  closeBtn(){
    this.stateService.setShowModal(false);
    console.log("clicou")
  }

}
