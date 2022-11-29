import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ItemRoutingModule } from './item-routing.module';
import { AddItemComponent } from './add-item/add-item.component';
import { ListItemComponent } from './list-item/list-item.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AddItemComponent,
    ListItemComponent,
    EditItemComponent
  ],
  imports: [
    CommonModule,
    ItemRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class ItemModule { }
