import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductComponent} from "../../../shared/product/product.component";

@Component({
  selector: 'app-vegan-foods',
  standalone: true,
    imports: [CommonModule, ProductComponent],
  templateUrl: './vegan-foods.component.html',
  styleUrls: ['./vegan-foods.component.scss']
})
export class VeganFoodsComponent {

}
