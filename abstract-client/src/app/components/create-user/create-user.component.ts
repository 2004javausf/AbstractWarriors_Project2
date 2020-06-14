import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UsersService } from 'src/app/services/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  userCreationForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private userService: UsersService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.userCreationForm = this.fb.group({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      email: '',
      dateOfBirth: 0,
      profileImage: null
    })
  }

  async createUser() {
    const formValue = this.userCreationForm.value;
    console.log(formValue);
    this.userService.addUser(formValue).subscribe(res => {
      this.userCreationForm.reset();
    })
    this.router.navigate(['/home'])
  }

}