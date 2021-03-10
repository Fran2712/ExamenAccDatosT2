package exs;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EntradaSalida {

	public static final int BUSCAR = 1;
	public static final int LISTAR_PALABRAS= 2;
	public static final int VOLCAR_DATOS = 3;
	public static final int SALIR = 4;
	private static Scanner in;

	
	public static int mostrarMenu() {
		System.out.println("¿Qué desea Hacer?");
		System.out.println("1- Buscar palabra en la RAE");
		System.out.println("2- Listar palabras");
		System.out.println("3- Volcar Datos a MySQL");
		System.out.println("4- Salir");
		in = new Scanner(System.in);
		int res;
		res = in.nextInt();
		
		return res;
	}


	public static String leerPalabra() {
		in = new Scanner(System.in);
		System.out.println("Introduzca la palabra a buscar:");
		String pala = in.nextLine();
		
		return pala;
	}


	public static void construirDocumento(String tabla) {
		try {
			FileWriter fw = new FileWriter("D:\\DAM_II-Workspaces\\FICHEROS\\fichero7.html", false);
			fw.write(tabla);
			fw.close();
			ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
					"D:\\DAM_II-Workspaces\\FICHEROS\\fichero7.html");
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
