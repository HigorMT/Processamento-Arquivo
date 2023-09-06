package com.processamentoarquivoapi.domain.repository;

import com.processamentoarquivoapi.domain.entity.AgenteDetalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteDetalheRepository extends JpaRepository<AgenteDetalhe, Long> {
}
