package exs;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoMySQL {

	public static void volcarDatos(ArrayList<Definicion> e) {
		StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		for (Definicion d : e) {
			sesion.save(d);
		}
		

		t.commit();
		
	}

}
