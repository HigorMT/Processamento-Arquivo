import {Injectable} from '@angular/core';
import {ApiService} from "./api.service";
import {environment} from "../../../environments/environment";
import {Params} from "@angular/router";
import {Observable} from "rxjs";
import {Info} from "../model/Info";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private readonly url = `${environment.apiURL}/home`
  constructor(private service: ApiService) {
  }

  getInfo(params?: Params): Observable<Info> {
    return this.service.get(this.url, params)
  }

}
