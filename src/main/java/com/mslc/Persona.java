package com.mslc;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

enum Titulacion {
    ESO, BACHILLERATO, FP, GRADO, MASTER, DOCTORADO
}

public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private List<Titulacion> titulacion;
    private String certificacionIngles;
    private String numeroTelefono;
    private String correoElectronico;
    private static final List<String> NACIONALIDADES_EUROPEAS = Arrays.asList(
    	    "alemana", "andorrana", "austriaca", "belga", "bielorrusa", "bosnia y herzegovina", "búlgara", "checa", "chipriota",
    	    "croata", "danesa", "eslovaca", "eslovena", "española", "estonia", "finlandesa", "francesa", "georgiana", "griega",
    	    "húngara", "islandesa", "irlandesa", "italiana", "kosovar", "letona", "liechtenstein", "lituana", "luxemburguesa",
    	    "macedonia del norte", "maltesa", "moldava", "monegasca", "montenegrina", "neerlandesa", "noruega", "polaca",
    	    "portuguesa", "inglesa", "escocesa", "galesa", "norirlandesa", "rumano", "rusa", "sanmarinense", "serbia", "sueca", 
    	    "suiza", "ucraniana", "vaticana"
    	);

    public Persona(String nombre, String apellidos, Date fechaNacimiento, String nacionalidad,
                   List<Titulacion> titulacion, String certificacionIngles, String numeroTelefono, String correoElectronico) {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setTitulacion(titulacion);
        this.setCertificacionIngles(certificacionIngles);
        this.setNumeroTelefono(numeroTelefono);
        this.setCorreoElectronico(correoElectronico);
    }

    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }

    public void setApellidos(String apellidos) {
        if (apellidos != null && !apellidos.isEmpty()) {
            this.apellidos = apellidos;
        } else {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos o vacíos.");
        }
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        LocalDate fechaNacLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (fechaNacLocal.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
        }
        this.fechaNacimiento = fechaNacLocal;
    }

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad != null && !nacionalidad.isEmpty()) {
            this.nacionalidad = nacionalidad;
        } else {
            throw new IllegalArgumentException("La nacionalidad no puede ser nula o vacía.");
        }
    }

    public void setTitulacion(List<Titulacion> titulacion) {
        if (titulacion != null && !titulacion.isEmpty()) {
            this.titulacion = titulacion;
        } else {
            throw new IllegalArgumentException("La lista de titulaciones no puede ser nula o vacía.");
        }
    }

    public void setCertificacionIngles(String certificacionIngles) {
        this.certificacionIngles = certificacionIngles; // Opcional, puede ser nulo o vacío
    }

    public void setNumeroTelefono(String numeroTelefono) {
        if (numeroTelefono != null && numeroTelefono.matches("^\\+?\\d{7,15}$")) {
            this.numeroTelefono = numeroTelefono;
        } else {
            throw new IllegalArgumentException(
                "El número de teléfono no es válido. Debe contener entre 7 y 15 dígitos y no incluir letras ni caracteres especiales (salvo un prefijo '+')."
            );
        }
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico != null && correoElectronico.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            this.correoElectronico = correoElectronico;
        } else {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public List<Titulacion> getTitulacion() {
        return titulacion;
    }

    public String getCertificacionIngles() {
        return certificacionIngles;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public boolean esMayorEdad() {
        return getEdad() >= 18;
    }

    public boolean esEuropeo() {
    	boolean europeo = NACIONALIDADES_EUROPEAS.contains(nacionalidad.toLowerCase());
    	return europeo;
    }

    public boolean puedeHacerDoctorado() {
        return titulacion.contains(Titulacion.GRADO) || titulacion.contains(Titulacion.MASTER);
    }
}