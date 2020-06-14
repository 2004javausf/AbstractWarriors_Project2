import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/interfaces/users';
import { Post } from 'src/app/interfaces/post';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UsersService } from 'src/app/services/users.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @Input() user: User;
  @Input() post: Post[];

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

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
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit() {
    this.userService.getAllState().subscribe(state => {
      this.user = state.user

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
    uploadImageData.append('username', 'jpark')

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
