import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EveteeProfileComponent } from './evetee-profile.component';

describe('EveteeProfileComponent', () => {
  let component: EveteeProfileComponent;
  let fixture: ComponentFixture<EveteeProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EveteeProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EveteeProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
