import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cbo1994Component } from './cbo1994.component';

describe('Cbo1994Component', () => {
  let component: Cbo1994Component;
  let fixture: ComponentFixture<Cbo1994Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Cbo1994Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Cbo1994Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
