
import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/interfaces/Category';
import { Game } from 'src/app/interfaces/Game';
import { CategoryService } from 'src/app/services/category.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],

})
export class HeaderComponent implements OnInit {

  allCategories: Category[]=[];


  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.allCategories = this.categoryService.getCategories();

  }

  navegarParaCategoria(categoria: string) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/games/categories/', categoria]);
    });
  }

}
