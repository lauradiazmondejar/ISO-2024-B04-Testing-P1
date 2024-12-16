import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

    public Persona(String nombre, String apellidos, Date fechaNacimiento, String nacionalidad, List<Titulacion> titulacion, String certificacionIngles, String numeroTelefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.nacionalidad = nacionalidad;
        this.titulacion = titulacion;
        this.certificacionIngles = certificacionIngles;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
    }

    public int getEdad() {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        System.out.println("Edad: " + edad); // Línea de depuración
        return edad;
    }

    public List<Titulacion> getTitulacion() {
        return titulacion;
    }

    public boolean esMayorEdad() {
        System.out.println("Llamando a esMayorEdad"); // Línea de depuración
        boolean mayorEdad = getEdad() >= 18;
        System.out.println("Es mayor de edad: " + mayorEdad); // Línea de depuración
        return mayorEdad;
    }

    public boolean esEuropeo() {
        System.out.println("Llamando a esEuropeo"); // Línea de depuración
        boolean europeo = "Española".equalsIgnoreCase(nacionalidad) || "Europea".equalsIgnoreCase(nacionalidad);
        System.out.println("Es europeo: " + europeo); // Línea de depuración
        return europeo;
    }

    public boolean puedeHacerDoctorado() {
        System.out.println("Llamando a puedeHacerDoctorado"); // Línea de depuración
        boolean puedeDoctorado = titulacion.contains(Titulacion.GRADO) || titulacion.contains(Titulacion.MASTER);
        System.out.println("Puede hacer doctorado: " + puedeDoctorado); // Línea de depuración
        return puedeDoctorado;
    }
}