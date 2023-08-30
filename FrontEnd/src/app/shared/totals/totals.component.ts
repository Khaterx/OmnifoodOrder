import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CartService} from "../../common/services/cart.service";

@Component({
  selector: 'app-totals',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './totals.component.html',
  styleUrls: ['./totals.component.scss']
})
export class TotalsComponent implements OnInit {
  totalPrice: any = 0;
  totalCart: number = 0;

  constructor(private _cartServ: CartService) {
  }



  getCartTotalPrice() {
    this._cartServ.totalOrdersQuantity.subscribe(
      (response: any) => {
        this.totalCart = response;
      }, (error) => {

      }
    )

    this._cartServ.totalPrice.subscribe(
      (response: any) => {
        this.totalPrice = response
      }, (error) => {

      }
    )
  }

  ngOnInit(): void {
    this.getCartTotalPrice()
  }
}
