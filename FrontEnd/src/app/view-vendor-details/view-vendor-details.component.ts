import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VendorContact } from '../VendorContact';
import { ViewVendorService } from './view-vendor.service';

@Component({
  selector: 'app-view-vendor-details',
  templateUrl: './view-vendor-details.component.html',
  styleUrls: ['./view-vendor-details.component.scss']
})
export class ViewVendorDetailsComponent implements OnInit {

  constructor(private router:Router,private _viewVendor:ViewVendorService) { }

  vendors:VendorContact[];

  ngOnInit() {

    this.getAllVendors();
  }


  getAllVendors(): void{
    this._viewVendor.getAllVendors()
    .subscribe((vendorData) =>{
      this.vendors=vendorData;    
      console.log(vendorData);
    }, (error) =>{
      console.log(error);
    });
  }

  editVendor(vId: number):void{

    console.log(vId);
    this.router.navigate(['/updateVendor/'+vId]);

}


disableVendor(vend:VendorContact){
  this._viewVendor.disableVend(vend)
  .subscribe((response) =>{
    this.getAllVendors();
  }, (error) =>{
    console.log(error);
  });
}

searchVendor(search: string): void{
  console.log(search);
  this._viewVendor.searchVendor(search)
  .subscribe((vendorData)=>{
    this.vendors=vendorData,
    console.log("Here");
    if(search===undefined){
      console.log("Here");
      this.getAllVendors;
    }
  }, (error) =>{
    console.log(error);
    this.getAllVendors();
  });
}

  
  AddVendor()
  {
    this.router.navigate(['/AddVendor']);   
  }

  
  Logout()
  {
    this.router.navigate(['/Login']);   
  }

}
