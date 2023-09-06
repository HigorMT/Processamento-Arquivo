import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DefaultTemplateComponent} from "./common/template/default-template/default-template.component";
import {PageNotFoundComponent} from "./common/template/page-not-found/page-not-found.component";

const routes: Routes = [
  {
    path: '', component: DefaultTemplateComponent,
    children: [
      {path: '', redirectTo: 'main', pathMatch: 'full'},
      {path: 'main', loadChildren: () => import('./modules/main/main.module').then(main => main.MainModule) },
      {path: '**', component: PageNotFoundComponent}
    ]
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, scrollPositionRestoration: 'enabled', anchorScrolling:'enabled'})],
  exports: [RouterModule],
})
export class AppRoutingModule { }
