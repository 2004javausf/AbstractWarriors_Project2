import { Component } from '@angular/core';
import { User } from './interfaces/users';
// import { NgRedux } from 'ng2-redux';
// import { AppState } from './app.state';
// import { INCREMENT} from './actionss';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Revature Social Network';

  // constructor(private ngRedux: NgRedux<AppState>){

  // }
  // increment(){
  //   this.ngRedux.dispatch({type: INCREMENT});
  // }
}