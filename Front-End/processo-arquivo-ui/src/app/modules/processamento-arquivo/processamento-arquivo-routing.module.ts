import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ImportarArquivoComponent} from "./importar-arquivo/importar-arquivo.component";

const routes: Routes = [
  {path: '', component: ImportarArquivoComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcessamentoArquivoRoutingModule { }
