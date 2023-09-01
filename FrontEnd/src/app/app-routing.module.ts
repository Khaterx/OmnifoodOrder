import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {authGuard} from "./common/services/security/guard/auth.guard";
import {loginFormsGuard} from "./common/services/security/guard/login-forms.guard";

const routes: Routes = [
  {
    path: "order-details/:id",
    loadComponent: () => import("./components/order-details/order-details.component").then((m) => m.OrderDetailsComponent),
    canActivate: [authGuard]
  },
  {
    path: "signin",
    loadComponent: () => import('./components/signin/signin/signing.component').then(m => m.SigningComponent),
    canActivate: [loginFormsGuard]
  },
  {
    path: "signup",
    loadComponent: () => import('./components/signin/signup/signup.component').then(m => m.SignupComponent),
    canActivate: [loginFormsGuard]
  },
  // Search Component ⬇
  {
    path: "home/:name",
    loadComponent: () => import("./pages/main/home/home.component").then((m) => m.HomeComponent),
    canActivate: [authGuard]
  },
  {
    path: "home",
    loadComponent: () => import("./pages/main/home/home.component").then((m) => m.HomeComponent),
    canActivate: [authGuard]
  },
  {path: '', pathMatch: 'full', redirectTo: "home"},
  {
    path: "meals/:id",
    loadComponent: () => import("./pages/main/foods/foods.component").then((m) => m.FoodsComponent),
    canActivate: [authGuard]
  },
  {
    path: "hot-drinks/:id",
    loadComponent: () => import("./pages/main/hot-drinks/hot-drinks.component").then((m) => m.HotDrinksComponent),
    canActivate: [authGuard]
  },
  {
    path: "cold-drinks/:id",
    loadComponent: () => import("./pages/main/cold-drinks/cold-drinks.component").then((m) => m.ColdDrinksComponent),
    canActivate: [authGuard]
  },
  {
    path: "sweets/:id",
    loadComponent: () => import("./pages/main/sweets/sweets.component").then((m) => m.SweetsComponent),
    canActivate: [authGuard]
  },
  {
    path: "vegan/:id",
    loadComponent: () => import("./pages/main/vegan-foods/vegan-foods.component").then((m) => m.VeganFoodsComponent),
    canActivate: [authGuard]
  },
  {
    path: "checkout",
    loadComponent: () => import("./components/checkout/checkout.component").then((m) => m.CheckoutComponent),
    canActivate: [authGuard]
  },
  {
    path: "shopping-cart",
    loadComponent: () => import("./shared/shopping-cart/shopping-cart.component").then((m) => m.ShoppingCartComponent),
    canActivate: [authGuard]
  },
  {
    path: "error",
    loadComponent: () => import("./pages/page-not-found/page-not-found.component").then(m => m.PageNotFoundComponent)
  },
  {path: '**', redirectTo: 'error'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
