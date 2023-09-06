
CREATE TABLE `processamento-arquivo`.processamento (
`id_processamento` BIGINT NOT NULL AUTO_INCREMENT,
`arquivo` LONGBLOB NOT NULL,
`data_processamento` TIMESTAMP NOT NULL,
`nome_arquivo` VARCHAR(500) NOT NULL,
PRIMARY KEY (`id_processamento`)
);

CREATE TABLE `processamento-arquivo`.`agente` (
`id_agente` BIGINT NOT NULL AUTO_INCREMENT,
`codigo` BIGINT NOT NULL,
`data` TIMESTAMP NULL,
`id_processamento` BIGINT NOT NULL,
PRIMARY KEY (`id_agente`));

CREATE TABLE `processamento-arquivo`.`agente_detalhes` (
`id_agente_detalhes` BIGINT NOT NULL AUTO_INCREMENT,
`id_agente` BIGINT NOT NULL,
`regiao` VARCHAR(12) NOT NULL,
PRIMARY KEY (`id_agente_detalhes`),
INDEX `fk_agente_idx` (`id_agente` ASC) VISIBLE,
CONSTRAINT `fk_agente`
   FOREIGN KEY (`id_agente`)
       REFERENCES `agente` (`id_agente`)
       ON DELETE NO ACTION
       ON UPDATE NO ACTION);

CREATE TABLE `processamento-arquivo`.`agente_det_geracao` (
`id_agente_det_geracao` BIGINT NOT NULL AUTO_INCREMENT,
`id_agente_detalhe` BIGINT NOT NULL,
`valor` DECIMAL(10, 4) NOT NULL,
PRIMARY KEY (`id_agente_det_geracao`),
INDEX `fk_agente_det_geracao_idx` (`id_agente_detalhe` ASC) VISIBLE,
CONSTRAINT `fk_agente_det_geracao`
  FOREIGN KEY (`id_agente_detalhe`)
      REFERENCES `agente_detalhes` (`id_agente_detalhes`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE `processamento-arquivo`.`agente_det_compra` (
 `id_agente_det_compra` BIGINT NOT NULL AUTO_INCREMENT,
 `id_agente_detalhe` BIGINT NOT NULL,
 `valor` DECIMAL(10, 4) NOT NULL,
 PRIMARY KEY (`id_agente_det_compra`),
 INDEX `fk_agente_det_compra_idx` (`id_agente_detalhe` ASC) VISIBLE,
 CONSTRAINT `fk_agente_det_compra`
     FOREIGN KEY (`id_agente_detalhe`)
         REFERENCES `agente_detalhes` (`id_agente_detalhes`)
         ON DELETE NO ACTION
         ON UPDATE NO ACTION);