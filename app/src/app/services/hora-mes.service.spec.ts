import { TestBed } from '@angular/core/testing';

import { HoraMesService } from './hora-mes.service';

describe('HoraMesService', () => {
  let service: HoraMesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HoraMesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
