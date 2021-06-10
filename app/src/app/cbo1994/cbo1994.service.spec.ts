import { TestBed } from '@angular/core/testing';

import { Cbo1994Service } from './cbo1994.service';

describe('Cbo1994Service', () => {
  let service: Cbo1994Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cbo1994Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
