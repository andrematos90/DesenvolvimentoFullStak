import { News } from './../interfaces/News';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { environment } from '../enviroments/enviroment';



@Injectable({
  providedIn: 'root'
})
export class NewsService {

  apirUrl = environment.baseApiUrl


  constructor(private http: HttpClient) { }

  getAll(): Observable<News[]> {
    return this.http.get<{ articles: News[] }>(this.apirUrl)
      .pipe(map(response => response.articles));
  }
}

/*
 O Angular espera uma array para ser usada com a diretiva *ngFor, mas o endpoint da  API retorna um objeto contendo uma propriedade chamada "articles" que contém a array de notícias. map mapeaia a resposta e extrair a array de notícias


@Injectable({
  providedIn: 'root'
})
export class NewsService {

  apirUrl = environment.baseApiUrl

  constructor(private http: HttpClient) { }

  getAll(): Observable<News[]> {
    return this.http.get<{ articles: News[] }>(this.apirUrl)
      .pipe(map(response => response.articles));
  }
}
Aqui, utilizei o operador map para transformar a resposta da API, que contém a propriedade "articles", em um array que pode ser atribuída diretamente à propriedade news no componente.

*/
