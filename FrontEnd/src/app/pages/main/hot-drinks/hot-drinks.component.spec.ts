import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotDrinksComponent } from './hot-drinks.component';

describe('HotDrinksComponent', () => {
  let component: HotDrinksComponent;
  let fixture: ComponentFixture<HotDrinksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HotDrinksComponent]
    });
    fixture = TestBed.createComponent(HotDrinksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
