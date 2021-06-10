import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cbo2002Component } from './cbo2002.component';

describe('Cbo2002Component', () => {
  let component: Cbo2002Component;
  let fixture: ComponentFixture<Cbo2002Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Cbo2002Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Cbo2002Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
