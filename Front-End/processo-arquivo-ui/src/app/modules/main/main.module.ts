import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MainRoutingModule} from './main-routing.module';
import {DefaultTemplateComponent} from "../../common/template/default-template/default-template.component";
import {MenuTemplateComponent, NoContentComponent} from "../../common/template";
import {MenubarModule} from "primeng/menubar";
import {ToastModule} from "primeng/toast";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {FormsModule} from "@angular/forms";
import {DropdownModule} from "primeng/dropdown";
import {AutoCompleteModule} from "primeng/autocomplete";
import {TableModule} from "primeng/table";
import {InputMaskModule} from "primeng/inputmask";
import {InputNumberModule} from "primeng/inputnumber";
import {InputTextModule} from "primeng/inputtext";
import {CalendarModule} from "primeng/calendar";
import {StatusBadgeComponent} from "../../common/template/status/status-badge/status-badge.component";
import {ConfirmationService, MessageService} from "primeng/api";
import { HomeComponent } from './home/home.component';
import {CardModule} from "primeng/card";
import {FlipCardComponent} from "../../common/template/flip-card/flip-card.component";
import {RippleModule} from "primeng/ripple";


@NgModule({
  declarations: [
    DefaultTemplateComponent,
    MenuTemplateComponent,
    NoContentComponent,
    StatusBadgeComponent,
    HomeComponent,
    FlipCardComponent
  ],
  exports: [
    MenuTemplateComponent,
    NoContentComponent,
  ],
  imports: [
    CommonModule,
    MainRoutingModule,
    DropdownModule,
    FormsModule,
    AutoCompleteModule,
    ConfirmDialogModule,
    ToastModule,
    MenubarModule,
    TableModule,
    InputMaskModule,
    InputNumberModule,
    InputTextModule,
    CalendarModule,
    CardModule,
    RippleModule
  ],
  providers: [
    ConfirmationService,
    MessageService
  ]
})
export class MainModule { }
