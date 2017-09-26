package testInicial;

/**
 * Created by codehero on 19/09/17.
 */
public class Prueba{

    public static void main(String[] args) {

        Alumno al = new Alumno("Juan", "Penas Rodriguez", 2320);

        String nombre = al.nombreCompleto();

        System.out.println( nombre );

        // Mostrando el menu
        OtrasPreguntas otro = new OtrasPreguntas();
        otro.menuTest();

        // Calculando el promedio de x numeros
        Float promedio = otro.calculaPromedio();
        System.out.println( promedio );

    }

}
