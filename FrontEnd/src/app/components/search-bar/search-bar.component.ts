import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Order} from "../../common/model/order";
import {OrderService} from "../../common/services/order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss']
})
export class SearchBarComponent implements OnInit {


  constructor(private _router:Router) {
  }

  ngOnInit(): void {
  }

  doSearch(value: string) {
    this._router.navigateByUrl("home/" + value)
  }
}
