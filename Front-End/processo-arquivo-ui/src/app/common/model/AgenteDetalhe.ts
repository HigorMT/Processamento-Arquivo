import {AgenteDetCompra} from "./AgenteDetCompra";
import {AgenteDetGeracao} from "./AgenteDetGeracao";

export class AgenteDetalhe {
  id?: number;
  regiao?: string;
  detalhesCompra: AgenteDetCompra[] = [];
  detalhesGeracao: AgenteDetGeracao[] = [];
}
