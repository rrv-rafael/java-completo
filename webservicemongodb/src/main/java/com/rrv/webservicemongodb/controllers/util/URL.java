package com.rrv.webservicemongodb.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParam(String texto) {
        return URLDecoder.decode(texto, StandardCharsets.UTF_8);
    }
}
