import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ProductsService} from '../service/products.service';
import {map, Observable} from 'rxjs';
import {Product} from '../product-model';
import {CurrenciesService} from '../../currencies/currencies.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.scss']
})
export class ProductsListComponent implements OnInit, OnChanges {
  @Input()
  currency: string = "";

  constructor(private productsService: ProductsService, private currenciesService: CurrenciesService) { }

  protected products$!: Observable<Product[]>;

  displayedColumns = ['imageUrl', 'name', 'description', 'price'];

  ngOnInit(): void {
    this.products$ = this.productsService.getProductsList();
    this.productsService.fetchAllProducts();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['currency']) {
      this.convertCurrency(changes);
    }
  }

  private convertCurrency(changes: SimpleChanges) {
    this.productsService.fetchAllProducts();
    this.products$ = this.productsService.getProductsList().pipe(
      map(products => products.map(
        product => {
          this.currenciesService.convert({
            fromCurrency: "PLN",
            toCurrency: this.currency,
            amount: product.price
          })
            .subscribe(converted => product.price = converted);
          return product;
        }
      ))
    );
  }

}
