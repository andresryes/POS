import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {
  total = 100;
  shapeShiftAltcoins = [{name:"LTC", image:"https://shapeshift.io/images/coins-sm/litecoin.png"},{name:"AE", image:"https://shapeshift.io/images/coins-sm/aeternity.png"}, {name:"QTUM", image:"https://shapeshift.io/images/coins-sm/qtum.png"}];
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getCoins()
      .subscribe(res => {
        //this.shapeShiftAltcoins = res;
        console.log(res)
        console.log(this.shapeShiftAltcoins)
      }, err => {
        console.log(err);
      });
  }

  getCoins():Observable<any>{
      return this.http.get("https://shapeshift.io/getcoins");
  }
}
