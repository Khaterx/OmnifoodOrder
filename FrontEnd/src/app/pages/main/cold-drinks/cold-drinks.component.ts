import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductComponent} from "../../../shared/product/product.component";

@Component({
  selector: 'app-cold-drinks',
  standalone: true,
  imports: [CommonModule, ProductComponent],
  templateUrl: './cold-drinks.component.html',
  styleUrls: ['./cold-drinks.component.scss']
})
export class ColdDrinksComponent {

}
