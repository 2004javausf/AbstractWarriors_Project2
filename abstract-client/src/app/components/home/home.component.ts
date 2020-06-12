import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn = false;
  constructor(private userService: UsersService) { }

  ngOnInit(): void {
      this.userService.getAllState().subscribe(state => {
      this.isLoggedIn = state;
      console.log(state);
    })
  }

}