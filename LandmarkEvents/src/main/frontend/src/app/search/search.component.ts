import { Component, OnInit } from '@angular/core';
import {Search} from "./search.model";
import {SearchService} from "./search.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  category : string;
  location : string;
  text:string;
  result: Event[] = [];
  constructor(private searchService : SearchService) { }

  ngOnInit() {
  }

  search(){
    console.log(this.category,this.location);

    this.searchService.searchInternalQuery(this.category,this.location)
      .subscribe(
        (res : any[]) => {
          this.result = res;
          this.searchService.searchQuery(this.category,this.location)
            .subscribe(
              (res : any[]) => {
                for (var i = 0; i < res['events']['event'].length; i++) {
                  this.result.push(res['events']['event'][i]);
                }
              },
              (error)=> console.log(error)
            );
        },
        (error)=> console.log(error)
      );

    // this.searchService.searchQuery(this.category,this.location)
    //   .subscribe(
    //     (res : any[]) => {
    //       console.log(res);
    //       this.result.push(res['events']['event'])
    //     },
    //     (error)=> console.log(error)
    //   );
  }



}
