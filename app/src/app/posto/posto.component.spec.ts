import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostoComponent } from './posto.component';

describe('PostoComponent', () => {
  let component: PostoComponent;
  let fixture: ComponentFixture<PostoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
