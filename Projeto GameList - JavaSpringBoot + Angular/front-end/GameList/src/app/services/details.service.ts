import { Injectable } from '@angular/core';
import { Game } from '../interfaces/Game';

@Injectable({
  providedIn: 'root'
})
export class DetailsService {

  detailsGame!:Game;

  constructor() { }

  setDetailsGame(dataGames:Game){
    this.detailsGame = dataGames;
  }

  getDetailsGame():Game{
    return this.detailsGame;
  }
}
