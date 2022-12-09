import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  currentDate: string | null;

  constructor(
    private date: DatePipe
  ) {
    this.currentDate = this.date.transform(new Date(), 'yyyy-M-dd hh:mm:ss a');
  }

  ngOnInit(): void {
  }

}
