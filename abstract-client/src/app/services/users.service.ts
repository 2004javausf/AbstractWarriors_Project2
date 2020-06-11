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

  addUser(user: User): Observable<User>{
    return this.httpService.post<User>('http://localhost:8085/users/addUser.app', JSON.stringify(user), this.httpOptions)
  }
}
