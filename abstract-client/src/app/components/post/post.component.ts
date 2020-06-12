import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input() post: Post ={
    postId: 0,
    message: 'a message',
    numOfLikes: 2,
    date: "07-07-2020",
    images: [null],
    comments: [null],
    userId: 0,
    likers: [null]
  }

  @Input() user: User ={
    user_id: 0,
    firstName: 'Jordan',
    lastName: 'Parker',
    username: 'jpark',
    password: 'password',
    email: 'notnecessary',
    dateOfBirth: "07-24-1992",
    profileImage: null
  }

  constructor() { }

  ngOnInit(): void {
    this.post
  }

}
