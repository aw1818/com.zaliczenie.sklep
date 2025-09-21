import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {AddProductComponent} from '../../products/add-product/add-product.component';
import {ProductsService} from '../../products/service/products.service';
import {Product} from '../../products/product-model';
import {CurrenciesService} from '../../currencies/currencies.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  currencies: string[] = [];
  selectedCurrency: string = "";

  constructor(private dialog: MatDialog,
              private productsService: ProductsService,
              private currenciesService: CurrenciesService) { }

  ngOnInit(): void {
    this.currenciesService.getCurrenciesList()
      .subscribe(currencies => this.currencies = currencies);
  }

  addProduct() {
    this.dialog.open(AddProductComponent)
      .afterClosed()
      .subscribe((result: Product) => {
        this.productsService.addNewProduct(result)
          .subscribe(() => {
            this.productsService.fetchAllProducts();
          })
      });
  }
}
