import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { User } from 'src/app/interfaces/users';
import { ACTION_SEARCH } from 'src/app/store/actions/appActions';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn;
  otherUser: User;
  searchForm: FormGroup;

  constructor(private userService: UsersService,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.userService.getAllState().subscribe(res =>{
      this.isLoggedIn = res.isLoggedIn;
    })

    this.searchForm = this.fb.group({
      firstName: ''
    })
  }

  findUser() {
    const formValue = this.searchForm.value
    console.log(formValue)
    this.userService.getUserByFirstname(formValue).subscribe(res => {
      this.otherUser = res[0];
      console.log(res[0]);
    })

  }

}

// this.userService.updateState({
//   action: ACTION_SEARCH,
//   payload: res[0]
// })

// this.router.navigate(['/otherUser'])