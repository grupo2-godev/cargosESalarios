import { Injectable, Inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {Nivel} from '../model/nivel/nivel';

@Injectable({
  providedIn: 'root'
})
export class NivelService {

  constructor(private http: HttpClient) { }

  get(): Observable<Nivel[]> {
    return this.http.get<Nivel[]>(environment.baseUrl + 'nivel/all');
  }

  getById(id: number): Observable<Nivel> {
    return this.http.get<Nivel>(environment.baseUrl + 'nivel/'+id);
  }
}
