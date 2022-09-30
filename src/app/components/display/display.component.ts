import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  should_open: boolean = false;

  constructor(private http : HttpClient) { }

  ngOnInit(): void {
  }
  openPackage(){
    this.should_open = true;
   }
   submit(id: Number, src: string, dist : string) {
    return this.http.post('http://localhost:8080/packages/',
       { id,src, dist });
}


}
