import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlatformComponent } from '../platform/platform.component';
import { RolePlayngAdventureComponent } from '../role-playng-adventure/role-playng-adventure.component';
import { RolePlayngShooterComponent } from '../role-playng-shooter/role-playng-shooter.component';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  componenteSelecionado: any;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    const categoriaGenre = this.route.snapshot.paramMap.get('genre');

    if (categoriaGenre !== null) {
      switch (categoriaGenre) {
        case 'Platform':
          this.componenteSelecionado = PlatformComponent;
          break;
        case 'Role-playing (RPG), Adventure':
          this.componenteSelecionado = RolePlayngAdventureComponent;
          break;
        case 'Role-playing (RPG), Shooter':
          this.componenteSelecionado = RolePlayngShooterComponent;
          break;
        default:
          // Lida com casos de categoria não encontrada
      }
    }

  }
}
