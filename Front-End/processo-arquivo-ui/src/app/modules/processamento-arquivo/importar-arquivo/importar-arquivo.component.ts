import {Component, OnInit, ViewChild} from '@angular/core';
import {FileUpload} from "primeng/fileupload";
import {NotificationService} from "../../../common/service/notification.service";
import {ProcessamentoArquivoService} from "../../../common/service/processamento-arquivo.service";
import {FileUtils} from "../../../common/utils/FileUtils";
import {Processamento} from "../../../common/model/Processamento";
import _default from "chart.js/dist/plugins/plugin.tooltip";
import reset = _default.reset;

@Component({
  selector: 'app-importar-arquivo',
  templateUrl: './importar-arquivo.component.html',
  styleUrls: ['./importar-arquivo.component.scss']
})
export class ImportarArquivoComponent implements OnInit {

  //region Atributos
  @ViewChild('form')
  public form: FileUpload | undefined

  public processedArchive = 0;
  public progress = 0;
  public inProgress = false;
  public showContent = true;
  public selectedFiles: FormData[] = [];
  public accept: string = ['application/xml', 'text/xml'].join(',')
  public hasResulted = false;

  public processamentos: Processamento[] = [];
  //endregion

  constructor(private notification: NotificationService, private service: ProcessamentoArquivoService) {
  }

  public ngOnInit(): void {
  }

  public onClearFile(): void {
    this.form!.clear();
    this.selectedFiles = [];
    this.showContent = true;
  }

  public onUpload(): void {

    if (!this.selectedFiles || this.selectedFiles.length === 0) {
      this.notification.warn('Selecione um Arquivo.')
      return;
    }

    this.inProgress = true;
    const numArchives = this.selectedFiles.length
    this.processamentos = [];

    this.progress = (this.processedArchive / numArchives) * 100;

    this.selectedFiles.forEach(file => {
      this.service.importar(file).subscribe({
        next: response => {
          this.processedArchive++;
          this.progress = (this.processedArchive / numArchives) * 100;
          this.processamentos.push(response)

          if (this.processedArchive === numArchives) {
            setTimeout(() => {
              this.hasResulted = true;
              this.inProgress = false
              this.processedArchive = 0;
              this.onClearFile()
              this.notification.sucess('Arquivos Processados com Sucesso.')
            }, 2000)
          }
        },
        error: err => {
          this.inProgress = false;
          this.processedArchive = 0;
          if (err.status === undefined || err.status !== 0) {
            this.notification.error(err)
          }
        }
      })
    })
  }

  public onSelectFile(event: any): void {
    this.selectedFiles = [];

    if (this.form?.files !== undefined && this.form?.files.length > 0) {
      for (const file of (this.form?.files as unknown as File[])) {
        this.preProccess(file);
      }
    }

  }

  private preProccess(file: File): void {
    var reader = new FileReader();

    reader.onload = () => {
      const text = (reader.result as string)
      var xmlDocument = new DOMParser().parseFromString(text, "text/xml");
      const precos = xmlDocument.getElementsByTagName("precoMedio");

      for (const preco of (precos as unknown as Element[])) {
        const valores = preco.getElementsByTagName("valor")

        for (const valor of (valores as unknown as Element[])) {
          valor.innerHTML = ' ';
        }
      }

      const xmlString = new XMLSerializer().serializeToString(xmlDocument);
      const formData = new FormData();
      const blob = FileUtils.toBlob(xmlString, "application/xml");
      formData.append('file', blob, file.name);
      this.selectedFiles.push(formData);

      if (this.selectedFiles.length > 0) {
        this.showContent = false;
      }

    }

    reader.readAsText(file);
  }

  public resetResult() {
    this.hasResulted = false;
    this.onClearFile();
    this.processamentos = [];
  }

}
