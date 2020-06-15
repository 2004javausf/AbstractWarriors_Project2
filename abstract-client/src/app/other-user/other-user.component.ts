import { Component, OnInit, Input } from '@angular/core';
import { User } from '../interfaces/users';
import { Post } from '../interfaces/post';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UsersService } from '../services/users.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { PostService } from '../services/post.service';

@Component({
  selector: 'app-other-user',
  templateUrl: './other-user.component.html',
  styleUrls: ['./other-user.component.css']
})
export class OtherUserComponent implements OnInit {

  @Input() otherUser: User;

  @Input() user: User;
  @Input() posts: Post[];

  post: Post = {
    postId: 0,
    message: '',
    numOfLikes: 0,
    date: Date,
    postImages: null,
    userId: 0
  }
  postForm: FormGroup
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  isLoggedIn;

  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;
  image: SafeUrl;


  constructor(
    private httpClient: HttpClient,
    private userService: UsersService,
    private sanitizer: DomSanitizer,
    private postService: PostService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    //Get the state of the user logged in.
    // this.userService.getOtherUserState().subscribe(res =>{
    //   this.otherUser = res.otherUser
    //   console.log(res.otherUser)
    // })
    this.userService.getAllState().subscribe(state => {
      this.user = state.user
      this.isLoggedIn = state.isLoggedIn;
      this.post.userId = state.user.id
      console.log(this.post.userId)
    
      this.httpClient.post('http://localhost:9000/users/getimage', this.otherUser)
        .subscribe(
          res => {
            let data = res[0];
            this.image = this.sanitizer.bypassSecurityTrustResourceUrl(
              'data:image/jpg;base64,' + data
            );
          }
        );
    })
// Render all other users post
    this.postForm = this.fb.group({
      userId: this.otherUser.id,
    })
    const formValue = this.postForm.value

    this.postService.findUserPosts(formValue).subscribe(res => {
      this.posts = res;
    })


   // End of Init Function
  }


  getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.
    console.log(this.otherUser);
    this.httpClient.post('http://localhost:9000/users/getimage', this.otherUser)
      .subscribe(
        res => {
          let data = res[0];
          this.image = this.sanitizer.bypassSecurityTrustResourceUrl(
            'data:image/jpg;base64,' + data
          );
        }
      );
  }

}
