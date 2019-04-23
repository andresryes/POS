import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import {Category} from '../category';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {
  data: Category[] = [];
  isLoadingResults = true;
  displayedColumns: string[] = ['id', 'name'];

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.api.getCategories()
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
