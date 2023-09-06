import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, share} from "rxjs";
import {Params} from "@angular/router";
import {NotificationService} from "./notification.service";


@Injectable({providedIn: 'root'})
export class ApiService {

  private readonly errorMessage = 'Falha na comunicação com o serviço de Processamento de Arquivos.' +
    ' Tente novamente mais tarde ou contate o administrador.';

  constructor(private http: HttpClient, private notification: NotificationService) {
  }

  public get<T = any>(url: string, params: any = null): Observable<T> {
    return this.http.get<T>(url, {params: params})
      .pipe(share(),response => this.validation(response));
  }

  public getBlob<T = any>(url: string, params: Params = []): Observable<T> {
    return this.http.get<T>(url, {responseType: 'blob' as 'json', params: params})
      .pipe(share(),response => this.validation(response));
  }

  public post<T = any>(url: string, body: any, params: any = null): Observable<T> {
    return this.http.post<T>(url, body, {params: params})
      .pipe(share(),response => this.validation(response));
  }

  public postFormData<T = any>(url: string, object: any, params: Params = []): Observable<T> {
    return this.http.post<T>(url, object, {headers: this.headerWithFormData, params: params})
      .pipe(share(),response => this.validation(response));
  }

  public put<T = any>(url: string, body: any, params: any = null): Observable<T> {
    return this.http.put<T>(url, body, {params: params})
      .pipe(share(),response => this.validation(response));
  }

  public putFormData<T = any>(url: string, object: any, params: Params = []): Observable<T> {
    return this.http.put<T>(url, object, {headers: this.headerWithFormData, params: params})
      .pipe(share(),response => this.validation(response));
  }

  public delete<T = any>(url: string, params: any = null): Observable<T> {
    return this.http.delete<T>(url, {params: params})
      .pipe(share(),response => this.validation(response));
  }

  private get headerWithFormData(): HttpHeaders {
    return new HttpHeaders().append('enctype', 'multipart/form-data')
  }

  private validation<T = any>(response: Observable<T>): Observable<T> {
    response.subscribe({
      error: err => {
        if (err.status !== undefined && err.status === 0) {
          this.notification.error(this.errorMessage)
        }
      }
    });
    return response;
  }

}
