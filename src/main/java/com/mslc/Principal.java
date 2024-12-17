package com.mslc;
	import java.time.LocalDate;
	import java.time.ZoneId;
	import java.util.Arrays;
	import java.util.Date;
	import java.util.List;

	public class Principal {
	    public static void main(String[] args){
	        Date date = Date.from(LocalDate.of(2000, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());

	        List<Titulacion> titulaciones = Arrays.asList(Titulacion.ESO, Titulacion.BACHILLERATO, Titulacion.FP, Titulacion.GRADO, Titulacion.MASTER, Titulacion.DOCTORADO);

	        Persona sergio = new Persona("Sergio", "Carmona", date, "Inglesa", titulaciones, "B2", "666666666", "sergio@gmail.com");
	        try {
	            System.out.println("Resultado de esApto: " + esApto(sergio));
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	    } 

	    public static boolean esApto(Persona persona){
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
