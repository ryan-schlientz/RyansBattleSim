import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http :HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json'});

register(user:User) :Observable<User>{
  return this.http.post<User>('http://localhost:8080/BattleSim/addUser.do', user, {headers: this.headers});
}
loginUser(user:User) :Observable<any>{
  return this.http.post<any>('http://localhost:8080/BattleSim/login.do', user, {headers: this.headers});

}
}