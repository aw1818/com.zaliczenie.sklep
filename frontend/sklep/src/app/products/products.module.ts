import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductsListComponent} from './products-list/products-list.component';
import {RouterModule} from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import { AddProductComponent } from './add-product/add-product.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';

const routes = [
  {
    path: "",
    component: ProductsListComponent
  }
];

@NgModule({
  declarations: [
    ProductsListComponent,
    AddProductComponent
  ],
  exports: [
    ProductsListComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatTableModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
  ]
})
export class ProductsModule {}
