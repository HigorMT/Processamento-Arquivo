package com.processamentoarquivoapi.domain.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MensagemException {

    public static String capture(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}

