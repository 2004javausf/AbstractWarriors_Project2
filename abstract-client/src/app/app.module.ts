
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CreateUserComponent } from './components/create-user/create-user.component'
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import {NgRedux, NgReduxModule} from 'ng2-redux'
import {IAppState, rootReducer} from './interfaces/store';


@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgReduxModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(ngRedux: NgRedux<IAppState>){
    ngRedux.configureStore(rootReducer, {});
  }
 }