import { Injectable } from '@angular/core';
import {MenuItem} from "primeng/api";

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  //region Atributos
  public itens: MenuItem[] = [];
  public backup: MenuItem[] = [];
  //endregion

  constructor() {
    this.itens = [
      {
      label: 'Home',
      icon: 'pi pi-home',
      routerLink: ['/pages/home']
      },
      {
        label: 'Importação de Arquivos',
        icon: 'pi pi-users',
        routerLink: ['/main/processamento-arquivo/']
      },
    ];
    this.backup = JSON.parse(JSON.stringify(this.itens))
  }

  public init(): MenuItem[] {
    return this.itens;
  }

  public updateMenu(itens: MenuItem[]): void {
    this.itens = itens;
  }

  public resetMenu(): void {
    this.updateMenu(this.backup);
  }


}
