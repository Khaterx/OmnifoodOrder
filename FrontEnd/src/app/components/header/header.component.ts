import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterLink, RouterLinkActive} from "@angular/router";
import {SearchBarComponent} from "../search-bar/search-bar.component";
import {CartComponent} from "../../shared/cart/cart.component";

@Component({
  selector: 'app-header',
  standalone: true,
    imports: [CommonModule, RouterLink, SearchBarComponent, CartComponent, RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  totalOrder: number = 0;
  orderPrice: number = 0;

}
