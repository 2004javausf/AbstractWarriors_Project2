import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UsersService } from 'src/app/services/users.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { PostService } from 'src/app/services/post.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @Input() user: User;
  @Input() posts: Post[];

  post: Post ={
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

  ngOnInit() {
    this.userService.getAllState().subscribe(state => {
      this.user = state.user
      this.isLoggedIn= state.isLoggedIn;
      this.post.userId = state.user.id
      console.log(this.post.userId)

      this.httpClient.post('http://localhost:9000/users/getimage', this.user)
        .subscribe(
          res => {
            let data = res[0];
            this.image = this.sanitizer.bypassSecurityTrustResourceUrl(
              'data:image/jpg;base64,' + data
            );
          }
        );
    })

  // Take post and set it up as JSON Form Data
    this.postForm = this.fb.group({
      userId: this.post.userId,
    })
    const formValue = this.postForm.value

    this.postService.findUserPosts(formValue).subscribe(res => {
      this.posts = res;
    })
  }



  //Gets called when the user selects an image
  public onFileChanged(event) {
    //Select File
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile)
  }

  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('profileImage', this.selectedFile, this.selectedFile.name);
    console.log(uploadImageData);
    uploadImageData.append('username', this.user.username)

    //Make a call to the Spring Boot Application to save the image
    this.httpClient.post('http://localhost:9000/users/uploadimage/', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.message = 'Image uploaded successfully';
        } else {
          this.message = 'Image not uploaded successfully';
        }
      }
      );
      //Sets Image
      this.getImage();
  }

  //Gets called when the user clicks on retieve image button to get the image from back end
  getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.
    console.log(this.user);
    this.httpClient.post('http://localhost:9000/users/getimage', this.user)
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
