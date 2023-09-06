package com.processamentoarquivoapi.domain.service;

import com.processamentoarquivoapi.api.dto.ProcessamentoDTO;
import com.processamentoarquivoapi.core.converters.AgenteConverter;
import com.processamentoarquivoapi.core.converters.ProcessamentoConverter;
import com.processamentoarquivoapi.core.utils.DateUtil;
import com.processamentoarquivoapi.core.utils.XmlParse;
import com.processamentoarquivoapi.domain.entity.Agente;
import com.processamentoarquivoapi.domain.entity.AgenteDetalhe;
import com.processamentoarquivoapi.domain.entity.Processamento;
import com.processamentoarquivoapi.domain.entity.xml.FileXml;
import com.processamentoarquivoapi.domain.repository.ProcessamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProcessamentoService {

    private final ProcessamentoRepository repository;
    private final AgenteConverter converter;
    private final ProcessamentoConverter processConverter;

    @Autowired
    public ProcessamentoService(ProcessamentoRepository repository, AgenteConverter converter,
                                ProcessamentoConverter processConverter) {
        this.repository = repository;
        this.converter = converter;
        this.processConverter = processConverter;
    }

    public ProcessamentoDTO processar(MultipartFile file) {
        try {
            String content = new String(file.getBytes());
            FileXml obj = XmlParse.xmlToObj(content);
            List<Agente> agentes = converter.toEntity(obj.getAgentes());
            agentes.forEach(this::printToSerial);
            return save(agentes, file.getBytes(), file.getOriginalFilename());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            System.out.println(Arrays.toString(ioException.getStackTrace()));
        }
        return null;
    }

    @Transactional
    public ProcessamentoDTO save(List<Agente> agentes, byte[] arquivo, String nomeArquivo) {
        Processamento processamento = new Processamento();
        processamento.setAgentes(agentes);
        processamento.setArquivo(convertToBlob(arquivo));
        processamento.setNomeArquivo(nomeArquivo);
        processamento.getAgentes().parallelStream().forEach(it -> it.setProcessamento(processamento));
        ProcessamentoDTO dto = processConverter.toDto(repository.save(processamento));
        return dto;
    }

    private void printToSerial(Agente agente) {
        if (Objects.nonNull(agente)) {
            System.out.println("--------------------------------------------------");
            System.out.println("Código: " + agente.getCodigo());
            System.out.println("Data: " + DateUtil.formatBr(agente.getData()));

            for (AgenteDetalhe detalhe : agente.getDetalhes()) {
                System.out.println("--------------------------");
                System.out.println("  Região: " + detalhe.getRegiao());
                System.out.println("  Compra: " + detalhe.getDetalhesGeracao().get(0).getValor());
                System.out.println("  Geração: " + detalhe.getDetalhesGeracao().get(0).getValor());
                System.out.println("--------------------------");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    private Blob convertToBlob(byte[] arquivo) {
        try {
           Blob blob = new javax.sql.rowset.serial.SerialBlob(arquivo);
           return blob;
        } catch (SQLException exception) {
            System.out.println("Não foi possível converter o Arquivo.");
        }
        return null;
    }


    public List<ProcessamentoDTO> findAll() {
        return processConverter.toDto(repository.findAll());
    }
}
