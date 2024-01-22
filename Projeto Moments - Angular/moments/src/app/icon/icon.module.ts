import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IconComponent } from './icon.component';
import { IconService } from './icon.service';



@NgModule({
  declarations: [
    IconComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[IconComponent], //exporta o componente
  providers:[IconService] // declara o service internamente
})
export class IconModule { }
