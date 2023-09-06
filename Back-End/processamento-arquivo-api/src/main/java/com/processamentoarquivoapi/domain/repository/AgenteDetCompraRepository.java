package com.processamentoarquivoapi.domain.repository;

import com.processamentoarquivoapi.domain.entity.AgenteDetCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteDetCompraRepository extends JpaRepository<AgenteDetCompra, Long> {
}
