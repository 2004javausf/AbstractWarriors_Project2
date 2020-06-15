import { Injectable } from '@angular/core';
import { Post } from '../interfaces/post';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Like } from '../interfaces/like';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpService: HttpClient) { }

  addPost(post: Post): Observable<Post>{
    return this.httpService.post<Post>('http://localhost:9000/post/addpost', JSON.stringify(post), this.httpOptions)
  }

  findAllPosts(): Observable<Post[]>{
    return this.httpService.get<Post[]>('http://localhost:9000/post/findallposts')
  }
  findUserPosts(post: Post): Observable<Post[]>{
    return this.httpService.post<Post[]>('http://localhost:9000/post/findposts', JSON.stringify(post), this.httpOptions);
  }

  addLike(like: Like): Observable<Like>{
    return this.httpService.post<Like>('http://localhost:9000/likes/addlike', JSON.stringify(like), this.httpOptions);
  }

}
