import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  userCreationForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private userService: UsersService
    ) { }

  ngOnInit(): void {

    this.userCreationForm = this.fb.group({
      user_id: 0,
      first_name: '',
      last_name: '',
      user_name: '',
      password: '',
      email: '',
      date_of_birth: 0,
      biography: '',
      profile_image: 'default'
    })
  }

  async createUser(){
    const formValue = this.userCreationForm.value;
    console.log(formValue);
    this.userService.addUser(formValue).subscribe(res => {
      console.log(res);
    })
  }

}
