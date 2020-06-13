import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/interfaces/users';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn = false;
  user: User
  constructor(private userService: UsersService) { }

  ngOnInit(): void {
      this.userService.getAllState().subscribe(state => {
      this.isLoggedIn = state.isLoggedIn
      this.user = state.user
      console.log(state);
    })
  }

}