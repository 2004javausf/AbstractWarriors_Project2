import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';
import { UsersService } from 'src/app/services/users.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input('post') post: Post;

  user: User
  constructor(private userService: UsersService, private postService: PostService) { }

  ngOnInit(): void {
    this.userService.getAllState().subscribe(state => {
      this.user = state.user
      console.log(state);
    })
    console.log(this.post)
  }

}
