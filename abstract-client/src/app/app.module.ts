
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
import {StoreModule} from '@ngrx/store'
import { ResetComponent } from './components/reset/reset.component'
import { PostComponent } from './components/post/post.component';
import { ProfileComponent } from './components/profile/profile.component'
import {reducers} from './store/reducers';
import { LogoutComponent } from './components/logout/logout.component'
@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    ResetComponent,
    PostComponent,
    ProfileComponent,
    LogoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    StoreModule.forRoot(reducers,{}),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }