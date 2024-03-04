import { TestBed } from '@angular/core/testing';

import { NewActivityService } from './new-activity.service';

describe('NewActivityService', () => {
  let service: NewActivityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewActivityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
