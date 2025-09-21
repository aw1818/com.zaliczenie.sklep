import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

  productForm = new FormGroup({
    name: new FormControl(),
    description: new FormControl(),
    price: new FormControl(),
    imageUrl: new FormControl()
  });

  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<AddProductComponent>) { }

  ngOnInit(): void {
  }

  addProduct() {
    console.log(this.productForm.value);
    return this.dialogRef.close(this.productForm.value);
  }

}
