import { TestBed } from '@angular/core/testing';

import { GrauInstrucaoService } from './grau-instrucao.service';

describe('GrauInstrucaoService', () => {
  let service: GrauInstrucaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GrauInstrucaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
