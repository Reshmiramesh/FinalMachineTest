import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { ViewVendorDetailsComponent } from './view-vendor-details/view-vendor-details.component';
import { AddEditVendorComponent } from './add-edit-vendor/add-edit-vendor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewVendorDetailsComponent,
    AddEditVendorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPaginationModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
