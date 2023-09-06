import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Processamento} from "../model/Processamento";

@Injectable({
  providedIn: 'root'
})
export class ProcessamentoArquivoService {

  private readonly url = `${environment.apiURL}/importar`
  constructor(private service: ApiService) { }

  importar(file: FormData): Observable<Processamento> {
    return this.service.postFormData(`${this.url}`, file)
  }


}
