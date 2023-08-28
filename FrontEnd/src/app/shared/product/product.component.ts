import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Order} from "../../common/model/order";
import {OrderService} from "../../common/services/order.service";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {NgbPagination} from "@ng-bootstrap/ng-bootstrap";
import {CartItem} from "../../common/model/cart-item";
import {CartService} from "../../common/services/cart.service";

@Component({
    selector: 'app-product',
    standalone: true,
    imports: [CommonModule, RouterLink, NgbPagination],
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
    orders: Order[] = [];
    page = 1;
    pageSize: number = 6;
    orderSize: number = 0;
    isShow: boolean = false;

    constructor(
        private _orderServ: OrderService,
        private _route: ActivatedRoute,
        private _cartServ: CartService) {
    }

    ngOnInit(): void {
        this._route.paramMap.subscribe(
            () => {
                this.getAllOrders();
            }
        )
    }


    getAllOrders() {
        let result = this._route.snapshot.paramMap.get("id");
        let orderName = this._route.snapshot.paramMap.get("name");
        if (result) {
            this.getOrderByCategoryId();
        } else if (orderName) {
            this.getOrderByName();
        } else {
            this.getOrders();
        }
    }

    getOrders() {
        this._orderServ.getOrderLength().subscribe(
            response => {
                this.orderSize = response;
            }
        )
        this._orderServ.getAllOrders(--this.page, this.pageSize).subscribe(
            data => {
                this.orders = data;
            }
        )
    }

    getOrderByCategoryId() {
        let categoryId: any = this._route.snapshot.paramMap.get("id");
        this._orderServ.getOrderLengthByCategoryId(categoryId).subscribe(
            response => {
                this.orderSize = response;
            }
        )
        this._orderServ.getAllOrdersByCategoryId(categoryId, --this.page, this.pageSize).subscribe(
            response => {
                this.orders = response;
            }
        )
    }

    getOrderByName() {
        let orderName: any = this._route.snapshot.paramMap.get("name");
        this._orderServ.getOrderLengthByKeyword(orderName).subscribe(
            response => {
                this.orderSize = response;
            }
        )
        this._orderServ.getOrderByName(orderName, --this.page, this.pageSize).subscribe(
            response => {
                this.orders = response;
            }
        )
    }

    doPagination() {
        // alert(this.page)
        this.getAllOrders();
    }

    addToCart(product: Order) {
        const productItem = new CartItem(product);
        this._cartServ.addOrderToCart(productItem);
    }


}
