import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AppComponent } from './app.component';
import { CreateUserComponent } from './components/create-user/create-user.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  {path: "home", component: HomeComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: "login", component: LoginComponent },
  {path: "register", component: CreateUserComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
