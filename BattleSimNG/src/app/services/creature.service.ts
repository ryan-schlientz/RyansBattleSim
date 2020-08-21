import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Creature } from '../models/Creature';

@Injectable({
  providedIn: 'root'
})
export class CreatureService {

  constructor(private http :HttpClient) { 
  }
  private headers = new HttpHeaders({'Content-Type':'application/json'});

  getCreature() : Observable<Creature> {
    return this.http.get<Creature>('http://localhost:8080/BattleSim/getRandomCreature.do');
  }
  
}
