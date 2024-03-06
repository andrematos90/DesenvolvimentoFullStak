import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { List } from '../interfaces/List';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewActivityService {

  private baseApiUrl = environment.baseApriUrl;
  private apiURL = `${this.baseApiUrl}todolist`

  constructor(private http: HttpClient) { }

  //fução que envia os dados para o backend
  saveActivity(data: List):Observable<List>{
    return this.http.post<List>(this.apiURL, data);
  }
}
