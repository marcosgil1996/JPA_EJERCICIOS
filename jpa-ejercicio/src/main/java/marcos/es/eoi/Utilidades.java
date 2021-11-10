package marcos.es.eoi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {
	private static Scanner sc = new Scanner(System.in);
	
	private static boolean contieneNumero(String str) {
		boolean contiene = false;
		 for (int i = 0; i < str.length(); i++) {
		 	//SI ES DISTINTO DE NUMERO
            if (!Character.isDigit(str.charAt(i))) {
                contiene = false;
            }
        }
		return contiene;
	}
	
	/*private static int getSpaces(String s) {
	    int spaces = 1; // n�mero de espacios, como m�nimo 1 (NOMBRE APELLIDO)
	    String[] _name = s.split(" ");  // separo el string ingresado
	    spaces = _name.length-1;        // n�mero de cadenas a la que le restamos 1 pues tu quieres el n�mero de espacios
	    return spaces;      // devuelve el n�mero de espacios de la cadena introducida
	}*/
	
	public static String pedirString(String texto) {
		System.out.println(texto);
		String nombreCompleto = sc.nextLine();
		return nombreCompleto;
	}

	public static int pedirEntero(String texto) {
		int entero = 0;
		boolean valorAdmitido = false;
		do {
			try {
				System.out.println(texto);
				entero = sc.nextInt();
				sc.nextLine();
				valorAdmitido = true;
			}catch(InputMismatchException e) {
				System.out.println("SOLO SE PUEDEN INTROUDCIR NUMEROS ENTEROS");
				sc.nextLine();
			}
		}while(!valorAdmitido);
		
		return entero;
	}
}
