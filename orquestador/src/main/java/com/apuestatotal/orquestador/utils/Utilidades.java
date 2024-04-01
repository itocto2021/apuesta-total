package com.apuestatotal.orquestador.utils;

public class Utilidades {
    
    public static String formatUrlGet(Integer port, String origen, String destino, String fecha) {
        String urlFormat = "http://localhost:%s/servicio-reservas/rutas?origen=%s&destino=%s&fecha=%s";
        return String.format(urlFormat, port, origen, destino, fecha);
    }

    public static String formatUrlPost(Integer port, String url) {
        String urlFormat = "http://localhost:%s%s";
        return String.format(urlFormat, port, url);
    }
}
