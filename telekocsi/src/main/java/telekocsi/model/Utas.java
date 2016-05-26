package telekocsi.model;

import java.util.ArrayList;
import java.util.List;

public class Utas {
	String név;
	String telefon;
	String jelszó;
	ArrayList<Ut> foglalások;
	
	public Utas(String név, String telefon) {
		this.név = név;
		this.telefon = telefon;
		this.foglalások = new ArrayList<Ut>();
	}
	
	public Utas(String név) {
		this.név = név;
		this.foglalások = new ArrayList<Ut>();
	}
	
	public Utas(String név, String telefon, String jelszó) {
		this.név = név;
		this.telefon = telefon;
		this.jelszó = jelszó;
		this.foglalások = new ArrayList<Ut>();
	}


	public String getNév() {
		return név;
	}

	public void setNév(String név) {
		this.név = név;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public ArrayList<Ut> getFoglalások() {
		return foglalások;
	}

	public void setFoglalások(ArrayList<Ut> foglalások) {
		this.foglalások = foglalások;
	}
	
	public void setFoglalások(Ut ut) {
		foglalások.add(ut);
	}

	public String getJelszó() {
		return jelszó;
	}

	public void setJelszó(String jelszó) {
		this.jelszó = jelszó;
	}
	
	
	
	
	
	

}
