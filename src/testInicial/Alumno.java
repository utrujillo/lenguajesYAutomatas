package testInicial;

/**
 * Created by codehero on 19/09/17.
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private Integer matricula;

    public Alumno(String n, String ap, Integer m){
        this.nombre = n;
        this.apellidos = ap;
        this.matricula = m;
    }

    public String nombreCompleto(){
        return this.nombre+" "+this.apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
