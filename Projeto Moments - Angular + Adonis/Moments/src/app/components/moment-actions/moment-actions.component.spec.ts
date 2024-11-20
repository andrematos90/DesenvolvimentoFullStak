import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MomentActionsComponent } from './moment-actions.component';

describe('MomentActionsComponent', () => {
  let component: MomentActionsComponent;
  let fixture: ComponentFixture<MomentActionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MomentActionsComponent]
    });
    fixture = TestBed.createComponent(MomentActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
