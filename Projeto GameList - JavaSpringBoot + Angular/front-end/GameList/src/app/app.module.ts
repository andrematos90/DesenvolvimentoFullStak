import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/pages/home/home.component';

//importações
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { IconModule } from './icon/icon.module';
import { GamesComponent } from './components/pages/games/games.component';
import { CategoriesComponent } from './components/pages/categories/categories.component';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { GameDetailsComponent } from './components/pages/game-details/game-details.component';
import { RolePlayngShooterComponent } from './components/pages/categories/role-playng-shooter/role-playng-shooter.component';
import { RolePlayngAdventureComponent } from './components/pages/categories/role-playng-adventure/role-playng-adventure.component';
import { PlatformComponent } from './components/pages/categories/platform/platform.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    GamesComponent,
    CategoriesComponent,
    GameDetailsComponent,
    RolePlayngShooterComponent,
    RolePlayngAdventureComponent,
    PlatformComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    IconModule,
    MatCardModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
