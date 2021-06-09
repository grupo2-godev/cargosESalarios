import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cargo } from 'src/app/cargo/cargo';
import { environment } from 'src/environments/environment'


@Injectable({
  providedIn: 'root'
})
export class CargoService {

  constructor(private http: HttpClient, @Inject('BASE_URL') private baseUrl: string) { }

  get(): Observable<Cargo[]> {
    return this.http.get<Cargo[]>(environment.baseUrl + 'cargos/all');
  }

  getById(id: number): Observable<Cargo> {
    return this.http.get<Cargo>(environment.baseUrl + 'cargos/'+id);
  }

  post(cargo: Cargo): Observable<Cargo[]> {
    return this.http.post<Cargo[]>(environment.baseUrl + 'cargos', cargo);
  }

  put(cargo: Cargo): Observable<Cargo[]> {
    return this.http.put<Cargo[]>(environment.baseUrl + 'cargos/'+cargo.idCargo, cargo);
  }

  delete(id: number): Observable<Cargo[]> {
    return this.http.delete<Cargo[]>(environment.baseUrl + 'cargos/'+id);
  }
}
