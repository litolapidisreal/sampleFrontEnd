import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdValueComponent } from './upd-value.component';

describe('UpdValueComponent', () => {
  let component: UpdValueComponent;
  let fixture: ComponentFixture<UpdValueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdValueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdValueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
