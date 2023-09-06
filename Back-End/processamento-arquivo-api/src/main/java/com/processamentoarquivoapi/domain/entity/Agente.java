package com.processamentoarquivoapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Agente.TABLE_NAME)
public class Agente {

    public static final String TABLE_NAME = "agente";

    @Id
    @Column(name = "id_agente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_processamento", nullable = false)
    private Processamento processamento;

    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL)
    private List<AgenteDetalhe> detalhes;

}
