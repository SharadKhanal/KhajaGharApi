import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeatureRoutingModule } from './feature-routing.module';
import { HttpClientModule } from '@angular/common/http';


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
