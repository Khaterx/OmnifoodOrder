import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormBuilder, FormControl, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {CountryStateService} from "../../common/services/country-state.service";
import {Country} from "../../common/model/country";
import {State} from "../../common/model/state";

@Component({
    selector: 'app-checkout',
    standalone: true,
    imports: [CommonModule, ReactiveFormsModule],
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {
    checkoutForm: FormsModule | any;
    countries: Country[] = [];
    statesFromPersonInfo: State[] = [];
    statesToPersonInfo: State[] = [];

    constructor(private _formBuilder: FormBuilder, private _countryState: CountryStateService) {
    }

    ngOnInit(): void {
        this.formController();
        this.getAllCountries();
        // this.getAllStates();
        // this.getAllStatesByCountryCode();

    }

    formController() {
        this.checkoutForm = this._formBuilder.group({
            // basicInfo: this._formBuilder.group({
            //     fullName: new FormControl('', [
            //         Validators.required,
            //         Validators.minLength(8),
            //     ]),
            //     email: new FormControl('', [
            //         Validators.required,
            //         Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')
            //     ]),
            //     phoneNumber: new FormControl('', [
            //         Validators.required,
            //         Validators.minLength(11),
            //         Validators.maxLength(11),
            //         Validators.pattern('/^(\\+\\d{1,3}[- ]?)?\\d{10}$/')
            //     ])
            // }),
            fromPersonInfo: this._formBuilder.group({
                country: [''],
                state: [''],
                zipCode: ['']
            }),
            toPersonInfo:
                this._formBuilder.group({
                    country: [''],
                    state: [''],
                    zipCode: ['']
                }),
            creditCart:
                this._formBuilder.group({
                    cardType: [''],
                    creditNumber: [''],
                    ccvCode: ['']
                })
        })
    }

    checkout() {
        /* Just For Testing */
        console.log(this.checkoutForm.get('basicInfo').value);
        console.log(this.checkoutForm.get('basicInfo.fullName').value);
        console.log(this.checkoutForm.get('fromPersonInfo').value);
        console.log(this.checkoutForm.get('toPersonInfo').value);
        console.log(this.checkoutForm.get('creditCart').value);
    }

    fullSubmitSimilar($event: Event) {
        if ((<HTMLInputElement>$event.target).checked) {
            this.checkoutForm.controls.toPersonInfo.setValue(
                this.checkoutForm.controls.fromPersonInfo.value
            )
            this.statesToPersonInfo = this.statesFromPersonInfo
        } else {
            this.checkoutForm.controls.toPersonInfo.reset()
        }
        //console.log("Test")
    }

    getAllCountries() {
        this._countryState.getAllCountries().subscribe(
            (response: any) => {
                this.countries = response;
            }, (error) => {
                alert(error.message);
            }
        )
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
        const code = this.checkoutForm.get(`${typeForm}.country`).value
        this._countryState.getAllStatesByCountryCode(code).subscribe(
            (response: any) => {
                if (typeForm === 'fromPersonInfo') {
                    this.statesFromPersonInfo = response
                } else {
                    this.statesToPersonInfo = response
                }
                this.checkoutForm.get(`${typeForm}.state`).setValue(response[0])
            }, (error) => {
                alert(error.message)
            }
        )
    }
}
