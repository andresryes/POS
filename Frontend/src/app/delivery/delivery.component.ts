import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.scss']
})
export class DeliveryComponent implements OnInit {

  places=[];
  selected = 'place';
  selected2 = "";
  route="";
  constructor(private apiService:ApiService) { }

  ngOnInit() {
    this.apiService.getPlaces()
      .subscribe(res => {
        this.places = res;
      }, err => {
        console.log(err);
      });  }

  calculate(){
    this.apiService.getRoute("shortestPath?source="+this.selected2+"&destination="+this.selected).subscribe(res => {
      this.route = res;
    }, err => {
      console.log(err);
    });
  }
}
