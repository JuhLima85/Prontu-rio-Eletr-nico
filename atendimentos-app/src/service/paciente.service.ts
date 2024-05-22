import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Paciente } from '../domain/paciente';

import { environment } from '../environments/environment';
import { PaginaContato } from '../domain/paginacao';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  url: string = environment.apiBaseUrl;

  constructor(
    private http: HttpClient
  ) { }

  save(paciente: Paciente) : Observable<Paciente>{
    return this.http.post<Paciente>(this.url, paciente);
  }

  list(page: number, size: number) : Observable<PaginaContato>{
    const params = new HttpParams().set('page', page).set('size',size)    
    return this.http.get<any>(`${this.url}?${params.toString()}`);
  }

  favourite(paciente: Paciente) : Observable<any> {
    return this.http.patch(`${this.url}/${paciente.id}/favorito`, null);
  }

  upload(paciente: Paciente, formData: FormData) : Observable<any>{    
    return this.http.put(`${this.url}/${paciente.id}/foto`, formData, { responseType : 'blob'});
  }
   
   delete(paciente: Paciente): Observable<any> {
    return this.http.delete(`${this.url}/${paciente.id}`);
  }
  
  getContatoById(id: number): Observable<Paciente> {
    return this.http.get<Paciente>(`${this.url}/${id}`);
  }
  
  updatePaciente(paciente: Paciente): Observable<any> {
    return this.http.put(`${this.url}/${paciente.id}`, paciente);
  }
  
}
