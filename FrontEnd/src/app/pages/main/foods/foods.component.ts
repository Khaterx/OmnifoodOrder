import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductComponent} from "../../../shared/product/product.component";

@Component({
  selector: 'app-foods',
  standalone: true,
  imports: [CommonModule, ProductComponent],
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.scss']
})
export class FoodsComponent {

}
