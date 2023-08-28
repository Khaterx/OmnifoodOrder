import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {CartItem} from "../../common/model/cart-item";
import {CartService} from "../../common/services/cart.service";
import {FormsModule} from "@angular/forms";
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-shopping-cart',
  standalone: true,
    imports: [CommonModule, FormsModule, RouterLink,],
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss'],

})
export class ShoppingCartComponent implements OnInit{
  cartProducts: CartItem[] = [];
  cartTotalPrice: any = 0;
  totalCart: number = 0;
  isShow: boolean = false;

  constructor(private _cartServ: CartService, private _router:Router) {
  }

  ngOnInit(): void {
    this.showAllOrders();
    this.getCartTotalPrice();
    this._cartServ.sumTotalOrder();
  }

  showAllOrders() {
    this.cartProducts = this._cartServ.orders;
  }

  addAmount(item: CartItem) {
    this._cartServ.addOrderToCart(item);
  }

  minusAmount(item: CartItem) {
    this._cartServ.minusAmount(item);
  }


  deleteProduct(item: CartItem) {
    this._cartServ.deleteOrder(item);
    this._cartServ.sumTotalOrder();
  }

  /* For Test*/
  detectChange(quantity: CartItem) {
    this._cartServ.addOrderToCart(quantity)
  }


  clearCart() {
    this.cartProducts = [];
    this.getCartTotalPrice();
    // this._cartServ.sumTotalOrder();
  }

  getCartTotalPrice() {
    this._cartServ.totalPrice.subscribe(
        (response: any) => {
          this.cartTotalPrice = response;
        },
        (error) => {
          alert(error.message)
        }
    )
    this._cartServ.totalOrdersQuantity.subscribe(
        (response: any) => {
          this.totalCart = response;
        },
        (error) => {
          alert(error.message)
        }
    )

  }

  checkout() {
    this._router.navigateByUrl("/checkout")
    // this.isShow = true
  }
}
