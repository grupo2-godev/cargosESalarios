import { Injectable, Inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {HorasMes} from '../model/horasmes/horasmes';

@Injectable({
  providedIn: 'root'
})
export class HoraMesService {

  constructor(private http: HttpClient) { }

  get(): Observable<HorasMes[]> {
    return this.http.get<HorasMes[]>(environment.baseUrl + 'horasmes/all');
  }

  getById(id: number): Observable<HorasMes> {
    return this.http.get<HorasMes>(environment.baseUrl + 'horasmes/'+id);
  }
}
