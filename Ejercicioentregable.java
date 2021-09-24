package ae01_T1_Psp_Joan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicioentregable {

	//Nombre metodo: main
	//Parametro de entrada: args
	//Parametro de salida: void
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;

		//Se inicializa el menu de la aplicacion
		do {
			System.out.println("Bienvenido al programa.");
			System.out.println("Pulse 1 para hola mundo");
			System.out.println("Pulse 2 para ver 6 compañeros de clase");
			System.out.println("Pulse 3 para devolver la suma de numeros pares");
			System.out.println("Pulse 4 para calcular el factorial");
			System.out.println("Pulse 5 para devolver el mayor valor de un array");
			System.out.println("Pulse 6 para ordenar inversamente y sacar la suma de 5 numeros");
			System.out.println("Pulse 7 para saber el nivel y el salario de un desarrollador software");
			System.out.println("Pulse 8 para imprimir el intervalo entre un numero y otro");
			System.out.println("Pulse 0 si quiere salir del programa");
			opcion = sc.nextInt();

			//Se encuentran los diferentes casos que se haran segun el numero que pulse el usuario 
			switch(opcion) {

			case 0:
				System.out.println("Gracias por utilizar nuestro programa");
				break;

			case 1: 
				sayHello();
				break;

			case 2:
				nombreCompañeros();
				break;

			case 3:
				sumarPares();
				break;

			case 4:
				factorial();
				break;

			case 5:
				mayorNumero();
				break;
			
			case 6:
				inversoSuma();
				break;
			case 7:
				categoria();
				break;
				
			case 8:
				intervalos();
				break;

			default:
				System.out.println("Error. Ponga un numero del 0 al 5");
				break;
			}
		}
		while(opcion != 0);

	}
	
	//Nombre del metodo: sayHello
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void sayHello() {
		System.out.println("Hola mundo");
	}
	
	//Nombre del metodo: nombreCompañeros
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void nombreCompañeros() {
		System.out.println("Apartado a");
		String [] nombres = {"Jorge", "Eric", "Ximo","Diego", "David", "Fran"};
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
		}
		
		System.out.println("Apartado b");
		
		ArrayList<String> nombre = new ArrayList<String>();
		
		nombre.add("Jorge");
		nombre.add("Eric");
		nombre.add("Ximo");
		nombre.add("Diego");
		nombre.add("David");
		nombre.add("Fran");
		
		for (int i = 0; i < nombre.size(); i++) {
			System.out.println(nombre.get(i));
		}
	}
	
	//Nombre del metodo: sumarPares
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void sumarPares() {
		
		Scanner sc = new Scanner(System.in);
		
		int numero, suma = 0;
		
		System.out.println("Dime hasta que numero quieres que sume los pares");
		numero = sc.nextInt();
		
		for (int i = 0; i <= numero; i= i + 2) {
			suma = suma + i;
		}
		System.out.println("La suma total de los numeros pares es: " + suma);
		
	}
	
	//Nombre del metodo: factorial
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void factorial() {
		long numero = 15;
		
		for (int i = 15; i > 0; i--) {
			numero = numero * i;
		}
		System.out.println("El total del factorial del numero 15 es: " + numero);
	}
	
	public static void mayorNumero() {
		int mayor = 0;
		int[] numeros = {1,2,3,4,5,6,7,8,9,10};
		
		for (int i = 0; i < numeros.length; i++) {
			if(mayor < numeros[i]) {
				mayor = numeros[i];
			}
		}
		System.out.println("El numero mayor es: " + mayor);
	}
	
	//Nombre del metodo: inversoSuma
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void inversoSuma() {
		Scanner sc = new Scanner(System.in);
		int[] numero = new int [5];
		int suma = 0;
		for (int i = 0; i < numero.length; i++) {
			System.out.println("Dime un numero");
			numero[i] = sc.nextInt();
			suma = suma + numero[i];
		}
		System.out.println("Numeros inversos: ");
		for (int n = 4; n >= 0; n--) {
			System.out.print(numero[n] + " ,");
		}
		System.out.println("La suma de los numeros es: " + suma);
	}
	
	//Nombre del metodo: categoria
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void categoria() {
		Scanner sc = new Scanner(System.in);
		
		String nombre;
		double años;
		
		System.out.println("Dime tu nombre");
		nombre = sc.nextLine();
		
		System.out.println("Años de experiencia");
		años = sc.nextDouble();
		
		if(años < 1) {
			System.out.println("Nivel: Desarrollador Junior L1");
			System.out.println("Salario base: 15000-18000");
		}
		else if(años >= 1 && años <=2) {
			System.out.println("Nivel: Desarrollador Junior L2");
			System.out.println("Salario base: 18000-22000");
		}
		else if(años >= 3 && años < 5) {
			System.out.println("Nivel: Desarrollador Senior L1");
			System.out.println("Salario base: 22000-28000");
		}
		else if(años >= 5 && años <= 8) {
			System.out.println("Nivel: Desarrollador Senior L2");
			System.out.println("Salario base: 28000-36000");
		}
		else if(años > 8) {
			System.out.println("Analista/Arquitecto");
			System.out.println("Salario: a convenir en base a rol");
		}
		
	}
	
	//Nombre del metodo: intervalos
	//Parametro de entrada: ninguno
	//Parametro de salida: void
	public static void intervalos() {
		Scanner sc = new Scanner(System.in);
		int primern;
		int finaln;
		long empieza = System.currentTimeMillis();
		
		System.out.println("Dame el primer numero");
		primern = sc.nextInt();
		
		System.out.println("Dame hasta el numero que quieres que llegue");
		finaln = sc.nextInt();
		
		for (; primern <= finaln; primern++) {
			
			if(primern == 1 || primern == 2 || primern == 3 || primern == 5|| primern == 7|| primern == 11) {
				System.out.println("El numero " + primern + " es primo");
			}
			else if(primern % 2 == 0||primern % 3 == 0|| primern % 5 == 0 || primern % 7== 0 || primern % 11== 0) {
				System.out.println("El numero " + primern + " no es primo");
			}
			else {
				System.out.println("El numero " + primern + " es primo");
			}
			
			
		}
		long acaba = System.currentTimeMillis() - empieza;
		System.out.println("El metodo tarda: " + acaba + " nanosegundos");
	}

}
