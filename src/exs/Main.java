package exs;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		int opcion = EntradaSalida.mostrarMenu();
		while (opcion != EntradaSalida.SALIR && opcion < EntradaSalida.SALIR) {
			switch (opcion) {
			case EntradaSalida.BUSCAR:
				String palabra = EntradaSalida.leerPalabra();
				PedirDatos.ConectarRae(palabra);
				String definicion = PedirDatos.PedirDefinicion();
				System.out.println(definicion);
				
				PedirDatosImagen.ConectarImages(palabra);
				String ruta = PedirDatosImagen.PedirImagen();
				Definicion d = new Definicion(palabra,definicion,ruta);
				AccesoMongo.insertarContacto(d);
				System.out.println(ruta);
				break;
			case EntradaSalida.LISTAR_PALABRAS:
				
				ArrayList<Definicion> s = AccesoMongo.recuperarContactos();
				String tabla = PintarHTML.pintarTabla(s);
				EntradaSalida.construirDocumento(tabla);
				
				break;
			case EntradaSalida.VOLCAR_DATOS:
				ArrayList<Definicion> e = AccesoMongo.recuperarContactos();
				AccesoMySQL.volcarDatos(e);
				break;
			case EntradaSalida.SALIR:
				
				
				break;
			default:
				
				
				System.out.println("selecciona una opcion válida");
				break;

			}
			opcion =EntradaSalida.mostrarMenu();

		}

	}

}
