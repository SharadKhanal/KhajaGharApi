import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { ClientHomeComponent } from './client-home/client-home.component';
import { ClientComponent } from './client/client.component';


@NgModule({
  declarations: [
    ClientHomeComponent,
    ClientComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule
  ]
})
export class ClientModule { }
