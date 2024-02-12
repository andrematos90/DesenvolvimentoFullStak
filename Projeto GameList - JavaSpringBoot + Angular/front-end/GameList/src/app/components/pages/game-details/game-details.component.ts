import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/interfaces/Game';
import { DetailsService } from 'src/app/services/details.service';
import { StateService } from 'src/app/services/state.service';


@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.css']
})
export class GameDetailsComponent implements OnInit {

  show: boolean = true;
  game!: Game;

  constructor(
    private stateService : StateService,
    private gameDetails : DetailsService,
    ) { }

  ngOnInit(): void {
    this.game = this.gameDetails.getDetailsGame();
  }

  closeBtn(){
    this.stateService.setShowModal(false);
    console.log("clicou")
  }

}
