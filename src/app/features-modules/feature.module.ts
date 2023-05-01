import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeatureRoutingModule } from './feature-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ClientHomeComponent } from './client/client-home/client-home.component';


@NgModule({
  declarations: [
    
  ],
  imports: [
    CommonModule,
    FeatureRoutingModule,
    HttpClientModule
    
  ]
})
export class FeatureModule { }
