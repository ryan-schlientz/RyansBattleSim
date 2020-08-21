import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Creature } from '../models/Creature';
@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  constructor(private http :HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json'});

create(creature:Creature) :Observable<Creature>{
  return this.http.post<Creature>('http://localhost:8080/BattleSim/addCharacter.do', creature, {headers: this.headers});
}
}
