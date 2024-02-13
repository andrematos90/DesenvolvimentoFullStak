
import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/interfaces/Category';
import { Game } from 'src/app/interfaces/Game';
import { CategoryService } from 'src/app/services/category.service';




@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],

})
export class HeaderComponent implements OnInit {

  allCategories: Category[]=[];


  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.allCategories = this.categoryService.getCategories();

  }

}
