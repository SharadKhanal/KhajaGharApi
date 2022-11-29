import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup=new FormGroup({});
  constructor(
    private formBuilder:FormBuilder
  ) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm(){
    this.loginForm=this.formBuilder.group({
    email:[undefined],
    password:[undefined]
    })
  }
  onSubmit(){
    
  }

}
