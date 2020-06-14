import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';
import { UsersService } from 'src/app/services/users.service';
import { PostService } from 'src/app/services/post.service';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input('post') post: Post;

  user: User
  likeForm: FormGroup;
  constructor(private userService: UsersService, 
    private postService: PostService,
    private httpService: HttpClient,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.userService.getAllState().subscribe(state => {
      this.user = state.user
      console.log(state);
    })
    console.log(this.post)
  }

  likePost() {
    this.likeForm = this.fb.group({
      likeId : 0,
      postId : this.post.postId,
      userId : this.post.userId
    })

    const formValue = this.likeForm.value;
    this.postService.addLike(formValue).subscribe(res =>{
      console.log(res);
    });
  }
}
