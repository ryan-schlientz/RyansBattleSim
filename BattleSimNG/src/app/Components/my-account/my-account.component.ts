import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  ifCreate = false;
  ifDelete = false;
  ifManage = false;






  showCC(){
    this.ifCreate = true;
    this.ifDelete = false;
    this.ifManage = false;
  }
  showDC(){
    this.ifCreate = false;
    this.ifDelete = true;
    this.ifManage = false;
  }
  showMI(){
    this.ifCreate = false;
    this.ifDelete = false;
    this.ifManage = true;
  }

}
