import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../interfaces/users';
import { Store } from '@ngrx/store';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private httpService: HttpClient,
    private store: Store<any>
    ) { }

  addUser(user: User): Observable<User> {
    return this.httpService.post<User>('http://ec2-18-220-15-80.us-east-2.compute.amazonaws.com:9000/users/adduser', JSON.stringify(user), this.httpOptions)
  }

  getUser(user: User): Observable<User> {
    return this.httpService.post<User>('http://ec2-18-220-15-80.us-east-2.compute.amazonaws.com:9000/users/login', JSON.stringify(user), this.httpOptions);
  }

  getUserByFirstname(otherUser: User): Observable<User>{
    return this.httpService.post<User>('http://ec2-18-220-15-80.us-east-2.compute.amazonaws.com:9000/users/search', JSON.stringify(otherUser), this.httpOptions)
  }

  getAllState() {
    return this.store.select('appReducer')
  }
  updateState(obj){
    this.store.dispatch({
      type: obj.action,
      payload: obj.payload
    })
  }

  getOtherUserState() {
    return this.store.select('otherUserReducer')
  }
}

