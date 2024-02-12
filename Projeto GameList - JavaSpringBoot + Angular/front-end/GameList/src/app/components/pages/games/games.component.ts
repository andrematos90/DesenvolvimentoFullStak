import { map } from 'rxjs/operators';
import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/interfaces/Game';
import { GamesService } from 'src/app/services/games.service';
import { environment } from 'src/environments/environment';
import { EventService } from 'src/app/services/event.service';
import { StateService } from 'src/app/services/state.service';
import { DetailsService } from 'src/app/services/details.service';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {


  baseApiUrl = environment.baseApiUrl;
  allGames: Game[] = [];
  show: boolean = false;



  constructor(
    private gameService : GamesService,
    private eventService: EventService,
    private stateService: StateService,
    private detailService: DetailsService,
  ) { }

  ngOnInit(): void {
    this.gameService.getGames().subscribe(response => {
      this.allGames = response

    });

    this.stateService.showModal$.subscribe((value) => {
      this.show = value;
    });


  }

  openModal(game:Game){
    this.eventService.emitToggleEvent();
    this.detailService.setDetailsGame(game);
  }

}
