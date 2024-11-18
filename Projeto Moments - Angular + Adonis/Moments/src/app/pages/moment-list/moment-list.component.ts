import { Component, OnInit } from '@angular/core';
import { Moment } from 'src/app/Moment';
import { MomentService } from 'src/app/services/moment.service';

@Component({
  selector: 'app-moment-list',
  templateUrl: './moment-list.component.html',
  styleUrls: ['./moment-list.component.css']
})
export class MomentListComponent implements OnInit{

  moments: Moment[] = []

  constructor(private momentService : MomentService){}

  ngOnInit(): void {
      this.fetchMoments();
  }

  fetchMoments():void{
    this.momentService.getMoments().subscribe(response =>{
     this.moments = response.moments;
    }, error => {
      console.error('Erro ao carregar momentos', error);
    });
  }
}
