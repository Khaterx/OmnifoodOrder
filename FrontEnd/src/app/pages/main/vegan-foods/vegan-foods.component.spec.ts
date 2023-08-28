import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeganFoodsComponent } from './vegan-foods.component';

describe('VeganFoodsComponent', () => {
  let component: VeganFoodsComponent;
  let fixture: ComponentFixture<VeganFoodsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [VeganFoodsComponent]
    });
    fixture = TestBed.createComponent(VeganFoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
