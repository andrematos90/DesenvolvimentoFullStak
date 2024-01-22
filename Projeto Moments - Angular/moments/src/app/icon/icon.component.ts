import { ChangeDetectionStrategy, Component, HostBinding, Input, ViewEncapsulation } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { Observable, map } from 'rxjs';
import { IconService } from './icon.service';

@Component({
  selector: 'app-icon',
  //template renderiza o SVG baixado em uma div interna
  template: `
  <div class="icon-inner" [innerHTML]="svgContent | async"></div>`,
  styleUrls: ['./icon.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  encapsulation: ViewEncapsulation.ShadowDom
})
export class IconComponent {

  @Input()
  @HostBinding('class')
  //classes com tamanhos pré definidos
  size: 'small' | 'large' | 'default' = 'default';

  //variável com a requisição do SVG que vai ser renderizado
  public svgContent: Observable<SafeHtml> | undefined;

  constructor(
    private sanitizer : DomSanitizer,
    private iconsService: IconService
    ){}

    @Input()
    set src(value : string){
      //pegase o caminho do SVG e invoc o service que vai baixá-lo
      this.setSvgContent(value);
    }

    private setSvgContent(src:string):void{
      //baixa o SVG do service e atribui ele a variável que é renderizada no template
      this.svgContent = this.iconsService
      .getSvgContent(src)
      .pipe(map(
        content => this.sanitizer.bypassSecurityTrustHtml(content)
      ));
    }
}


