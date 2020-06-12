
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
import {reducer} from './reducers/tutorial.reducer';
import { ReadComponent } from './components/read/read.component';
import { CreateComponent } from './components/create/create.component';
import { ResetComponent } from './reset/reset.component';
import { CommentComponent } from './comment/comment.component'

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    ReadComponent,
    CreateComponent,
    ResetComponent,
    CommentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    StoreModule.forRoot({
      tutorial: reducer
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }