import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AddEditVendorComponent } from './add-edit-vendor/add-edit-vendor.component';
import { ViewVendorDetailsComponent } from './view-vendor-details/view-vendor-details.component';


const routes: Routes = [
  {path: '', redirectTo: 'Login', pathMatch: 'full'},
  {path:'Login', component:LoginComponent},
  {path:'AddVendor', component:AddEditVendorComponent},
  {path:'Logout', component:LoginComponent},
  {path:'viewVendor',component:ViewVendorDetailsComponent},
  {path:'updateVendor/:vId', component:AddEditVendorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
