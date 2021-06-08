import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CargoComponent } from './cargo/cargo.component'
import { HomeComponent } from './home/home.component';
import { PostoComponent } from './posto/posto.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'cargos', component: CargoComponent },
  { path: 'home', component: HomeComponent },
  { path: 'postos', component: PostoComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }