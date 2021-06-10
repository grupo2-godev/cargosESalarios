import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cargo } from 'src/app/cargo/cargo';
import { CargoService } from 'src/app/cargo/cargo.service';
import { Cbo1994Service } from '../cbo1994/cbo1994.service';
import { Cbo2002Service } from '../cbo2002/cbo2002.service';
import { CBO1994 } from '../model/cbo1994/cbo1994';
import { CBO2002 } from '../model/cbo2002/cbo2002';
import { GrauInstrucao } from '../model/grauinstrucao/grauinstrucao';
import { HorasMes } from '../model/horasmes/horasmes';
import { GrauInstrucaoService } from '../services/grau-instrucao.service';
import { HoraMesService } from '../services/hora-mes.service';

@Component({
  selector: 'app-cargo',
  templateUrl: './cargo.component.html',
  styleUrls: ['./cargo.component.css']
})
export class CargoComponent implements OnInit {

  constructor(private cargoService: CargoService,
    private cbo94Service: Cbo1994Service,
    private cbo02Service: Cbo2002Service,
    private horasMesService: HoraMesService,
    private grauInstrucaoService: GrauInstrucaoService,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute) { }

  form!: FormGroup;
  cargo!: Cargo;
  cargoModal!: Cargo;
  cargos!: Cargo[];
  cbos94: CBO1994[] = [];
  cbo94!: CBO1994;
  cbos02: CBO2002[] = [];
  cbo2002!: CBO2002;
  grauInstrucoes: GrauInstrucao[] = [];
  horasMeses: HorasMes[] = [];
  horasMes!: HorasMes;
  grauInstrucao!: GrauInstrucao;

  ngOnInit() {
    this.get();

    this.form = this.formBuilder.group({
      idCargo: [],
      nomeCargo: ['', Validators.required],
      experienciaMinima: ['', Validators.required],
      atribuicoes: ['', Validators.required],
      horasMes: ['', Validators.required],
      cbo2002: ['', Validators.required],
      cbo94: ['', Validators.required],
      grauInstrucao: ['', Validators.required]

    })
  }

  get() {
    this.cargoService.get().subscribe(result => {
      this.cargos = result;
      this.cbo94Service.get().subscribe(cbos94 => {
        this.cbos94 = cbos94
        this.cbo02Service.get().subscribe(cbos02 => {
          this.cbos02 = cbos02
          this.horasMesService.get().subscribe(horasMes => {
            this.horasMeses = horasMes
            this.grauInstrucaoService.get().subscribe(grauInstrucao => {
              this.grauInstrucoes = grauInstrucao
            })
          })
        })
      })
    })
  }

  getById(id: number) {
    this.cargoService.getById(id).subscribe(result => {
      this.cargo = result;
      this.form.setValue({
        idCargo: this.cargo.idCargo,
        nomeCargo: this.cargo.nomeCargo,
        horasMes: this.cargo.horasMes,
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
    console.log(this.form.value)

    this.cargo = this.form.value

    this.cargoService.post(this.cargo).subscribe(result => {
      this.router.navigateByUrl("cargos");
    })
  }

  getModal(cargo: Cargo) {
    this.cargoModal = cargo;
  }

}
