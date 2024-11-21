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
    this.momentService.getMoments().subscribe((items)=>{
      this.moments = Array.isArray(items.data) ? items.data : [items.data];
    

    }, error =>{
      console.error("Erro ao carregar Momento!")
    })
    }

    removeMoment(id: number): void {
      this.moments = this.moments.filter(moment => moment.id !== id);
      console.log("limpou")
    }
    
  
}
