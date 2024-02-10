import { map } from 'rxjs/operators';
import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/interfaces/Game';
import { GamesService } from 'src/app/services/games.service';
import { environment } from 'src/environments/environment';

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
    private gameService : GamesService
  ) { }

  ngOnInit(): void {
    this.gameService.getGames().subscribe(response => {
      this.allGames = response
      console.log(this.allGames)
    });
  }

  toggle(){
    this.show = !this.show
  }



}
