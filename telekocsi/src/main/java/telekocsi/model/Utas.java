package telekocsi.model;

import java.util.ArrayList;
import java.util.List;

public class Utas {
	String név;
	String telefon;
	ArrayList<Ut> foglalások;
	
	public Utas(String név, String telefon) {
		this.név = név;
		this.telefon = telefon;
		foglalások = new ArrayList<Ut>();
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
	
	
	
	
	

}
