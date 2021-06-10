import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CBO2002 } from '../model/cbo2002/cbo2002';
import { Cbo2002Service } from './cbo2002.service';

@Component({
  selector: 'app-cbo2002',
  templateUrl: './cbo2002.component.html',
  styleUrls: ['./cbo2002.component.css']
})

export class Cbo2002Component implements OnInit {

  constructor(private cbo2002Service: Cbo2002Service, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  form!: FormGroup;
  cbo2002!: CBO2002;
  cbos2002!: CBO2002[];
  cbos02: CBO2002[] = [];

  ngOnInit(): void {
    this.get();

    this.form = this.formBuilder.group({
      codigoCbo: ['' , Validators.required],
      descricao: ['', Validators.required],
      percentualInsalubridade: ['', Validators.required],
      percentualPericulosidade: ['', Validators.required]
    })
  }

  get() {
    this.cbo2002Service.get().subscribe(result => {
      this.cbos02 = result;
    })
  }

  getById(id: number) {
    this.cbo2002Service.getById(id).subscribe(result => {
      this.cbo2002 = result;

      this.form.setValue({
        codigo_cbo: this.cbo2002.codigoCBO2002,
        descricao: this.cbo2002.descricao,
        percentualInsalubridade: this.cbo2002.percentualInsalubridade,
        percentualPericulosidade: this.cbo2002.percentualPericulosidade,
      })
    })
  }

  create() {

    this.cbo2002 = this.form.value


    this.cbo2002Service.post(this.cbo2002).subscribe(result => {
      this.router.navigateByUrl("CBO2002/all");
    })
  }

}
