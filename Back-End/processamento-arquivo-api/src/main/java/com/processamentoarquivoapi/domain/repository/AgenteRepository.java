package com.processamentoarquivoapi.domain.repository;

import com.processamentoarquivoapi.domain.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {

    @Query("SELECT COUNT(a.id) FROM Agente a " +
            "INNER JOIN Processamento p ON p.id = a.processamento.id " +
            "WHERE (:dataIncial IS NULL OR CAST(p.dataProcessamento AS date ) >= CAST(:dataIncial AS date ) ) " +
            " AND  (:dataFinal   IS NULL OR CAST(p.dataProcessamento AS date ) <= CAST(:dataFinal  AS date ) )"
    )
    Long getNumOfAgentes(Date dataIncial, Date dataFinal);

}
