package com.processamentoarquivoapi.core.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static LocalDateTime toLocalDateTime(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date) {
        return  Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


    public static String toStringBr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    public static String formatBr(LocalDateTime dateTime) {
        try {
            SimpleDateFormat dateField = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            SimpleDateFormat dateVar = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            Date date = dateVar.parse(dateTime.toString().replace("T", " "));
            String dataStr = dateField.format(date);
            return dataStr;
        } catch (Exception ex) {
            return "";
        }
    }

}
