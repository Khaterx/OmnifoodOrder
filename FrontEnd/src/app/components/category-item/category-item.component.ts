import {Component, OnInit} from '@angular/core';
import {CategoriesService} from "../../common/services/categories.service";
import {Category} from "../../common/model/category";
import {CommonModule} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-category-item',
  templateUrl: './category-item.component.html',
  styleUrls: ['./category-item.component.scss'],
  standalone:true,
  imports: [CommonModule, RouterLink]
})
export class CategoryItemComponent implements OnInit {
  categories: Category[] = [];
  constructor(public _categoryServ: CategoriesService) {
  }

  ngOnInit(): void {
    this.getAllCategories();
  }

  getAllCategories() {
    this._categoryServ.getAllCategories().subscribe(
      response =>{
        this.categories =response
      }
    )
  }

}
