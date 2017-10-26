package expresiones;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by codehero on 26/09/17.
 */
public class consoleRegexp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ^\d{4}-\d{2}-\d{2}$
        // ^abc -> si se compara con abcdefghijklm es true
        // abc$ -> si se compara con abcdefghijklm es false
        // ^\w*_?\d*?$ -> Detecta una variable, pero detecta true 12abc(lo cual es incorrecto)
        // ^[a-z]*_?[1-9]*?$ -> La forma correcta de escribir abc|abc_|abc_12 true, pero  false 12abc|abc__|abc12_
        // ^<[a-z]*>$ -> Evalua correctamente <html>

        while(true)
        {


        System.out.printf("Teclea un texto: ");
        String toCompare = sc.nextLine();

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

            /*if( txt.equals("terminar") )
                break;*/
        }

    }

}
