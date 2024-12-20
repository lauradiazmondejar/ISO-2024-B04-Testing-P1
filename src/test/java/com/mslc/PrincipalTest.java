package com.mslc;

import static org.junit.Assert.*; // Para métodos de aserción
import org.junit.Before; // Anotación para inicializar antes de cada prueba
import org.junit.Test; // Para la anotación @Test
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class PrincipalTest {

    private Persona aDecision1;
    private Persona bDecision1;

    private Persona aDecision2;
    private Persona bDecision2;

    private Persona aDecision3;
    private Persona bDecision3;

    private Persona personaValida;
    
    private Persona personaMenorEdad;
    private Persona personaNoEuropea;
    private Persona personaSinTitulacion;
    @Before
    public void setUp() throws Exception {
    	
    	
    	
    	 Date fechaNacimiento = Date.from(LocalDate.of(2000, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
         personaValida = new Persona("Ana", "Pérez", fechaNacimiento, "española", Arrays.asList(Titulacion.GRADO, Titulacion.MASTER), "C1", "678456576", "ana@gmail.com");

         Date fechaMenorEdad = Date.from(LocalDate.of(2010, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
         personaMenorEdad = new Persona("Luis", "Gómez", fechaMenorEdad, "española", Arrays.asList(Titulacion.ESO), "B1", "678456577", "luis@gmail.com");

         personaNoEuropea = new Persona("John", "Doe", fechaNacimiento, "estadounidense", Arrays.asList(Titulacion.GRADO), "C2", "678456578", "john@gmail.com");

         personaSinTitulacion = new Persona("María", "López", fechaNacimiento, "española", Arrays.asList(Titulacion.ESO), "B2", "678456579", "maria@gmail.com");
         
        Date fechaNacimiento2 = Date.from(LocalDate.of(2000, 7, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        aDecision1 = new Persona("pablo", "gonzalez", fechaNacimiento2, "española", Arrays.asList(Titulacion.ESO), "B2", "678456576", "sergio@gmail.com");

        Date fechaNacimiento1 = Date.from(LocalDate.of(2015, 2, 19).atStartOfDay(ZoneId.systemDefault()).toInstant());
        bDecision1 = new Persona("pablo", "gonzalez", fechaNacimiento1, "española", Arrays.asList(Titulacion.ESO), "B2", "678456576", "sergio@gmail.com");

        aDecision2 = new Persona("pablo", "gonzalez", fechaNacimiento1, "española", Arrays.asList(Titulacion.ESO), "B2", "678456576", "sergio@gmail.com");
        bDecision2 = new Persona("pablo", "gonzalez", fechaNacimiento1, "Estadounidense", Arrays.asList(Titulacion.ESO), "B2", "678456576", "sergio@gmail.com");

        aDecision3 = new Persona("pablo", "gonzalez", fechaNacimiento1, "Estadounidense", Arrays.asList(Titulacion.MASTER), "B2", "678456576", "sergio@gmail.com");
       
        bDecision3 = new Persona("pablo", "gonzalez", fechaNacimiento1, "Estadounidense", Arrays.asList(Titulacion.ESO), "B2", "678456576", "sergio@gmail.com");
    }

    @Test
    public void testPrincipal1Decision() {
        assertEquals(true, Principal.esApto(aDecision1));
        assertNotEquals("Resultado de esApto: true", Principal.esApto(bDecision1));
    }

    @Test
    public void testPrincipal2Decision() {
        assertEquals(true, Principal.esApto(aDecision2));
        assertNotEquals("Resultado de esApto: true", Principal.esApto(bDecision2));
    }

    @Test
    public void testPrincipal3Decision() {
        assertEquals(true, Principal.esApto(aDecision3));
        assertNotEquals("Resultado de esApto: true", Principal.esApto(bDecision3));
    }
    @Test
    public void testEsMayorEdad() {
        assertTrue(personaValida.esMayorEdad());
        assertFalse(personaMenorEdad.esMayorEdad());
    }

    @Test
    public void testEsEuropeo() {
        assertTrue(personaValida.esEuropeo());
        assertFalse(personaNoEuropea.esEuropeo());
    }

    @Test
    public void testEsAptoCasoValido() {
        assertEquals(true, Principal.esApto(personaValida));
    }

    @Test
    public void testPuedeHacerDoctoradoValido() {
        assertEquals(true, personaValida.puedeHacerDoctorado());
    }

    @Test
    public void testPuedeHacerDoctoradoSinTitulacion() {
        assertEquals(false, personaSinTitulacion.puedeHacerDoctorado());
    }
    
}