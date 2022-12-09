import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from './login.model';
import { LoginService } from './login.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup=new FormGroup({});
  submitted:boolean=false
  isSubmitting:boolean=false
  login =new Login();
  constructor(
    private formBuilder:FormBuilder,
    private loginService:LoginService,
    private router:Router,
    private location:Location

  ) { }

  ngOnInit(): void {
    this.initForm();
  }

  get forms():{[key:string]: AbstractControl}{
    return this.loginForm.controls;
  }

  initForm(){
    this.loginForm=this.formBuilder.group({
    username:[undefined,Validators.required],
    password:[undefined,Validators.required]
    })
  }
  onSubmit(loginData:any):void {
    this.submitted=true;
    this.login.username=loginData.username;
    this.login.password=loginData.password;

    if(this.loginForm.valid){
      this.loginUser(this.login);
    
    }

    
  }

  loginUser(login:any){
    this.loginService.onUserLogin(login).subscribe(
      (response:any)=>{
        this.isSubmitting=true;
        // this.router.navigate(['/khajaghar/admin/item'])
      },
      (error:any)=>{
        this.isSubmitting=false;
      }
    )
  }

onCancel(){
  this.location.back();
}

onResetPassword(){
  
}

}
