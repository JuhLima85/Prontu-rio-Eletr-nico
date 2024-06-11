import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Atendimento } from '../domain/atendimento';
import { environment } from '../environments/environment';
import { Pagina } from '../domain/paginacao';
import { tap } from 'rxjs/operators'; 

@Injectable({
  providedIn: 'root'
})
export class AtendimentoService {

  apiUrl: string = environment.apiBaseUrl + 'atendimentos';

  constructor(
    private http: HttpClient
  ) { }

  /*save(pacienteid: number, atendimento: Atendimento) : Observable<Atendimento>{
    return this.http.post<Atendimento>(`${this.apiUrl}/${pacienteid}`, atendimento);
  }*/

  save(pacienteid: number, atendimento: Atendimento): Observable<Atendimento> {
    return this.http.post<Atendimento>(`${this.apiUrl}/${pacienteid}`, atendimento)
      .pipe(
        tap((response: Atendimento) => console.log('Retorno da API:', response))
      );
  }

  list(page: number, size: number): Observable<Pagina<Atendimento>> {
    const params = new HttpParams().set('page', page).set('size', size);    
    return this.http.get<Pagina<Atendimento>>(`${this.apiUrl}`, { params });
  }
}
