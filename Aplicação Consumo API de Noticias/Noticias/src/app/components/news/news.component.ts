import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/interfaces/News';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
})
export class NewsComponent implements OnInit {
  news: News[] = []; // Altere o tipo conforme necessário

  constructor(private newsService: NewsService) {}

  ngOnInit(): void {
    this.getNews();
  }

  getNews(): void {
    this.newsService.getAll().subscribe((response) => {
      this.news = response;
      console.log(this.news);
    });
  }
}
