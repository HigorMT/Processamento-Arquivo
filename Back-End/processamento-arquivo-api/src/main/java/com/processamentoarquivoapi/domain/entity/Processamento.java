package com.processamentoarquivoapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Processamento.TABLE_NAME)
public class Processamento {

    public static final String TABLE_NAME = "processamento";

    @Id
    @Column(name = "id_processamento", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_arquivo", length = 500, nullable = false)
    private String nomeArquivo;

    @Lob
    @Column(name = "arquivo", nullable = false)
    private Blob arquivo;

    @Column(name = "data_processamento", nullable = false)
    private LocalDateTime dataProcessamento;

    @OneToMany(mappedBy = "processamento", cascade = CascadeType.ALL)
    private List<Agente> agentes;

    @PrePersist
    public void prePersist() {
        this.dataProcessamento = LocalDateTime.now();
    }

}
