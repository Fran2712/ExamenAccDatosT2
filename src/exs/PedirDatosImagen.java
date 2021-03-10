package exs;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PedirDatosImagen {
	private static Document doc;
	private static String palabra;
	
	public static void ConectarImages(String palabra2) {
		try {
			doc = Jsoup.connect("https://es.wikipedia.org/wiki/" + palabra2).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String PedirImagen() {	
        String imagen = "https:";
        int cont = 0;
        Elements newsHeadlines = doc.getElementsByClass("image");
        for (Element headline : newsHeadlines) {
            if (cont == 0) {
                imagen = imagen +headline.child(cont).attr("src");
                cont++;
            }
        }
        return imagen;
	}
}
