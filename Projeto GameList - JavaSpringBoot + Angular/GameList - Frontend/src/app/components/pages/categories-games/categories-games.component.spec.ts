import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriesGamesComponent } from './categories-games.component';

describe('CategoriesGamesComponent', () => {
  let component: CategoriesGamesComponent;
  let fixture: ComponentFixture<CategoriesGamesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CategoriesGamesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CategoriesGamesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
