import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { ACTION_LOGOUT } from 'src/app/store/actions/appActions';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.userService.updateState({
      action: ACTION_LOGOUT
    })
  }

}
