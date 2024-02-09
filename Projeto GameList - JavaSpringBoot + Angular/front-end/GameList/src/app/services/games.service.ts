import { Game } from './../interfaces/Game';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Response } from '../interfaces/Response';

@Injectable({
  providedIn: 'root'
})
export class GamesService {

  private baseApiUrl = environment.baseApiUrl;
  private apiUrl = `{this.baseApiUrlapi/games}`

  constructor(private http: HttpClient) { }

  getGames():Observable<any[]>{
    return this.http.get<any[]>('http://localhost:8080/games');
  }

}
