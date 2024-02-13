import { Category } from './../interfaces/Category';
import { GamesService } from 'src/app/services/games.service';
import { Injectable } from '@angular/core';
import { Game } from '../interfaces/Game'

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private games: Game[] = []
  private categoryGames: Category[] = [];

  constructor(private gameService: GamesService) {
    this.gameService.getGames().subscribe(response => {
      this.games = response;
      this.categoryGames = this.extractCategories(this.games);
    })
  }

  private extractCategories(games: Game[]): Category[] {
    const categoriesMap: Map<string, boolean> = new Map();

    games.forEach(game => {
      if (!categoriesMap.has(game.genre)) {
        categoriesMap.set(game.genre, true);
        this.categoryGames.push({ genre: game.genre });
      }
    });

    return this.categoryGames;
  }

  getCategories(): Category[] {
    return this.categoryGames;
  }
}
