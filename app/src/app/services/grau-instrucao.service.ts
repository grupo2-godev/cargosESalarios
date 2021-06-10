import { Injectable, Inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {GrauInstrucao} from '../model/grauinstrucao/grauinstrucao';

@Injectable({
  providedIn: 'root'
})
export class GrauInstrucaoService {

  constructor(private http: HttpClient) { }

  get(): Observable<GrauInstrucao[]> {
    return this.http.get<GrauInstrucao[]>(environment.baseUrl + 'grauinstrucao/all');
  }

  getById(id: number): Observable<GrauInstrucao> {
    return this.http.get<GrauInstrucao>(environment.baseUrl + 'grauinstrucao/'+id);
  }
}
