import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { CBO2002 } from '../model/cbo2002/cbo2002';

@Injectable({
  providedIn: 'root'
})
export class Cbo2002Service {

  constructor(private http: HttpClient) { }

  get(): Observable<CBO2002[]> {
    return this.http.get<CBO2002[]>(environment.baseUrl + 'CBO2002/all');
  }

  getById(id: number): Observable<CBO2002> {
    return this.http.get<CBO2002>(environment.baseUrl + 'CBO2002/'+ id);
  }

  post(cbo2002: CBO2002): Observable<CBO2002[]> {
    return this.http.post<CBO2002[]>(environment.baseUrl + 'CBO2002', cbo2002);
  }

  put(cbo2002: CBO2002): Observable<CBO2002[]> {
    return this.http.put<CBO2002[]>(environment.baseUrl + 'CBO2002/'+cbo2002.codigoCBO2002, cbo2002);
  }

  delete(id: number): Observable<CBO2002[]> {
    return this.http.delete<CBO2002[]>(environment.baseUrl + 'CBO2002/'+ id);
  }

}
