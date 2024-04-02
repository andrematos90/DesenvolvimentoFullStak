import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { List } from '../interfaces/List';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  private baseApiUrl = environment.baseApriUrl;
  private apiURL = `${this.baseApiUrl}todolist`

  constructor(private http: HttpClient) { }

  getList(): Observable<List[]> {
    return this.http.get<List[]>(this.apiURL)
  };

  saveActivity(data: List):Observable<List>{
    return this.http.post<List>(this.apiURL, data);
  };

  deleteActivity(itemId: number): Observable<any> {
    return this.http.delete(`${this.apiURL}/${itemId}`);
  }

}
