import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RolePlayngAdventureComponent } from './role-playng-adventure.component';

describe('RolePlayngAdventureComponent', () => {
  let component: RolePlayngAdventureComponent;
  let fixture: ComponentFixture<RolePlayngAdventureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RolePlayngAdventureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RolePlayngAdventureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
