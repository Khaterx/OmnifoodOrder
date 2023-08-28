import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductComponent} from "../../../shared/product/product.component";

@Component({
  selector: 'app-hot-drinks',
  standalone: true,
    imports: [CommonModule, ProductComponent],
  templateUrl: './hot-drinks.component.html',
  styleUrls: ['./hot-drinks.component.scss']
})
export class HotDrinksComponent {

}
