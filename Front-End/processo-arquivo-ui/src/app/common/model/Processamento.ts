import {Agente} from "./Agente";

export class Processamento {
  id?: number;
  nomeArquivo?: string
  dataProcessamento?: string
  agentes: Agente[] = []
}
