import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'no-content',
  templateUrl: './no-content.component.html',
  styleUrls: ['./no-content.component.css']
})
export class NoContentComponent implements OnInit {

  //region Atributos
  @Input() public message = 'Sem Conteúdo'
  @Input() public visible = false;
  //endregion

  //region Construtor
  constructor() { }
  //endregion

  //region Metodos
  public ngOnInit(): void {
  }
  //endregion

}
