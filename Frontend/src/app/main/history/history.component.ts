import { Component, OnInit } from '@angular/core';
import { Order, Item } from '../../item';
import { LineItemModalComponent } from './line-item-modal/line-item-modal.component';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss']
})
export class HistoryComponent implements OnInit {

  history: any;

  constructor(public dialog: MatDialog, private apiService:ApiService) {

  }

  ngOnInit() {
    /*this.db.updateNumRequested(10);
    this.history = this.db.getSnapshot();*/
    this.history = this.apiService.getTransactions();
  }

  openDialog(item:any): void {
    const dialogRef = this.dialog.open(LineItemModalComponent, {
      width: '300px',
      data: { numItems: item.transactions.length,
        orderNumber: item.idTransaction,
        total: item.total }
    });
  }

}