import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MainModule} from "./modules/main/main.module";
import {ProcessamentoArquivoModule} from "./modules/processamento-arquivo/processamento-arquivo.module";
import {CommonModule, HashLocationStrategy, LocationStrategy} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {MenubarModule} from "primeng/menubar";
import {CardModule} from "primeng/card";
import {TableModule} from "primeng/table";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {InputTextModule} from "primeng/inputtext";
import {ToastModule} from "primeng/toast";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
import { PageNotFoundComponent } from './common/template/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    MainModule,
    ProcessamentoArquivoModule,
    FormsModule,
    MenubarModule,
    CardModule,
    TableModule,
    HttpClientModule,
    BrowserAnimationsModule,
    InputTextModule,
    ConfirmDialogModule,
    ToastModule,
    ButtonModule,
    RippleModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
