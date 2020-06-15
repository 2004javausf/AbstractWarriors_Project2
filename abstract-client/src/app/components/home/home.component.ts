import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/interfaces/users';
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/interfaces/post';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn = false;
  user: User
  posts: Post[];
  constructor(private userService: UsersService, private postService: PostService) { }

  ngOnInit(): void {
      this.userService.getAllState().subscribe(state => {
      this.isLoggedIn = state.isLoggedIn
      this.user = state.user
      console.log(state);
    })

    this.getAllPosts();
  }

  getAllPosts(){
    return this.postService.findAllPosts().subscribe(res => {
      this.posts = res;
    })
  }

}