package expresiones;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by codehero on 04/10/17.
 */
public class pruebaExpresion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String toCompare = "Haendel";


        while(true)
        {
            System.out.printf("Teclea tu expresion regular: ");
            String regexp = sc.next();

            if (regexp.equals("salir"))
            {
                break;
            }

            Pattern patron = Pattern.compile( regexp );
            Matcher match = patron.matcher( toCompare );

            Boolean coindicenda = match.find();

            System.out.println("La coincidencia es: "+ coindicenda );
            System.out.println("");

        }

    }

}
