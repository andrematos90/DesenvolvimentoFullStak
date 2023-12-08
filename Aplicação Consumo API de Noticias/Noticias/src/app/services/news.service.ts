import { News } from './../interfaces/News';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private apiUrl = 'https://newsapi.org/v2/top-headlines?country=br&apiKey=2397034a4c8e452c8b7cfddb8c5e0be1'

  constructor(private http: HttpClient) { }

  getAll():Observable<News[]>{
    return this.http.get<News[]>(this.apiUrl)

  }
}
