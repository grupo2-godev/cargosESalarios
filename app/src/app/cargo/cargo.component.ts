import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cargo } from 'src/app/cargo/cargo';
import { CargoService } from 'src/app/cargo/cargo.service';
import { Cbo1994Service } from '../cbo1994/cbo1994.service';
import { CBO1994 } from '../model/cbo1994/cbo1994';
import { CBO2002 } from '../model/cbo2002/cbo2002';
import { GrauInstrucao } from '../model/grauinstrucao/grauinstrucao';
import { HorasMes } from '../model/horasmes/horasmes';

@Component({
  selector: 'app-cargo',
  templateUrl: './cargo.component.html',
  styleUrls: ['./cargo.component.css']
})
export class CargoComponent implements OnInit {

  constructor(private cargoService: CargoService,
              private cbo94Service: Cbo1994Service,
              private router: Router,
              private formBuilder: FormBuilder,
              private route: ActivatedRoute) { }

  form!: FormGroup;
  cargo!: Cargo;
  cargos!: Cargo[];
  cbos94: CBO1994[]=[];
  cbo94!: CBO1994;
  cbos2002: CBO2002[] = [];
  grauInstrucao: GrauInstrucao[] = [];
  horasMes: HorasMes[] = [];

  ngOnInit() {
    this.get();

    this.cbo94Service.get().subscribe(cbos94 => this.cbos94 = cbos94)

    this.cbos2002.push(
      {
        codigoCBO2002: 122234,
        descricao: 'CBO NOME',
        percentualInsalubridade: 0,
        percentualPericulosidade: 0
      }
    )

    this.grauInstrucao.push(
      {
        idInstrucao: 12223,
        instrucao: 'CBO NOME'
      }
    )

    this.horasMes.push(
      {
        idHorasMes: 12223,
        quantidade: 220
      }
    )

    this.form = this.formBuilder.group({
      idCargo: [],
      nomeCargo: ['', Validators.required],
      horasMes: [null, Validators.required],
      grauInstrucao: [null, Validators.required],
      experienciaMinima: ['', Validators.required],
      //cbo2002: [null, Validators.required],
      //cbo94: [null, Validators.required],
      atribuicoes: ['', Validators.required]
    })
  }

  get() {
    this.cargoService.get().subscribe(result => {
      this.cargos = result;
    })
  }

  getById(id: number) {
    this.cargoService.getById(id).subscribe(result => {
      this.cargo = result;

      this.form.setValue({
        idCargo: this.cargo.idCargo,
        nomeCargo: this.cargo.nomeCargo,
        horasMes: this.cargo.horaMes,
        grauInstrucao: this.cargo.grauInstrucao,
        experienciaMinima: this.cargo.experienciaMinima,
        cbo2002: this.cargo.cbo2002,
        cbo94: this.cargo.cbo94,
        atribuicoes: this.cargo.atribuicoes
      })
    })
  }

  create() {
    delete this.form.value['idCargo'];

    this.cargo = this.form.value
    this.cargo.cbo94 = this.cbos94[0]
    this.cargo.cbo2002 = this.cbos2002[0]
    this.cargo.grauInstrucao = this.grauInstrucao[0]
    this.cargo.horaMes = this.horasMes[0]

    this.cargoService.post(this.cargo).subscribe(result => {
      this.router.navigateByUrl("cargos");
    })
  }




}
