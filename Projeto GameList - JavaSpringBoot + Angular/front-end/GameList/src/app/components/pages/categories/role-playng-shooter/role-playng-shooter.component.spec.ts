import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RolePlayngShooterComponent } from './role-playng-shooter.component';

describe('RolePlayngShooterComponent', () => {
  let component: RolePlayngShooterComponent;
  let fixture: ComponentFixture<RolePlayngShooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RolePlayngShooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RolePlayngShooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
