package exs;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PedirDatos {

	private static Document doc;
	private static String palabra;

	public static void ConectarRae(String palabra) {
		try {
			doc = Jsoup.connect("https://dle.rae.es/" + palabra).get();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String PedirDefinicion() {
		String definicion = "";
		Element article = doc.getElementById("resultados").children().get(0);
		Element e = article.getElementsByTag("p").get(1);
		for (Element asd : e.children()) {
			definicion = definicion + asd.text() + " ";
		}
		
		return definicion;

	}


}
