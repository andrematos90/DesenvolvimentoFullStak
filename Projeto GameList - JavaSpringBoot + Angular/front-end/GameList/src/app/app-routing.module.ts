import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { GamesComponent } from './components/pages/games/games.component';
import { CategoriesComponent } from './components/pages/categories/categories.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'games', component:GamesComponent},
  {path:'categories', component:CategoriesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
