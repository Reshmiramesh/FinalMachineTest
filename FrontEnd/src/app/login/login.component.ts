import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Login } from '../login';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,private _authService:AuthService) { }

  login=new Login();
  message:string;

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.resetForm();
    this._authService.formData = {

      userId: null,
      username: '',
      password: ''
    }
  }
  OnSubmit(form: NgForm) {
    console.log("My form : " + form);
    this.loginUser(form);
  }

  loginUser(form: NgForm) 
  {
      console.log(form.value);
      this._authService.verifyLogin(form.value).subscribe((userData) => {
      this.login = userData;
      console.log(userData);
    
      if(this.login.userId == 100)
      {
        this.router.navigate(['/viewVendor']);
      }
      
      else if(this.login.userId==101)
      {
        this.router.navigate(['/viewVendor']);
      }
      else
      {
        this.message="Invalid username and password";
        console.log(this.message);
          this.router.navigate(['/Login']);
      }

    }, (error) => {
      console.log(error);
    });
  }

}
