import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VendorContact } from '../VendorContact';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViewVendorService {

  constructor(private _httpService:HttpClient) { }


  getAllVendors(): Observable<VendorContact[]>
  {
    return this._httpService.get<VendorContact[]>(environment.APIUrl+'/vendorDetails');
  }


  disableVend(vend:VendorContact){
    let body=JSON.stringify(vend);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    return this._httpService.put(environment.APIUrl+'/disableVendor',body,options);
  }

  searchVendor(search: string): Observable<VendorContact[]>{
    return this._httpService.get<VendorContact[]>(environment.APIUrl+'/searchVendor/'+search);
  }
}
