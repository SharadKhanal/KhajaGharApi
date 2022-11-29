import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './add-item/add-item.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { ListItemComponent } from './list-item/list-item.component';

const routes: Routes = [
  {
    path:'',
    component:ListItemComponent
  },
  {
    path:'add-item',
    component:AddItemComponent
  },
  {
    path:'edit-item/:id',
    component:EditItemComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ItemRoutingModule { }