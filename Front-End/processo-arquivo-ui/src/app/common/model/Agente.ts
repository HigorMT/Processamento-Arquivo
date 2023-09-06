import {AgenteDetalhe} from "./AgenteDetalhe";

export class Agente {
  id?: number;
  codigo?: number;
  data?: string;
  detalhes: AgenteDetalhe[] = [];
}
