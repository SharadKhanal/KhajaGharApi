import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {
  users:User[]=[]
  constructor(
    private userService:UserService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.getUser();
  }

  public getUser(){
    this.userService.listAllUsers().subscribe((data:any)=>{
      this.users=data.users;
    });
  }

  onDeleteUser(value:any){
    if(confirm('Are you sure to remove this user.')){
      this.userService.removeUser(value).subscribe  (
        (response:any)=>{
          this.ngOnInit();
        },
        (error:any)=>{
          console.log("Error occur during deleting!!")
        }
      )
    }
  }

  onEditCourse(){

  }

}
