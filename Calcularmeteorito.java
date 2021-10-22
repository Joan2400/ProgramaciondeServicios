package aev02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calcularmeteorito {


	//Metodo para calcular la probabilidad de que el meteorito choque en la Tierra
	//Parametro de entrada: String nombre, String posicionNEO, String velocidadNEO. Son los nombres y datos de los meteoritos
	//Parametro de salida: void
	public void calcular(String nombre, String posicionNEO, String velocidadNEO) throws IOException {
		double posicionTierra = 1;
		double velocidadTierra = 100;

		double posicionNeo = Double.parseDouble(posicionNEO);
		double velocidadNeo = Double.parseDouble(velocidadNEO);
		

		//Calculo de la probabilidad de choque
		for (int h = 0; h < (50 * 365 * 24 * 60 * 60); h++) {
			posicionNeo = posicionNeo + velocidadNeo * h;
			posicionTierra = posicionTierra + velocidadTierra * h;

		}
		double resultado = 100 * Math.random() *
				Math.pow( ((posicionNeo-posicionTierra)/(posicionNeo+posicionTierra)), 2);

		//Metodo para crear los archivos con sus nombres y su probabilidad
		guardarResultado(nombre, resultado);

		if(resultado > 10) {
			System.err.println("Alerta mundial");
		}
		else {
			System.out.println("Tranquilidad");
		}



	}

	//Metodo para crear los archivos con sus nombres y su probabilidad
	//Parametro de entrada: String nombre, double resultado.Parametros para pasarle los nombres con su probabilidad
	//Parametro de salida: void
	public static void guardarResultado(String nombre, double resultado) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(".\\src\\aev02\\" +nombre + ".txt"));
			DecimalFormat df = new DecimalFormat("#.00");
			bw.write(df.format(resultado));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	//Esto es el main que es para inicializar los metodos
	//Parametro de entrada: String[args]
	//Parametro de salida: void
	public static void main(String[] args) throws IOException {
		
		//Para calcular los segundos totales que tarda en ejecutar cada calculo de la probabilidad del meteorito
		long inicio = System.currentTimeMillis();
		
		//Variables donde se guardan los datos de los meteoritos que se pasan desde la otra clase
		String nombreArchivo = args[0];
		String posicion = args[1];
		String velocidad =args[2];
		
		Calcularmeteorito cm = new Calcularmeteorito();
		//Inicializar el metodo
		cm.calcular(nombreArchivo, posicion, velocidad);
		
		//Para calcular los segundos totales que tarda en ejecutar cada calculo de la probabilidad del meteorito
		long fin = System.currentTimeMillis();
		double tiempoMeteorito = (double) ((fin - inicio) / 1000);
		
		System.out.println("Tiempo de ejecucion de cada calculo de los diferentes meteoritos: " + tiempoMeteorito + " segundos");
	}

}
