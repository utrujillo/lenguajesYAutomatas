package testInicial;

/**
 * Created by codehero on 25/09/17.
 */
public class OtrasPreguntas extends Generales{

    // Menu de la pregunta 7
    public void menuTest(){
        this.imprime( "1.- Agregar" );
        this.imprime("2.- Editar");
        this.imprime("3.- Eliminar");
        this.imprime("4.- Actualizar");
    }

    // Ejercicio pregunta 8 - calculo de promedio
    public Float calculaPromedio()
    {
        this.imprimel("Cuantos numeros deseas promediar? ");
        Integer cantidadNumeros = sc.nextInt();
        Float promedio = 0f;

        for(Integer i = 1; i <= cantidadNumeros; i++)
        {
            this.imprimel("Ingresa el valor "+ i +" : ");
            promedio += sc.nextFloat();
        }

        promedio = promedio / cantidadNumeros;

        return promedio;
    }

}
