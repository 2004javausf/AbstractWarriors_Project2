import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../interfaces/users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpService: HttpClient) { }

  addUser(user: User): Observable<User> {
    return this.httpService.post<User>('http://localhost:9000/users/adduser', JSON.stringify(user), this.httpOptions)
  }

  getUser(user: User): Observable<User> {
    return this.httpService.post<User>('http://localhost:9000/users/login', JSON.stringify(user), this.httpOptions);
  }
}