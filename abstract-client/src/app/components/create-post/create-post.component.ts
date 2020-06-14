import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {


  user: User;
  postCreationForm: FormGroup;

  constructor(
    private userService: UsersService,
    private fb: FormBuilder,
    private postService: PostService
    ) { }


  ngOnInit(): void {
    this.userService.getAllState().subscribe(state => {
      this.user = state.user;
    })
    this.postCreationForm = this.fb.group({
      postId: 0,
      message: '',
      date: Date.now,
      images: null,
      userId: this.user.user_id,
    })
  }

    async onsubmit() {
      const formValue = this.postCreationForm.value;
      console.log(formValue);
      this.postService.addPost(formValue).subscribe(res => {
        this.postCreationForm.reset();
      })
    }
}



