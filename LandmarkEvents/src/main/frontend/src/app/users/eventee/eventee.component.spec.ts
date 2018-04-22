import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventeeComponent } from './eventee.component';

describe('EventeeComponent', () => {
  let component: EventeeComponent;
  let fixture: ComponentFixture<EventeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
