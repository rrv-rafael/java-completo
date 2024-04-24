package com.rrv.webservicemongodb.controllers.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
    public static String decodeParam(String texto) {
        return URLDecoder.decode(texto, StandardCharsets.UTF_8);
    }

    public static LocalDate convertData(String textoData, LocalDate dataPadrao) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(textoData, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            return dataPadrao;
        }
    }
}
