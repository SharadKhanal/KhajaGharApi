import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';


const routes: Routes = [
  
  {
    path:'item',
    loadChildren:()=>
   import('./item/item.module').then((m)=>m.ItemModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
