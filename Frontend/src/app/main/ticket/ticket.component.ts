import { Component, OnInit } from '@angular/core';
import { Item } from '../../item';
import { PosService } from '../../pos.service';
import { ApiService } from 'src/app/api.service';
import { Transaction } from 'src/app/transaction';


@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.scss']
})
export class TicketComponent implements OnInit {

  ticket: any[] = [];

  cartTotal = 0;
  cartNumItems = 0;

  constructor(private ticketSync: PosService, private apiService:ApiService) { }

  // Sync with ticketSync service on init
  ngOnInit() {
    this.clearCart();
    this.ticketSync.currentTicket.subscribe(data => this.ticket = data);
    this.ticketSync.currentTotal.subscribe(total => this.cartTotal = total);
    this.ticketSync.currentCartNum.subscribe(num => this.cartNumItems = num);
  }

  // Add item to ticket.
  addItem(item: any) {
    // If the item already exists, add 1 to quantity
    if (this.ticket.includes(item)) {
      this.ticket[this.ticket.indexOf(item)].quantity += 1;
    } else {
      this.ticket.push(item);
      this.ticket[this.ticket.indexOf(item)].quantity=1;
    }
    this.syncTicket();
    this.calculateTotal();
  }

  // Remove item from ticket
  removeItem(item: Item) {
    // Check if item is in array
    if (this.ticket.includes(item)) {
      // Splice the element out of the array
      const index = this.ticket.indexOf(item);
      if (index > -1) {
        // Set item quantity back to 1 (thus when readded, quantity isn't 0)
        this.ticket[this.ticket.indexOf(item)].quantity = 1;
        this.ticket.splice(index, 1);
      }
    }
    this.syncTicket();
    this.calculateTotal();
  }

  // Reduce quantity by one
  subtractOne(item: Item) {
    // Check if last item, if so, use remove method
    if (this.ticket[this.ticket.indexOf(item)].quantity === 1) {
      this.removeItem(item);
    } else {
      this.ticket[this.ticket.indexOf(item)].quantity = this.ticket[this.ticket.indexOf(item)].quantity - 1;
    }
    this.syncTicket();
    this.calculateTotal();
  }

  // Calculate cart total
  calculateTotal() {
    let total = 0;
    let cartitems = 0;
    // Multiply item price by item quantity, add to total
    this.ticket.forEach(function(item: Item) {
      total += (item.price * item.quantity);
      cartitems += item.quantity;
    });
    this.cartTotal = total;
    this.cartNumItems = cartitems;
    // Sync total with ticketSync service.
    this.ticketSync.updateNumItems(this.cartNumItems);
    this.ticketSync.updateTotal(this.cartTotal);
  }

  // Remove all items from cart
  clearCart() {
    // Reduce back to initial quantity (1 vs 0 for re-add)
    this.ticket.forEach(function(item: Item) {
      item.quantity = 1;
    });
    // Empty local ticket variable then sync
    this.ticket = [];
    this.syncTicket();
    this.calculateTotal();
  }

  syncTicket() {
    this.ticketSync.changeTicket(this.ticket);
  }

  checkout() {
    if (this.ticket.length > 0) {
      let transaction:Transaction = {"idCustomer":0, "idUser":0, "transactions":"", "total":0};
      transaction.idCustomer = 1;
      transaction.total = 10;
      transaction.idUser = 1;
      transaction.transactions = "1,1"
      var myJSON = JSON.stringify(transaction);
      console.log(myJSON)
      let transactions = "";
      this.ticket.forEach(function(item:any){
        console.log(item.quantity + ","+item.idProduct);
        transactions+= item.idProduct+","+item.quantity+",";
      });
      console.log(this.cartTotal);
      console.log(this.cartNumItems);
      console.log(transactions)
      console.log(transactions.substring(0, transactions.length-1))
      transactions = transactions.substring(0, transactions.length-1);
      //this.db.pushOrder(this.ticket, this.cartTotal, this.cartNumItems);
      this.apiService.addTransaction(transaction, "?idCustomer=1&idUser=1&total="+this.cartTotal+"&transactions="+transactions).subscribe(res => {
        console.log("sent")
      }, (err) => {
        console.log(err);
      });;
      this.clearCart();
    }
  }
}
