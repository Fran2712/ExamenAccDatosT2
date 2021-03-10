package exs;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class AccesoMongo {

	static MongoClient m = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	static MongoDatabase bd = m.getDatabase("Exam");
	static MongoCollection coleccion = bd.getCollection("Definiciones");

	public static void insertarContacto(Definicion c) {
		if (c.getDef().length() > 50) {
			c.setDef(c.getDef().substring(0,50));
		}
		Document doc = new Document();
		doc.put("palabra", c.getPalabra());
		doc.put("def", c.getDef());
		doc.put("ruta", c.getFoto());
		coleccion.insertOne(doc);
	}

	public static ArrayList<Definicion> recuperarContactos() {
		ArrayList<Definicion> defis = new ArrayList();
		FindIterable definiciones = coleccion.find();
		MongoCursor c = definiciones.iterator();

		while (c.hasNext()) {
			Document d = (Document) c.next();
			String palabra = d.getString("palabra");
			String def = d.getString("def");
			String ruta = d.getString("ruta");
			Definicion pal = new Definicion(palabra, def, ruta);
			defis.add(pal);
		}

		return defis;
	}

}
