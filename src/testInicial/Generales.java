package testInicial;
import java.util.Scanner;

/**
 * Created by codehero on 25/09/17.
 * Esta clase contiene metodos que son repetidos en todas las demas clases, regularmente esta clase se hereda para simplificar cosas
 */
public class Generales {

    public Scanner sc = new Scanner(System.in);

    // Imprimir con salto de linea
    public void imprime( Object item )
    {
        System.out.println( item );
    }

    // Imprimir sin salto de linea
    public void imprimel( Object item )
    {
        System.out.print( item );
    }

}
