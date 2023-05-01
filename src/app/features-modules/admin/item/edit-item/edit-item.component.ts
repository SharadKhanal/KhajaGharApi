import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../item.model';
import { ItemService } from '../item.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.scss']
})
export class EditItemComponent implements OnInit {
  editItemForm:FormGroup=new FormGroup({});
submitted:boolean=false;
item=new Item();
id:any|number;
isSubmitting:boolean=false;
  constructor(
    private formBuilder:FormBuilder,
    private itemService:ItemService,
    private activatedRoute:ActivatedRoute,
    private router:Router,
    private location:Location
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.activatedRoute.params.subscribe((param)=>{
      this.id=param['id'];
    });
    this.initItemById(this.id);
  }

  get forms(): { [key: string]: AbstractControl } {
    return this.editItemForm.controls;
  }

  initForm(){
    this.editItemForm=this.formBuilder.group({
      itemName:[  undefined,Validators.required],
      itemPrice:[undefined,Validators.required],
      validDate:[undefined],
      itemPicture:[undefined]
    })
  }
  onSubmit(itemData:any):void{
  this.submitted=true;
  this.item.id=this.id;
  this.item.itemName=itemData.itemName;
  this.item.itemPrice=itemData.itemPrice;
  this.item.validDate=itemData.validDate;
  this.item.itemPicture=itemData.itemPicture;
    
  if(this.editItemForm.valid){
    this.editItem(this.item);
  }
  }

  editItem(item:any){
    this.itemService.onEditItem(item,this.id).subscribe(
      (Response:any)=>{
        this.isSubmitting=true;
        this.router.navigate(['/khajaghar/admin/item']);
        console.log("Edited successfully")
        // this.editItemForm.reset()
      },
      (error:any)=>{
        this.isSubmitting=false;
        console.error("Error during editing!!")
      }
    )

  }

  initItemById(id:number){
    this.itemService.getItemById(id).subscribe(
      (response:any)=>{
        this.item=response;
        this.editItemForm.patchValue(this.item);
      },
      (error:any)=>{
        console.error(error);
      }
    )
  }

  onBack(){
    this.location.back();
  }

}
