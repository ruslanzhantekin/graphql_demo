import { Component, OnInit } from '@angular/core';
import { FetchAllProductsGQL, FetchAllProductsQuery } from "../../../generated/types";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  data: FetchAllProductsQuery | undefined;

  constructor(private allProductsGQL: FetchAllProductsGQL) {
  }

  share() {
    window.alert('The product has been shared!');
  }

  ngOnInit(): void {
      this.allProductsGQL
        .fetch()
        .subscribe(value => this.data = value.data)
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/