import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.scss']
})
export class TransactionsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'customer', 'user', 'transactions','total'];
  data: Transaction[] = [];
  isLoadingResults = true;

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.api.getTransactions()
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
