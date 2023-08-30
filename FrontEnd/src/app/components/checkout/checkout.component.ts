import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {
    FormBuilder,
    FormControl,
    FormsModule,
    ReactiveFormsModule,
    Validators,
} from '@angular/forms';
import {CountryStateService} from '../../common/services/country-state.service';
import {Country} from '../../common/model/country';
import {State} from '../../common/model/state';
import {SpaceValidator} from "../../common/model/space-validator";
import {TotalsComponent} from "../../shared/totals/totals.component";
import {RequestOrder} from "../../common/model/request-order";
import {CartService} from "../../common/services/cart.service";
import {ProductItems} from "../../common/model/product-items";
import {CartItem} from "../../common/model/cart-item";
import {PurchaseRequest} from "../../common/model/purchase-request";
import {PurchaseService} from "../../common/services/purchase.service";
import {OrderAddress} from "../../common/model/order-address";
import {Clients} from "../../common/model/clients";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
    selector: 'app-checkout',
    standalone: true,
    imports: [CommonModule, ReactiveFormsModule, TotalsComponent],
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.scss'],
})
export class CheckoutComponent implements OnInit {
    checkoutForm: FormsModule | any;
    countries: Country[] = [];
    statesFromPersonInfo: State[] = [];
    statesToPersonInfo: State[] = [];
    totalPrice: number = 0;
    totalCart: number = 0;

    constructor(
        private _formBuilder: FormBuilder,
        private _countryState: CountryStateService,
        private _cartServ: CartService,
        private _checkout: PurchaseService,
        private _router: Router
    ) {
    }

    ngOnInit(): void {
        this.formController();
        this.getAllCountries();
        this.getCartTotalPrice();
    }

    formController() {
        this.checkoutForm = this._formBuilder.group({
            basicInfo: this._formBuilder.group({
                fullName: new FormControl('', [
                    Validators.required,
                    SpaceValidator.noSpaceAllowed,
                    Validators.minLength(8),
                ]),
                email: new FormControl('', [
                    Validators.required,
                    Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$'),
                ]),
                phoneNumber: new FormControl('', [
                    Validators.required,
                    Validators.minLength(11),
                    Validators.maxLength(11),
                    Validators.pattern('^[0-9]*$'),
                ]),
            }),
            fromPersonInfo: this._formBuilder.group({
                country: [''],
                state: [''],
                zipCode: [''],
            }),
            toPersonInfo: this._formBuilder.group({
                country: [''],
                state: [''],
                zipCode: [''],
            }),
            creditCart: this._formBuilder.group({
                cardType: [''],
                creditNumber: [''],
                ccvCode: [''],
            }),
        });
    }

    get fullName() {
        return this.checkoutForm.get('basicInfo.fullName')
    }

    get email() {
        return this.checkoutForm.get('basicInfo.email')
    }

    get phoneNumber() {
        return this.checkoutForm.get('basicInfo.phoneNumber')
    }

    checkout() {
        if (this.checkoutForm.invalid) {
            this.checkoutForm.markAllAsTouched();
        } else {

            /* Step #1 */
            let clients: Clients = this.checkoutForm.controls['basicInfo'].value;
            clients.name = this.checkoutForm.controls['basicInfo'].value.fullName

            /* Step #2 */
            let fromOrderAddress = this.checkoutForm.controls['fromPersonInfo'].value;
            fromOrderAddress.state = fromOrderAddress.state['name']

            /* Step #3 */
            let toOrderAddress = this.checkoutForm.controls['toPersonInfo'].value;
            toOrderAddress.state = toOrderAddress.state['name']

            /* Step #4 */
            // let requestOrder: RequestOrder | any;
            let requestOrder = new RequestOrder();
            requestOrder.totalPrice = this.totalPrice;
            requestOrder.totalQuantity = this.totalCart;

            /* Step #5 */
            let orders: CartItem[] = this._cartServ.orders;
/*            let productItems: ProductItems[] = [];
            for(let i =0; i<orders.length;i++){
                productItems[i] = new ProductItems(orders[i])
            }*/
            let productItems: ProductItems[] = orders.map(order => new ProductItems(order))

            /* Step #6 */
            let purchaseRequests = new PurchaseRequest();
            purchaseRequests.clients = clients;
            purchaseRequests.fromOrderAddress = fromOrderAddress;
            purchaseRequests.toOrderAddress = toOrderAddress;
            purchaseRequests.requestOrder = requestOrder;
            purchaseRequests.productItems = productItems;

            this._checkout.getOrderRequest(purchaseRequests).subscribe(
                (response: any) => {
                    alert(`Order is Done 😎🎉
                    Your Name: ${response.fullName}`)
                    this.clearOrder()
                }, (error) => {
                    alert(error.message)
                }
            )
        }

    }

    clearOrder(){
        this._cartServ.orders = [];
        this._cartServ.totalPrice.next(0);
        this._cartServ.totalOrdersQuantity.next(0);
        this.checkoutForm.reset.checkoutForm;
        this._router.navigateByUrl('/home')

    }

    fullSubmitSimilar($event: Event) {
        if ((<HTMLInputElement>$event.target).checked) {
            this.checkoutForm.controls.toPersonInfo.setValue(
                this.checkoutForm.controls.fromPersonInfo.value
            );
            this.statesToPersonInfo = this.statesFromPersonInfo;
        } else {
            this.checkoutForm.controls.toPersonInfo.reset();
        }
    }

    getAllCountries() {
        this._countryState.getAllCountries().subscribe(
            (response: any) => {
                this.countries = response;
            },
            (error) => {
                alert(error.message);
            }
        );
    }

    /*getAllStates() {
        this._countryState.getAllStates().subscribe(
          (response: any) => {
            this.states = response;
          }, (error) => {
            alert(error.message);
          }
        )
      }*/
    getAllStatesByCountryCode(typeForm: any) {
        const code = this.checkoutForm.get(`${typeForm}.country`).value;
        this._countryState.getAllStatesByCountryCode(code).subscribe(
            (response: any) => {
                if (typeForm === 'fromPersonInfo') {
                    this.statesFromPersonInfo = response;
                } else {
                    this.statesToPersonInfo = response;
                }
                this.checkoutForm.get(`${typeForm}.state`).setValue(response[0]);
            },
            (error) => {
                alert(error.message);
            }
        );
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
}
