package exs;
import java.util.ArrayList;

public class PintarHTML {
	public static String pintarTabla(ArrayList<Definicion> valores) {
		String tabla = "<!DOCTYPE html><html><body><table border='1px'>";

		for (int i = 0; i < valores.size(); i++) {
			tabla += "<tr>";

			tabla += "<td>" + valores.get(i).getPalabra() + "</td>";

			tabla += "<td>" + valores.get(i).getDef() + "</td>";

			tabla += "<td><img src='" + valores.get(i).getFoto()+ "'/></td>";

			tabla += "<tr>";
		}
		tabla += "</table></body></html>\n";
		return tabla;

	}

}
