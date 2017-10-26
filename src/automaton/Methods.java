package automaton;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by codehero on 17/10/17.
 */
public class Methods {

    // Creamos el .dot
    public void createDot(File archivo, String automata)
    {

        PrintStream ps = null;
        FileOutputStream fos = null;

        try{
            // Borramos el archivo
            archivo.delete();

            // Guardamos categorias en el archivo
            fos = new FileOutputStream(archivo,true);
            ps = new PrintStream(fos);
            ps.println( automata );

        }catch(IOException ex){
            System.out.printf("\nHa ocurrido un error: %s", ex.toString() );
        }finally{
            try{
                System.out.println("automata.dot ha sido creado");
                ps.close();
            }catch(Exception ex){
                System.out.printf("Error al cerrar el flujo: %s", ex.toString());
            }
        }

    }

    // Creamos el .png
    public void createGraph(File archivo)
    {
        StringBuffer output = new StringBuffer();
        String command = "dot -Tpng -O "+ archivo;
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
