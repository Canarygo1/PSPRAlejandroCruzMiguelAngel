package Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class prueba {
  public static void main(String[] args) throws IOException, InterruptedException {
    ProcessBuilder builder = new ProcessBuilder("/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal");
    builder.redirectErrorStream(true);
    Process process = builder.start();

    InputStream is = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    String line = null;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }
}
