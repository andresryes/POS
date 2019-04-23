import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import {Place} from '../place';

@Component({
  selector: 'app-places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.scss']
})

export class PlacesComponent implements OnInit {

  data: Place[] = [];
  isLoadingResults = true;
  displayedColumns: string[] = ['id', 'name'];

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.api.getPlaces()
      .subscribe(res => {
        this.data = res;
        console.log(this.data);
        this.isLoadingResults = false;
      }, err => {
        console.log(err);
        this.isLoadingResults = false;
      });
  }
}
