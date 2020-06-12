import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/interfaces/users';
import { ACTION_LOGIN } from 'src/app/store/actions/appActions';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  user: User;

  constructor(
    private fb: FormBuilder,
    private userService: UsersService
  ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: '',
      password: ''
    })
  }

  async submitForm() {
    const formValue = this.loginForm.value;
    console.log(formValue);
    this.userService.updateState({
      action: ACTION_LOGIN,
      payload: this.user.firstName
    })
    this.userService.getUser(formValue).subscribe(res => {
      this.user = res[0];
      console.log(this.user);
    })
  }
}