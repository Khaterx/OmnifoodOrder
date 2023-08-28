import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductComponent} from "../../../shared/product/product.component";
import {OrderDetailsComponent} from "../../../components/order-details/order-details.component";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ProductComponent, OrderDetailsComponent, RouterLink],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  // constructor( private _orderServ:OrderService) {
  //   console.log(this._orderServ)
  // }


  ngOnInit(): void {

  }
}

