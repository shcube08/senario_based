import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }
  packages:any;
  Press(){
    this.packages= this.packages+this.http.get<any>("http://localhost:8080/packages").subscribe((data:any) => {console.log(data);
  this.packages=data})
  }

}
