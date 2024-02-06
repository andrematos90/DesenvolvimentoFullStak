import { TestBed } from '@angular/core/testing';

import { IconService } from './../services/icons.service';

describe('IconsService', () => {
  let service: IconService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IconService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
