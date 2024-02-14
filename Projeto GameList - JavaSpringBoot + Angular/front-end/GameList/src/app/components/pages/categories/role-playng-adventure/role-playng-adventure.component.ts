import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Game } from 'src/app/interfaces/Game';
import { GamesService } from 'src/app/services/games.service';
import { environment } from 'src/environments/environment';
import { EventService } from 'src/app/services/event.service';
import { StateService } from 'src/app/services/state.service';
import { DetailsService } from 'src/app/services/details.service';

@Component({
  selector: 'app-role-playng-adventure',
  templateUrl: './role-playng-adventure.component.html',
  styleUrls: ['./role-playng-adventure.component.css']
})
export class RolePlayngAdventureComponent implements OnInit {

  baseApiUrl = environment.baseApiUrl;
  allGames: Game[] = [];
  show: boolean = false;
  ok: string = 'Role-playing (RPG), Shooter';



  constructor(
    private gameService: GamesService,
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

  openModal(game: Game) {
    this.eventService.emitToggleEvent();
    this.detailService.setDetailsGame(game);
  }


}
