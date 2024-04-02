import { TestBed } from '@angular/core/testing';

import { ListUpDateService } from './list-up-date.service';

describe('ListUpDateService', () => {
  let service: ListUpDateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListUpDateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
