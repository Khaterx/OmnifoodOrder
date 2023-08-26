import {Order} from "./order";

export class CartItem {
  id: number;
  name: string;
  image: string;
  price: number;
  quantity: number;

  constructor(order: Order) {
    this.id = order.id;
    this.name = order.name;
    this.image = order.image;
    this.price = order.price;
    this.quantity = 1;
  }
}
