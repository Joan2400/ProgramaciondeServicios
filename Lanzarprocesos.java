package aev02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanzarprocesos {

	//Metodo para inicializar la clase "Calcularmeteorito" y calcular el porcenraje de los meteoritos
	//Parametro de entrada: String[] datos, sirve para pasarle los diferentes datos de la velocidad, posicion y su nombre
	//Parametro de salida: void
	public void lanzarPorcentaje(String[] datos){
		String clase = "aev02.Calcularmeteorito";
		try {
			
			//Datos de los diferentes meteoritos
			String nombre = datos[0];
			String posicion = datos[1];
			String velocidad = datos[2];

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(nombre);
			command.add(posicion);
			command.add(velocidad);


			System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",",""));

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			//Process process = builder.start();

			process.waitFor();
			System.out.println(process.exitValue());


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Este es el main que sirve para inicializar el metodo y todo el programa
	//Parametro de entrada: String[] args
	//Parametro de salida: void
	public static void main(String[] args) throws IOException {
		//Para calcular los segundos totales que tarda en ejecutar todo el programa
		long inicio = System.currentTimeMillis();

		ArrayList<String[]> datos = new ArrayList<String[]>();

		leerArchivo(datos);
		Lanzarprocesos lp = new Lanzarprocesos();
		//Para saber cuantos cores tiene el ordenador
		int procesos = Runtime.getRuntime().availableProcessors();
		//Bucle para llamar al metodo
		for (int i = 0; i <= procesos; i++) {
			lp.lanzarPorcentaje(datos.get(i));
		}

		//Para calcular los segundos totales que tarda en ejecutar todo el programa
		long fin = System.currentTimeMillis();
		double totalTiempo = (double) ((fin-inicio)/1000);

		System.out.println("El tiempo total de ejecucion de la aplicacion es: " + totalTiempo + " segundos");


	}
	
	//Metodo para leer el archivo de los datos de los diferentes meteoritos
	//Parametro de entrada: ArrayList<String[]> datos. Para que guarde todos los datos con sus nombres
	//Parametro de salida: void
	public static void leerArchivo(ArrayList<String[]> datos) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(".\\src\\aev02\\NEOs.txt"));
		String valor = "";
		
		//Bucle para leer el archivo de los datos de los meteoritos
				while ((valor = br.readLine()) != null) {

					String[] guardarDatos = valor.split(",");
					datos.add(guardarDatos);
				}
				br.close();
	}

}
