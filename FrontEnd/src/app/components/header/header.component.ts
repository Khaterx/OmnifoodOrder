import {Component} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Router, RouterLink, RouterLinkActive} from "@angular/router";
import {SearchBarComponent} from "../search-bar/search-bar.component";
import {CartComponent} from "../../shared/cart/cart.component";
import {AuthenticationService} from "../../common/services/security/authentication.service";
import {CartService} from "../../common/services/cart.service";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink, SearchBarComponent, CartComponent, RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  constructor(
    private _authServ: AuthenticationService,
    private _router: Router,
    private _cartServ:CartService
  ) {
  }

  isAuthenticatedUser() {
    return this._authServ.isLogin();
  }

  logOut() {
    this._cartServ.orders=[];
    this._cartServ.totalPrice.next(0);
    this._cartServ.totalOrdersQuantity.next(0);
    this._authServ.isLogOut();
    this._router.navigateByUrl("/signin");
  }
}
