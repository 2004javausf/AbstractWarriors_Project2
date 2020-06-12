import { Component } from '@angular/core';
import { User } from './interfaces/users';
import { UsersService } from './services/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Revature Social Network';

  constructor() {

  }

  ngOnInit() {

  }
}