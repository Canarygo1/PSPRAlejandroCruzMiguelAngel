package Ejercicio4;
/*
@author Alejandro Cruz
 */
import java.io.*;
class JavaPing
{
  public static void main(String[ ] args) {
        // he puesto este contador para en caso de que se quieran poner mas valores de entrada sea posible

        // se crea un objeto de tipo Runtime que nos permitira ejecutar el comando ping
          Runtime runTime = Runtime.getRuntime();
          //Se crea un objeto de tipo process para poder ejecutar un nuevo proceso.
          Process process = null;
          try {
            //Se le asigna a la instancia de process su orden correspondiente,ejecutar el comando ping mas entrada de args[0]
            //Para asi poder leer
            process = runTime.exec("ping " + args[0]);
            //Se crea un objeto BufferedReader y se le asigna la salida del process para poder ser recorrida.
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //Se recorre la salida del process
            for (int j = 0; j < 10; j++) {
              //Se imprime la salida del process
              System.out.println("Saludo " + in.readLine());
            }
          } catch (IOException e) {
            //Se capturan las posibles excepciones de entrada/salida y se le comunica al usuario que no se pudo correr el ping y se finaliza el programa
            //Solo se ejecuta en caso de error de entrada/salida
            System.out.println("No pudimos correr el ping");
            System.exit(-1);
          }

          if (process != null) {
            //Es caso de el process ser distinto de null se destruye para que no consuma recursos inecesarios.
            process.destroy();
          }

          try {
            //Se espera a que destruya el proceso anterior
            process.waitFor();
            //En caso de no recibir respuesta se espera por ella y se capturan las posibles excepciones de tipo InterruptedException
          } catch (InterruptedException e) {
            //Se informa al usuario que no se pudo esperar y se cierra el programa con codigo de error -1.
            System.out.println("No pudimos esperar por témino");
            System.exit(-1);
          }
          //Se imprime el procces exit value y se finaliza el programa
          System.out.println("Estatus de témino:  " + process.exitValue());
          System.exit(0);
    }
}
/*
  A){ cuando se introduce una direccion invalida el resulatado es Saludos null , mientras que si introducimos Ip validas
  el resultado es un comando ping y al finalizar una respuesta del estatus en ambos.Tambien en el caso de introducir una ip mal formada
  se nos informa al iniciar el programa con que no se pudo encontrar el host.
  }
* */
/*
  B){
  En codigo esta comentado paso a paso.
  }

*/