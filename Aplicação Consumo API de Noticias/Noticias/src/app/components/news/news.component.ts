import { News } from './../../interfaces/News';
import { Component } from '@angular/core';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent {
  constructor(private newsService:NewsService){
    this.getNews()
  }

  news:News[]=[]

  getNews():void{
    this.newsService.getAll().subscribe((response) => {
      this.news = response;
      console.log(this.news);

    });

  }

}
