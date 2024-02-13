import { RolePlayngAdventureComponent } from './components/pages/categories/role-playng-adventure/role-playng-adventure.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { GamesComponent } from './components/pages/games/games.component';
import { CategoriesComponent } from './components/pages/categories/categories.component';
import { GameDetailsComponent } from './components/pages/game-details/game-details.component';
import { PlatformComponent } from './components/pages/categories/platform/platform.component';
import { RolePlayngShooterComponent } from './components/pages/categories/role-playng-shooter/role-playng-shooter.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'games', component:GamesComponent},
  {path:'games/categories', component:CategoriesComponent},
  {path:'games/categories/platform', component: PlatformComponent},
  {path:'games/categories/adventure', component: RolePlayngAdventureComponent},
  {path:'games/categories/shooter', component: RolePlayngShooterComponent},
  {path:'details', component:GameDetailsComponent,}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
