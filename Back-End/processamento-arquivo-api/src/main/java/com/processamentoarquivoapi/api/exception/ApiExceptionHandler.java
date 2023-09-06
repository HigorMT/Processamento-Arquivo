package com.processamentoarquivoapi.api.exception;


import com.processamentoarquivoapi.api.dto.exception.ErroModel;
import com.processamentoarquivoapi.domain.exception.ErrorDictionary;
import com.processamentoarquivoapi.domain.exception.MensagemException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleBadRequestException(Exception ex, WebRequest request) {
        var errorDetail = new ErroModel(ErrorDictionary.PROCESSING_ERROR);
        if (StringUtils.isNotEmpty(ex.getMessage()))
            errorDetail.addDetail(ex.getMessage());
        return this.handleExceptionInternal(ex, errorDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
        var errorDetail = new ErroModel(ErrorDictionary.INTERNAL_ERROR);
        if (StringUtils.isNotEmpty( ex.getMessage()))
            errorDetail.addDetail(MensagemException.capture(ex));

        log.error("Internal Server Error", ex);
        return this.handleExceptionInternal(ex, errorDetail,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        var errorDetail = new ErroModel(ErrorDictionary.INVALID_REQUEST_PARAMETERS);
        return this.handleExceptionInternal(ex, errorDetail,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}