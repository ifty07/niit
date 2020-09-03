import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentRegisterComponent } from './student-register/student-register.component';
import { StudentModifyComponent } from './student-modify/student-modify.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { UpdateComponent } from './update/update.component';
import { AppComponent } from './app.component';


const routes: Routes = [
 {path:"register",component:StudentRegisterComponent},
 {path:"search",component:StudentModifyComponent},
 {path:"home",component:HomeComponent},
 {path:"about",component:AboutComponent},
 {path:"update",component:UpdateComponent},
 {path:"",redirectTo:"home",pathMatch:"full"},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
