import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {
  MatInputModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatSortModule,
  MatTableModule,
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatMenuModule,
  MatTabsModule,  MatDialogModule, MatSelectModule, MatListModule } from "@angular/material";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { CategoriesComponent } from './categories/categories.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { PlacesComponent } from './places/places.component';
import { UsersComponent } from './users/users.component';
import { CustomersComponent } from './customers/customers.component';
import { NavbarComponent } from './template/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { TransactionDetailsComponent } from './transaction-details/transaction-details.component';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { HistoryComponent } from './main/history/history.component';
import { PosComponent } from './main/pos/pos.component';
import { ReportsComponent } from './main/reports/reports.component';
import { TicketComponent } from './main/ticket/ticket.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NavComponent } from './nav/nav.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LineItemModalComponent } from './main/history/line-item-modal/line-item-modal.component';
import { LineChartComponent } from './main/reports/line-chart/line-chart.component';
import { PosService } from './pos.service';
import { AdminComponent } from './admin/admin.component';


@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductDetailComponent,
    ProductAddComponent,
    ProductEditComponent,
    CategoriesComponent,
    TransactionsComponent,
    PlacesComponent,
    UsersComponent,
    CustomersComponent,
    NavbarComponent,
    HomeComponent,
    TransactionDetailsComponent,
    LoginComponent,
    MainComponent,
    HistoryComponent,
    PosComponent,
    ReportsComponent,
    TicketComponent,
    WelcomeComponent,
    NavComponent,
    PageNotFoundComponent,
    LineItemModalComponent,
    LineChartComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    MatMenuModule,
    MatListModule,
    MatSelectModule,
    MatDialogModule,
    MatTabsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule
  ],
  providers: [PosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
