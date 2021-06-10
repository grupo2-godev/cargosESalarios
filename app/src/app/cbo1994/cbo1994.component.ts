import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CBO1994 } from '../model/cbo1994/cbo1994';
import { Cbo1994Service } from './cbo1994.service';

@Component({
  selector: 'app-cbo1994',
  templateUrl: './cbo1994.component.html',
  styleUrls: ['./cbo1994.component.css']
})
export class Cbo1994Component implements OnInit {

  constructor(private cbo1994Service: Cbo1994Service, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  form!: FormGroup;
  cbo1994!: CBO1994;
  cbos1994!: CBO1994[];
  cbos94: CBO1994[] = [];


  ngOnInit(): void {
    this.get();

    this.form = this.formBuilder.group({
      codigo_cbo: ['' , Validators.required],
      descricao: ['', Validators.required],
      percentualInsalubridade: ['', Validators.required],
      percentualPericulosidade: ['', Validators.required]
    })
  }

  get() {
    this.cbo1994Service.get().subscribe(result => {
      this.cbos94 = result;
    })
  }

  getById(id: number) {
    this.cbo1994Service.getById(id).subscribe(result => {
      this.cbo1994 = result;

      this.form.setValue({
        codigo_cbo: this.cbo1994.codigo_cbo,
        descricao: this.cbo1994.descricao,
        percentualInsalubridade: this.cbo1994.percentualInsalubridade,
        percentualPericulosidade: this.cbo1994.percentualPericulosidade,
      })
    })
  }

  create() {

    this.cbo1994 = this.form.value


    this.cbo1994Service.post(this.cbo1994).subscribe(result => {
      this.router.navigateByUrl("CBO1994/all");
    })
  }

}
