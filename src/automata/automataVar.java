package automata;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by codehero on 25/10/17.
 */
public class automataVar {
    public String cadena = null;
    public Integer charPosition = 0;
    public Pattern patron;
    public Matcher match;
    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        automataVar automata = new automataVar();
        automata.readString();
    }

    public void readString()
    {

        System.out.println("Cadena a evaluar: ");
        cadena = sc.nextLine();

        // Iniciamos nuestro automata en el estado 0
        q0( cadena.charAt( charPosition ) );

    }

    public void evaluations(String currentState, char caracter){

        System.out.println("Estoy en estado "+ currentState +" evaluo "+ caracter);

        if( evaluaExpresion("[a-z]", Character.toString( caracter ) ) )
        {
            automataPosition( currentState, "q1");
        }
        else if( evaluaExpresion("[0-9]", Character.toString( caracter ) ) )
        {
            automataPosition( currentState, "q2");
        }
        else if( evaluaExpresion("[_]", Character.toString( caracter ) ) &&
                !Character.toString( cadena.charAt( charPosition - 2 ) ).equals("_") )
        {
            automataPosition( currentState, "q3");
        }
        else if( evaluaExpresion("[A-Z]", Character.toString( caracter ) ) )
        {
            automataPosition( currentState, "q4");
        }
        else
        {
            System.out.println("El automata no es aceptado");
        }
    }

    public Boolean evaluaExpresion(String regexp, String texto)
    {
        patron = Pattern.compile(regexp);
        match = patron.matcher( texto );

        Boolean coincidencia = match.find();

        return coincidencia;
    }

    public void automataPosition(String currentState, String nextState)
    {
        if(charPosition < cadena.length())
        {
            charPosition++;
            switch (nextState){
                case "q1": q1( cadena.charAt( charPosition - 1 ) ); break;
                case "q2": q2( cadena.charAt( charPosition - 1 ) ); break;
                case "q3": q3( cadena.charAt( charPosition - 1 ) ); break;
                case "q4": q4( cadena.charAt( charPosition - 1 ) ); break;
            }

        }
        else
        {
            System.out.println("Automata aceptado en "+ nextState);
        }
    }

    // Estado q0
    public void q0(char caracter)
    {
        System.out.println("Estoy en q0 estado inicial");

        if( evaluaExpresion("[a-z]", Character.toString( caracter ) ) )
        {
            automataPosition( "q0", "q1");
        }
        else
        {
            System.out.println("El automata no es aceptado");
        }
    }

    // Estado q1
    public void q1(char caracter){
        evaluations( "q1", caracter );
    }

    // Estado q2
    public void q2(char caracter)
    {
        evaluations( "q2", caracter );
    }

    public void q3(char caracter)
    {
        evaluations( "q3", caracter );
    }

    public void q4(char caracter)
    {
        evaluations("q4", caracter);
    }
}
