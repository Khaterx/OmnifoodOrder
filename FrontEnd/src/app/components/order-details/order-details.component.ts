import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SpinnerComponent} from "../../shared/spinner/spinner.component";
import {OrderService} from "../../common/services/order.service";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {Order} from "../../common/model/order";
import {CartService} from "../../common/services/cart.service";
import {CartItem} from "../../common/model/cart-item";

@Component({
    selector: 'app-order-details',
    standalone: true,
    imports: [CommonModule, SpinnerComponent, RouterLink],
    templateUrl: './order-details.component.html',
    styleUrls: ['./order-details.component.scss']
})
export class OrderDetailsComponent implements OnInit {
    orderDetails: Order | any = undefined;

    constructor(
        private _orderServ: OrderService,
        private _router: ActivatedRoute,
        private _cartServ: CartService
    ) {
    }

    ngOnInit(): void {
        this.getOrderById()
    }

    getOrderById() {
        let orderId: any = this._router.snapshot.paramMap.get("id");
        this._orderServ.getOrderById(orderId).subscribe(
            response => {
                this.orderDetails = response;
            }
        )
    }

    addToCart(orderDetails: Order | any) {
        let productItem = new CartItem(orderDetails);
        this._cartServ.addOrderToCart(productItem);
    }
}
