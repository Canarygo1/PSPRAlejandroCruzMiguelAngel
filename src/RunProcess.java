
import java.io.IOException;
import java.util.Arrays;
// hecho por miguel martinez
public class RunProcess {
	public static void main(String[] args)throws IOException{
		if(args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start();
			int retorno = process.waitFor();
			System.err.println("La ejecucion de "+ Arrays.toString(args)+" devuelve "+retorno);
		}catch(IOException ex) {
			System.err.println("Excepcion de E/S");
			System.exit(-1);
		}catch(InterruptedException ex) {
			System.err.println("El proceso hijo finalizo de forma incorrecta");
			System.exit(-1);
		}
	}
}
// A) entrando en run configuration-arguments y poniendo el calc.exe
// B) sale en el terminal en rojo que se necesita un programar a ejecutar
// C) sigue saliendo solo una calculadora
// D) dentro del try pondriamos un bucle for en el que antes un scanner nos pida 
//    cuantas veces queremos que se repita la ejecucion  y con ese numero en el for hacer un contador 
//    hacia atras en el que se ejecute el pb.start y el process.wait for con el ultimo sis out