package com.processamentoarquivoapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = AgenteDetalhe.TABLE_NAME)
public class AgenteDetalhe {

    public static final String TABLE_NAME = "agente_detalhes";

    @Id
    @Column(name = "id_agente_detalhes", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regiao", length = 12, nullable = false)
    private String regiao;

    @ManyToOne
    @JoinColumn(name = "id_agente", nullable = false)
    private Agente agente;

    @OneToMany(mappedBy = "agenteDetalhe", cascade = CascadeType.ALL)
    private List<AgenteDetGeracao> detalhesGeracao;

    @OneToMany(mappedBy = "agenteDetalhe", cascade = CascadeType.ALL)
    private List<AgenteDetCompra> detalhesCompra;

}
