package com.processamentoarquivoapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = AgenteDetCompra.TABLE_NAME)
public class AgenteDetCompra {

    public static final String TABLE_NAME = "agente_det_compra";

    @Id
    @Column(name = "id_agente_det_compra", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", precision = 4, nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_agente_detalhe", nullable = false)
    private AgenteDetalhe agenteDetalhe;

    public AgenteDetCompra(Double valor) {
        this.valor = valor;
    }

}
