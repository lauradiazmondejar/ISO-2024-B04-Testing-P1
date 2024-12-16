package com.mslc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Principal {
    public static void main(String[] args){
        // Crear un LocalDate y convertirlo a Date
        Date date = Date.from(LocalDate.of(2019, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Crear una lista de titulaciones
        List<Titulacion> titulaciones = Arrays.asList(Titulacion.ESO, Titulacion.BACHILLERATO, Titulacion.FP, Titulacion.GRADO, Titulacion.MASTER, Titulacion.DOCTORADO);

        Persona sergio = new Persona("Sergio", "Carmona", date, "Española", titulaciones, "B2", "666666666", "sergio@gmail.com");
        try {
            System.out.println("Resultado de esApto: " + esApto(sergio)); // Línea de depuración
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } 

    public static boolean esApto(Persona persona){
        System.out.println("Llamando a esApto"); // Línea de depuración
        if (!persona.esMayorEdad()) {
            throw new IllegalArgumentException("No es mayor de edad");
        }
        if (!persona.esEuropeo()) {
            throw new IllegalArgumentException("No es europeo");
        }
        if (!persona.puedeHacerDoctorado()) {
            throw new IllegalArgumentException("No puede hacer doctorado");
        }
        return true;
    }
}