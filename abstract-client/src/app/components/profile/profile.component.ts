import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @Input() user: User;
  @Input() post: Post[];

  

  constructor() { }

  ngOnInit(): void {
  }

}
