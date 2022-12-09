import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



const routes: Routes = [
  
  {
    path:'item',
    loadChildren:()=>
   import('./item/item.module').then((m)=>m.ItemModule)
  },
  {
    path:'user',
    loadChildren:()=>
    import('./user/user.module').then((m)=>m.UserModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
