import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-default-template',
  templateUrl: './default-template.component.html',
  styleUrls: ['./default-template.component.scss']
})
export class DefaultTemplateComponent implements OnInit {

  public menuItems: MenuItem[] = [];

  constructor() {
    this.menuItems = [
      {
        label: 'Home',
        icon: 'pi pi-home',
        routerLink: ['/main/home']
      },
      {
        label: 'Importação de Arquivos',
        icon: 'pi pi-file',
        routerLink: ['/main/processamento-arquivo/']
      },
    ];

  }

  public ngOnInit(): void {
  }

}
