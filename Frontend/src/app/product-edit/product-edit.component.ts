import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {

  productForm: FormGroup;
  id:string='';
  name:string='';
  description:string='';
  price:number=null;
  isLoadingResults = false;

  constructor(private router: Router, private route: ActivatedRoute, private api: ApiService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.getProduct(this.route.snapshot.params['id']);
    this.productForm = this.formBuilder.group({
    });
  }

  getProduct(id) {
    this.api.getProduct(id).subscribe(data => {
      this._id = data._id;
      this.productForm.setValue({
      });
    });
  }

  onFormSubmit(form:NgForm) {
    this.isLoadingResults = true;
    this.api.updateProduct(this.id, form)
      .subscribe(res => {
          let id = res['_id'];
          this.isLoadingResults = false;
          this.router.navigate(['/product-details', id]);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
  }

  productDetails() {
    this.router.navigate(['/product-details', this.id]);
  }

}
