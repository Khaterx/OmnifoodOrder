import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CartService} from "../../common/services/cart.service";
import {RouterLink} from "@angular/router";

@Component({
    selector: 'app-cart',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
    totalOrder: number = 0;
    orderPrice: number = 0;

    constructor(private _cartServ: CartService) {
    }

    getAllCart() {
        this._cartServ.totalOrdersQuantity.subscribe(
            response => {
                this.totalOrder = response;
            }
        )

        this._cartServ.totalPrice.subscribe(
            response =>{
                this.orderPrice = response;
            }
        )
    }

    ngOnInit(): void {
        this.getAllCart();
    }

}
