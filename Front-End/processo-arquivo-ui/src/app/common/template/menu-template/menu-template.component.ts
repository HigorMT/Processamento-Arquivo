import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MenuItem} from "primeng/api";
import {MenuService} from "../../service/menu.service";

@Component({
  selector: 'menu-template',
  templateUrl: './menu-template.component.html',
  styleUrls: ['./menu-template.component.scss']
})
export class MenuTemplateComponent implements OnInit {



  constructor(private router: Router, private route: ActivatedRoute, private menu: MenuService) {
  }

  public ngOnInit(): void {

  }

}
