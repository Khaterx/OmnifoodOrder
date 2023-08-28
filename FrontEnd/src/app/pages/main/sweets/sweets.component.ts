import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AppModule} from "../../../app.module";
import {CategoryItemComponent} from "../../../components/category-item/category-item.component";
import {ProductComponent} from "../../../shared/product/product.component";

@Component({
  selector: 'app-sweets',
  standalone: true,
  imports: [CommonModule, CategoryItemComponent, ProductComponent],
  templateUrl: './sweets.component.html',
  styleUrls: ['./sweets.component.scss']
})
export class SweetsComponent {

}
