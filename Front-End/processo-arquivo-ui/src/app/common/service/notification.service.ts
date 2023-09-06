import {Injectable} from '@angular/core';
import {MessageService} from "primeng/api";

@Injectable({
    providedIn: 'root'
})
export class NotificationService {

    private readonly life = 3000;

    constructor(protected service: MessageService) {
    }

    public show(severity: string, summary: string, detail: string, life?: number): void {
        this.service.clear();
        this.service.add({severity: severity, summary: summary, detail: detail, life: (life ? life : this.life)});
    }

    public error(detail: string): void {
        this.service.clear();
        this.service.add({severity: 'error', summary: 'Erro', detail: detail, life: this.life});
    }

    public warn(detail: string): void {
        this.service.clear();
        this.service.add({severity: 'warn', summary: 'Aviso', detail: detail, life: this.life});
    }

    public sucess(detail: string): void {
        this.service.clear();
        this.service.add({severity: 'success', summary: 'Sucesso', detail: detail, life: this.life});
    }

    public info(detail: string): void {
        this.service.clear();
        this.service.add({severity: 'info', summary: 'Informação', detail: detail, life: this.life});
    }

}
