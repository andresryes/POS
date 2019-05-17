import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Item, Order } from '../../item';
import { PosService } from '../../pos.service';
import {MatTabsModule} from '@angular/material';
import { ApiService } from 'src/app/api.service';
import { Observable } from 'rxjs';
import { Category } from 'src/app/category';


@Component({
  selector: 'app-pos',
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.scss']
})
export class PosComponent implements OnInit {

  firstTime = true;
  products = [];
  productTypes = ["food", "beverage"];
  ticket: any[];
  cartTotal = 0;
  cartNumItems = 0;
  items;

  constructor(private ticketSync: PosService, private apiService:ApiService) { }

  ngOnInit() {
    this.ticketSync.currentTicket.subscribe(data => this.ticket = data);
    this.ticketSync.currentTotal.subscribe(total => this.cartTotal = total);
    this.ticketSync.currentCartNum.subscribe(num => this.cartNumItems);

    this.apiService.getProducts()
    .subscribe(res => {
      let fetchProducts = [[],[]];
      res.forEach(function(item:any){
        if(item.category.idCategory==1){
          //console.log(item.category.idCategory)
          fetchProducts[0].push(item);
          //console.log(item)
        }else{
          fetchProducts[1].push(item);
        }
      });
      //console.log(fetchProducts[0]);
      this.products = fetchProducts
    }, err => {
      console.log(err);
    });


    //this.products[0] = this.apiService.getProducts();
    console.log("222")
    console.log(this.apiService.getProducts())
    //this.products[1] = this.db.getFood();
  }

  addToCheck(item: any) {
    console.log(item.price)
    // If the item already exists, add 1 to quantity
    if (this.ticket.includes(item)) {
      this.ticket[this.ticket.indexOf(item)].quantity += 1;
    } else {
      console.log(item)
      this.ticket.push(item);
      this.ticket[this.ticket.indexOf(item)].quantity=1;
    }
    this.calculateTotal();  
  }

  // Calculate cart total
  calculateTotal() {
    let total = 0;
    let cartNum = 0;
    // Multiply item price by item quantity, add to total
    this.ticket.forEach(function(item: Item) {
      total += (item.price * item.quantity);
      cartNum += item.quantity;
    });
    this.cartTotal = total;
    this.cartNumItems = cartNum;
    this.ticketSync.updateNumItems(this.cartNumItems);
    this.ticketSync.updateTotal(this.cartTotal);
  }

  syncTicket() {
    this.ticketSync.changeTicket(this.ticket);
  }
}
