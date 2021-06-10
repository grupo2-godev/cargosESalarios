import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CBO1994 } from '../model/cbo1994/cbo1994';

@Injectable({
  providedIn: 'root'
})
export class Cbo1994Service {

  constructor(private http: HttpClient) { }

  get(): Observable<CBO1994[]> {
    return this.http.get<CBO1994[]>(environment.baseUrl + 'CBO1994/all');
  }

  getById(id: number): Observable<CBO1994> {
    return this.http.get<CBO1994>(environment.baseUrl + 'CBO1994/'+ id);
  }

  post(cbo1994: CBO1994): Observable<CBO1994[]> {
    return this.http.post<CBO1994[]>(environment.baseUrl + 'CBO1994', cbo1994);
  }

  put(cbo1994: CBO1994): Observable<CBO1994[]> {
    return this.http.put<CBO1994[]>(environment.baseUrl + 'CBO1994/'+cbo1994.codigo_cbo, cbo1994);
  }

  delete(id: number): Observable<CBO1994[]> {
    return this.http.delete<CBO1994[]>(environment.baseUrl + 'CBO1994/'+ id);
  }
}
