import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/interfaces/Category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  allCategories: Category[] = [];

  constructor(private categoryService : CategoryService) { }

  ngOnInit(): void {
    this.allCategories = this.categoryService.getCategories();
  }

}
