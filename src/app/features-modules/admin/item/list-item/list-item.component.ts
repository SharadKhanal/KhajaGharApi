import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../item.model';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.scss']
})
export class ListItemComponent implements OnInit {
items:Item[]=[];
  constructor(
    private itemService:ItemService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.getItems()
  }

 public getItems(){
  this.itemService.listAllItems().subscribe((data:any)=>{
    this.items=data.items;
  });
  }

  onDeleteUser(value:any){
    if(confirm("Are you sure to remove this item from the list!!")){
      this.itemService.removeItem(value).subscribe(
        (response:any)=>{
          this.ngOnInit();
        },
        (error:any)=>{
          console.error("Error occurred during removing item!!")
        }
      )
    }
  }

  onEditItem(id:any){
    this.router.navigate(['/khajaghar/admin/item/edit-item/'+id])
  }

  onAddNewItem(){
    this.router.navigate(['/khajaghar/admin/item/add-item'])
  }

}
