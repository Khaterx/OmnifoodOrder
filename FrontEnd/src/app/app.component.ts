import {Component, OnInit} from '@angular/core';
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'OmnifoodOrder';

  constructor(private _cookie: CookieService) {
  }

  ngOnInit(): void {
    if (this.isCookie()) {
      sessionStorage.setItem('email', this._cookie.get('email'))
      sessionStorage.setItem('token', this._cookie.get('token'))
    }
  }

  isCookie() {
    if (this._cookie.get('email') === '' || this._cookie.get('token') === '') {
      return false;
    }
    return true;
  }
}
