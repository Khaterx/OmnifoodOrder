import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: "order-details/:id", loadComponent: () => import("./components/order-details/order-details.component").then((m) => m.OrderDetailsComponent)},
  {
    path: "pages",
    loadComponent: () => import("./pages/main/main.component").then((m) => m.MainComponent),
  },
  // Search Component ⬇
  {path: "home/:name", loadComponent: () => import("./pages/main/home/home.component").then((m) => m.HomeComponent)},
  {path: "home", loadComponent: () => import("./pages/main/home/home.component").then((m) => m.HomeComponent)},
  {path: '', pathMatch: 'full', redirectTo: "home"},
  {path: "meals/:id", loadComponent: () => import("./pages/main/foods/foods.component").then((m) => m.FoodsComponent)},
  {
    path: "hot-drinks/:id",
    loadComponent: () => import("./pages/main/hot-drinks/hot-drinks.component").then((m) => m.HotDrinksComponent)
  },
  {
    path: "cold-drinks/:id",
    loadComponent: () => import("./pages/main/cold-drinks/cold-drinks.component").then((m) => m.ColdDrinksComponent)
  },
  {path: "sweets/:id", loadComponent: () => import("./pages/main/sweets/sweets.component").then((m) => m.SweetsComponent)},
  {
    path: "vegan/:id",
    loadComponent: () => import("./pages/main/vegan-foods/vegan-foods.component").then((m) => m.VeganFoodsComponent)
  },
  {
    path: "cart",
    loadComponent: () => import("./shared/cart/cart.component").then((m) => m.CartComponent)
  },
  {
    path: "**",
    loadComponent: () => import("./pages/page-not-found/page-not-found.component").then(m => m.PageNotFoundComponent)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
