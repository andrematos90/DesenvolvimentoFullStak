import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MomentListComponent } from './moment-list.component';

describe('MomentListComponent', () => {
  let component: MomentListComponent;
  let fixture: ComponentFixture<MomentListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MomentListComponent]
    });
    fixture = TestBed.createComponent(MomentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
