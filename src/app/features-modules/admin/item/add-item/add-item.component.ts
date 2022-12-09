import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Item } from '../item.model';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.scss']
})
export class AddItemComponent implements OnInit {
itemForm:FormGroup=new FormGroup({});
submitted:boolean=false;
item=new Item();
isSubmitting:boolean=false;
  constructor(
    private formBuilder:FormBuilder,
    private itemService:ItemService
    ) { }

  ngOnInit(): void {
    this.initForm();
  }
  get forms(): { [key: string]: AbstractControl } {
    return this.itemForm.controls;
  }

  initForm(){
    this.itemForm=this.formBuilder.group({
      itemName:[  undefined,Validators.required],
      itemPrice:[undefined,Validators.required],
      validDate:[undefined,Validators.required],
      itemPicture:[undefined]
    })
  }
  onSubmit(itemData:any):void{
  this.submitted=true;
  this.item.itemName=itemData.itemName;
  this.item.itemPrice=itemData.itemPrice;
  this.item.validDate=itemData.validDate;
  this.item.itemPicture=itemData.itemPicture;
    
  if(this.itemForm.valid){
    this.addItem(this.item);
  }
  }

  addItem(item:any){
    this.itemService.onAddItem(item).subscribe(
      (Response:any)=>{
        this.isSubmitting=true;
        this.itemForm.reset()
      },
      (error:any)=>{
        this.isSubmitting=false;
      }
    )

  }
}
