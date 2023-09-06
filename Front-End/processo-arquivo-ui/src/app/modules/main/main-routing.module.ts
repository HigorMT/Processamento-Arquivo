import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  { path: '', redirectTo: 'home',  pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'processamento-arquivo', loadChildren: () => import('../processamento-arquivo/processamento-arquivo.module').then(pa => pa.ProcessamentoArquivoModule) }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
