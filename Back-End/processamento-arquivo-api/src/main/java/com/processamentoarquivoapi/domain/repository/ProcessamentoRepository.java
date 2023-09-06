package com.processamentoarquivoapi.domain.repository;

import com.processamentoarquivoapi.api.dto.ProcessamentoDTO;
import com.processamentoarquivoapi.domain.entity.Processamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProcessamentoRepository extends JpaRepository<Processamento, Long> {

    @Query("SELECT COUNT(p.id) FROM Processamento p " +
            "WHERE (:dataIncial IS NULL OR CAST(p.dataProcessamento AS date ) >= CAST(:dataIncial AS date ) ) " +
            " AND  (:dataFinal   IS NULL OR CAST(p.dataProcessamento AS date ) <= CAST(:dataFinal  AS date ) )"
    )
    Long getNumOfProcess(Date dataIncial, Date dataFinal);

}
