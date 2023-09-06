import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProcessamentoArquivoRoutingModule} from './processamento-arquivo-routing.module';
import {ImportarArquivoComponent} from './importar-arquivo/importar-arquivo.component';
import {FileUploadModule} from "primeng/fileupload";
import {ProgressSpinnerModule} from "primeng/progressspinner";
import {DialogModule} from "primeng/dialog";
import {ToastModule} from "primeng/toast";
import {TabViewModule} from "primeng/tabview";
import {TableModule} from "primeng/table";
import {RippleModule} from "primeng/ripple";
import {ButtonModule} from "primeng/button";


@NgModule({
  declarations: [
    ImportarArquivoComponent
  ],
  imports: [
    CommonModule,
    ProcessamentoArquivoRoutingModule,
    FileUploadModule,
    ProgressSpinnerModule,
    DialogModule,
    ToastModule,
    TabViewModule,
    TableModule,
    RippleModule,
    ButtonModule,
  ]
})
export class ProcessamentoArquivoModule { }
