import { Component, OnInit } from '@angular/core';
import { MomentService } from 'src/app/services/moment.service';
import { Moment } from 'src/app/Moment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  moments: Moment[] = [];

  constructor(private momentService: MomentService) {}

  ngOnInit(): void {
    this.loadMoments();

    // Inscreva-se no evento de atualização
    this.momentService.momentsUpdated$.subscribe(() => {
      this.loadMoments(); // Atualiza a lista de momentos
    });
  }

  loadMoments(): void {
    this.momentService.getMoments().subscribe((response) => {
      this.moments = response.data; // Carrega os momentos
    });
  }
}
