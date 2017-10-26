package expresiones;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by codehero on 25/09/17.
 */
public class cregexp {

    Pattern patron;
    Matcher match;

    public void evaluarExpresion(String regexp, String texto)
    {
        patron = Pattern.compile(regexp);
        match = patron.matcher( texto );

        Boolean coincidencia = match.find();

        if ( coincidencia )
        {
            JOptionPane.showMessageDialog(null,
                    "Expresion regular coincide con el texto",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Expresion regular no es valida para el texto escrito",
                    "Resultado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}

/*
    Algunos ejemplos de expresiones regulares
    Ho(j|l)a -> dara correcto Hola, Hoja, pero incorrecto hoja, hola
    Cuantificación ejemplos (?,+,*):
    ob?scuro -> dara correcto, oscuro y obscuro, pero incorrecto obbscuro
    ob+scuro -> dara correcto obscuro y obbscuro, pero incorrecto oscuro
    ob*scuro -> dara correcto obscuro, oscuro y obbscuro, pero incorrecto Obscuro
    (p|m)adre -> data correcto padre y madre
    (des)?amor -> dara correcto desamor, amor, xamor
    (des)+amor -> dara correcto desamor, amor, pero incorrecto xamor
    (des)*amor -> dara correcto desamor, amor, aamor, pero incorrecto mor
    El punto
    g.t -> dara correcto, git y got, pero incorrecto goot

*/