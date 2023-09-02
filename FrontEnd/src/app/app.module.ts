import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FooterComponent} from './components/footer/footer.component';
import {HeaderComponent} from "./components/header/header.component";
import {CommonModule} from "@angular/common";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthInterceptorService} from "./common/services/security/auth-interceptor.service";


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    HeaderComponent,
    CommonModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true },
    // CookieService
  ],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
