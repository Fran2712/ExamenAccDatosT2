package exs;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Definiciones")
public class Definicion {
	@Id
	@GeneratedValue
	private int id;

	private String palabra;
	private String def;
	private String foto;
	
	
	public Definicion() {

	}

	public Definicion(String palabra, String def, String foto) {
		this.palabra = palabra;
		this.def = def;
		this.foto = foto;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	

}
