import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError  } from 'rxjs';
import { environment } from 'src/environments/environment';
import { List } from '../interfaces/List';
import { catchError } from 'rxjs/operators';


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
    const url = "http://localhost:8080/todolist/1104"
    return this.http.delete(url).pipe(
      catchError((error: HttpErrorResponse) => {
        console.error('Erro ao deletar atividade:', error);
        return throwError(error);
      })
    );
    }
}
