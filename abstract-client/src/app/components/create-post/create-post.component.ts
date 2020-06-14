import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';
import { DomSanitizer } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {


  user: User;
  postCreationForm: FormGroup;

  
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;
  postMessage: string
  userNum: number;

  constructor(
    private userService: UsersService,
    private fb: FormBuilder,
    private postService: PostService,
    private httpClient: HttpClient,
    private sanitizer: DomSanitizer,
    private router: Router
    ) { }


  ngOnInit(): void {
    this.userService.getAllState().subscribe(state => {
      this.user = state.user;
      console.log(state.user.id);
      this.userNum = state.user.id;
    })

  }


  public onFileChanged(event) {
    //Select File
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile)
  }

  public onMessageChanged(event) {
    this.postMessage = event.target.value;
    console.log(this.postMessage);
  }

  onPost() {
    console.log(this.selectedFile);
    console.log(this.user.firstName)

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();


    uploadImageData.append('userId', this.user.id.toString());


    //Will check and go to corresponding route depending if Image exist or not.
    if(this.selectedFile == undefined){
        uploadImageData.append('message', this.postMessage);
        //Make a call to the Spring Boot Application to save the image
        this.httpClient.post('http://localhost:9000/post/addpost', uploadImageData, { observe: 'response' })
          .subscribe((response) => {
        
          });
      this.router.navigate(['/home'])
    }else if(this.postMessage == undefined){
        uploadImageData.append('message', '~')
        uploadImageData.append('postImage', this.selectedFile, this.selectedFile.name);
        this.httpClient.post('http://localhost:9000/post/addpostwithImage', uploadImageData, { observe: 'response' })
          .subscribe((response) => {
            
          });
      this.router.navigate(['/home'])
    }else{
        uploadImageData.append('message', this.postMessage);
        uploadImageData.append('postImage', this.selectedFile, this.selectedFile.name);
        this.httpClient.post('http://localhost:9000/post/addpostwithImage', uploadImageData, { observe: 'response' })
          .subscribe((response) => {
            
          });
      this.router.navigate(['/home'])
        }
    }
}



