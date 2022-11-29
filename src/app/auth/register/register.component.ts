import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Register } from './register.model';
import { RegisterService } from './register.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup = new FormGroup({});
  submitted: boolean = false;
  register = new Register();
  isSubmitting: boolean = false;
  constructor(
    private formBuilder: FormBuilder,
    private registerService: RegisterService,
    
   private router: Router,
   
    
  ) {}
  

  ngOnInit(): void {
    this.initForm();
  }

  initForm(){
    this.registerForm = this.formBuilder.group({
      username: [undefined, Validators.required],
      email: [undefined, Validators.required],
      contactNumber: [undefined, Validators.required],
      password: [undefined, Validators.required],
    });
  }

  get forms(): { [key: string]: AbstractControl } {
    return this.registerForm.controls;
  }
  onSubmit(registerData: any): void {
    this.submitted=true;
    this.register.username=registerData.username;
    this.register.email=registerData.email;
    this.register.contactNumber=registerData.contactNumber;
    this.register.password=registerData.password;


    if(this.registerForm.valid){
      this.registerUser(this.register);
    }
  }

  registerUser(register:any){
      this.registerService.onRegisterUser(register).subscribe(
        (response:any)=>{
          this.isSubmitting=false;
          this.router.navigate(['auth/login'])
        },
        (error:any)=>{
          this.isSubmitting=false;
        }
      )
  }
}
