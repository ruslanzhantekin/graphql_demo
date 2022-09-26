import { Component, OnInit } from '@angular/core';
import {
  AddQtyGQL,
  FetchCartGQL,
  FetchCartQuery,
  FetchCartQueryVariables,
  RemoveQtyGQL
} from "../../../generated/types";
import { QueryRef } from "apollo-angular";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  subscription: QueryRef<FetchCartQuery, FetchCartQueryVariables> | undefined;
  data: FetchCartQuery | undefined;

  constructor(private cartGQL: FetchCartGQL,
              private addQtyGQL: AddQtyGQL,
              private removeQtyGQL: RemoveQtyGQL) {
  }

  addQty(id: string): void {
    if (id == null) return;

    this.addQtyGQL.mutate({itemId: id}).subscribe();
    this.subscription?.refetch()
  }

  removeQty(id: string): void {
    if (id == null) return;

    this.removeQtyGQL.mutate({itemId: id}).subscribe();
    this.subscription?.refetch()
  }

  ngOnInit(): void {
    this.subscription = this.cartGQL.watch()
    this.subscription.valueChanges.subscribe(value => this.data = value.data)
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/