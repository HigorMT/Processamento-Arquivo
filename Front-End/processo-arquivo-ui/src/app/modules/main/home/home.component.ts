import {Component, LOCALE_ID, OnInit} from '@angular/core';
import {HomeService} from "../../../common/service/home.service";
import {Info} from "../../../common/model/Info";
import {NotificationService} from "../../../common/service/notification.service";
import {Params} from "@angular/router";
import * as moment from "moment";
import localePt from '@angular/common/locales/pt';
import {registerLocaleData} from "@angular/common";
import {Processamento} from "../../../common/model/Processamento";
import {ProcessamentoService} from "../../../common/service/processamento.service";
import {Agente} from "../../../common/model/Agente";

registerLocaleData(localePt);

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [{provide: LOCALE_ID, useValue: 'pt' }]
})
export class HomeComponent implements OnInit {

  public rotate = false;
  public info: Info | undefined;
  public dataInicial: Date | undefined;
  public dataFinal: Date | undefined;
  public arquivos: Processamento[] = []
  public agentes: Agente[] = [];
  constructor(private service: HomeService, private notification: NotificationService,
              private processamentoService: ProcessamentoService) {
  }

  public ngOnInit(): void {
    this.onLoadInfo();
    this.onLoadProcess();
  }

  private onLoadInfo(): void {
    this.service.getInfo(this.getParams).subscribe({
      next: response => {
        this.info = response;
      },
      error: err => {
        if (err.status === undefined || err.status !== 0) {
          this.notification.error(err);
        }
      }
    })
  }

  private get getParams(): Params {
    const params: Params = []

    if (this.dataInicial) {
      params['dataInicial'] = moment(this.dataInicial).format('dd/MM/yyyy')
    }

    if (this.dataFinal) {
      params['dataFinal'] = moment(this.dataFinal).format('dd/MM/yyyy')
    }

    return params
  }

  private onLoadProcess(): void {
    this.processamentoService.getAll().subscribe({
      next: values => {
        this.arquivos = values
      },
      error: err => {
        if (err.status === undefined || err.status !== 0) {
          this.notification.error(err);
        }
      }
    })
  }

}
