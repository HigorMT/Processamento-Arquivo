import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Processamento} from "../model/Processamento";
import {ApiService} from "./api.service";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProcessamentoService {

  private readonly url = `${environment.apiURL}/processamento`
  constructor(private service: ApiService) {
  }

  getAll(): Observable<Processamento[]> {
    return this.service.get(this.url);
  }

}
