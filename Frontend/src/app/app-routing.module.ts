import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
const routes: Routes = [
  {
    path: 'products',
    component: ProductsComponent,
    data: { title: 'List of Products' }
  },
  {
    path: 'categories',
    component: CategoriesComponent,
    data: { title: 'List of Products' }
  },
  {
    path: 'transactions',
    component: TransactionsComponent,
    data: { title: 'List of Products' }
  },
  {
    path: 'customers',
    component: CustomersComponent,
    data: { title: 'List of Products' }
  },
  {
    path: 'places',
    component: PlacesComponent,
    data: { title: 'List of Products' }
  },
  {
    path: 'product-details/:id',
    component: ProductDetailComponent,
    data: { title: 'Product Details' }
  },
  {
    path: 'product-add',
    component: ProductAddComponent,
    data: { title: 'Add Product' }
  },
  {
    path: 'product-edit/:id',
    component: ProductEditComponent,
    data: { title: 'Edit Product' }
  },
  { path: '',
    redirectTo: '/products',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
