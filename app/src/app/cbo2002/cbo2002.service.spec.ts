import { TestBed } from '@angular/core/testing';

import { Cbo2002Service } from './cbo2002.service';

describe('Cbo2002Service', () => {
  let service: Cbo2002Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cbo2002Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
