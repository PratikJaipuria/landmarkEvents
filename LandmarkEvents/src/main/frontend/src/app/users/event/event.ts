import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HostAddListComponent } from './event.component';

describe('HostAddListComponent', () => {
  let component: HostAddListComponent;
  let fixture: ComponentFixture<HostAddListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HostAddListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HostAddListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
