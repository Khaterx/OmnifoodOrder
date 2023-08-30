import {Injectable} from '@angular/core';
import {CartItem} from "../model/cart-item";
import {BehaviorSubject, Subject} from "rxjs";


@Injectable({
    providedIn: 'root'
})
export class CartService {

    orders: CartItem[] = [];
    totalOrdersQuantity: Subject<number> = new BehaviorSubject<number>(0);
    totalPrice: Subject<number> = new BehaviorSubject<number>(0);

    constructor() {
    }

    /* ADD */
    addOrderToCart(order: CartItem) {
        let isFoundOrder: boolean = false;
        let existOrder: CartItem | any = undefined!;
        if (this.orders.length > 0) {
            /*    for (let product of this.orders) {
                    if (product.id === order.id) {
                        existOrder = product;
                        break;
                    }
                }*/
            existOrder = this.orders.find(product => product.id === order.id);
        }
        isFoundOrder = (existOrder != undefined);
        if (isFoundOrder) {
            existOrder.quantity++;
        } else {
            this.orders.push(order);
        }
        // console.log(this.orders)
        this.sumTotalOrder();
    }

    /* Calculate Order */
    sumTotalOrder() {
        let totalQuantity: number = 0;
        let totalPrice: number = 0;
        for (let item of this.orders) {
            totalQuantity += item.quantity;
            totalPrice += (item.quantity * item.price);
        }
        this.totalOrdersQuantity.next(totalQuantity);
        this.totalPrice.next(totalPrice);
    }

    minusAmount(order: CartItem) {
        order.quantity--;
        if (order.quantity == 0) {
            this.deleteOrder(order)
        } else {
            this.sumTotalOrder();
        }
    }

    deleteOrder(order: CartItem) {
        let index = this.orders.findIndex(indies => indies.id === order.id);
        if (index > -1) {
            this.orders.splice(index, 1)
        }
    }



    /*For Test*/
    detectChange() {

    }
}
