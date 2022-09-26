import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { FetchProductByIdGQL, FetchProductByIdQuery } from "../../../generated/types";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  data: FetchProductByIdQuery | undefined;

  constructor(private productByIdGQL: FetchProductByIdGQL,
              private route: ActivatedRoute) {
  }

  share() {
    window.alert('The product has been shared!');
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id != null) {
      this.productByIdGQL
        .fetch({id: id})
        .subscribe(value => this.data = value.data)
    }
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/