import java.io.IOException;
// hecho por miguel martinez
public class RuntimeProcess {
	public static void main(String [] args) {
		if(args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		
		try {
			Process process = runtime.exec(args);
			//process.destroy();
		}catch(IOException ex) {
			System.err.println("Excepcion de E/S");
			System.exit(-1);
		}
	}
}
// A) abre el bloc de notas pero al instante lo cierra por el process destroy
// B) al comentarlo no se cierra el el bloc de notas, pero al cerrarlo solo se queda el hilo 
//tambien por que tambien se debe cerrar el program