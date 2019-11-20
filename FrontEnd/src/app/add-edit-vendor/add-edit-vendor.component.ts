
import { Component, OnInit } from '@angular/core';
import { VendorContact } from '../VendorContact';
import { Router, ActivatedRoute } from '@angular/router';
import { AddEditService } from './add-edit.service';

@Component({
  selector: 'app-add-edit-vendor',
  templateUrl: './add-edit-vendor.component.html',
  styleUrls: ['./add-edit-vendor.component.scss']
})
export class AddEditVendorComponent implements OnInit {

  constructor(private router:Router,private _addVendor:AddEditService,private route:ActivatedRoute) { }

  vendor=new VendorContact();

  ngOnInit() {

    this.route.params.subscribe( params=>this.getVendorById(params['vId']));
  }


  addVendor():void{
    this._addVendor.addVendor(this.vendor).subscribe((vendor)=>{ 
    console.log(vendor);
    this.reset();
    this.router.navigate(['/viewVendor']);
  },(error)=>{console.log(error);});
}


private reset(){
  this.vendor.vId = null;
  this.vendor.vendorName = null;
  this.vendor.address=null;
  this.vendor.location = null;
  this.vendor.service = null;
  this.vendor.pinCode = null;
  this.vendor.contactName = null;
  this.vendor.department = null;
  this.vendor.email = null;
  this.vendor.phone= null;
}


getVendorById(vId: string)
{
  console.log(vId);
  this._addVendor.getVendorById(vId).subscribe((vendorData)=>{
    this.vendor=vendorData;
    console.log(vendorData);
  },(error)=>{
    console.log(error);
  });
}


updateVendor():void{
  this._addVendor.addVendor(this.vendor).subscribe((vend)=>{
    console.log(vend);
    this.router.navigate(['/viewVendor']);
  },(error)=>{
    console.log(error);
  });
  
}

Logout()
  {
    this.router.navigate(['/Login']);   
  }


Back()
{
  this.router.navigate(['/viewVendor']);
}


}
