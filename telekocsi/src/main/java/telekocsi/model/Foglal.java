package telekocsi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import telekocsi.XMLFeldolgozó.Hirdetés;
import telekocsi.XMLFeldolgozó.Utak;
import telekocsi.XMLFeldolgozó.Utasok;

public class Foglal {
	
	public static Boolean időtartam (Ut ut, Utas utas) {
		Boolean időok = true;
		
		for (int i =0; i<utas.getFoglalások().size(); i++) {
			if (utas.getFoglalások().get(i).getIndulás().isBefore(ut.getIndulás()) &&
				utas.getFoglalások().get(i).getÉrkezés().isAfter(ut.getIndulás())) {
				időok = false;
			}
			
			if (utas.getFoglalások().get(i).getÉrkezés().isAfter(ut.getÉrkezés()) &&
				utas.getFoglalások().get(i).getIndulás().isBefore(ut.getÉrkezés())) {
				időok = false;
			}
		}
			// ne utazzunk az időben
			if (ut.getIndulás().isAfter(ut.getÉrkezés())) {
				időok = false;
			}
			
			if (ut.getIndulás().isBefore(LocalDateTime.now()) || 
				ut.getÉrkezés().isBefore(LocalDateTime.now())) {
				időok = false;
			}
		
		return időok;
	}
	
	public static Boolean névOk(String név) {
		ArrayList<String> nevek = new ArrayList<String>();
		ArrayList<Utas> utasok = Utasok.xmlből();
		
		for (int i =0; i<utasok.size(); i++) {
			nevek.add(utasok.get(i).getNév());
		}
		return !nevek.contains(név);
		
	}
	
	public static Boolean telOk(String tel) {
		Boolean tok = true;
		if (!tel.startsWith("06")) {
			tok = false;
		}
		
		if (tel.length() != 11) {
			tok = false;
		}
		return tok;
	}
	
	public static void Foglalás (Ut ut, Utas utas, int helyek) throws NemSikerültException {
		
		Boolean mehet = időtartam(ut, utas);
		
		if (!mehet || helyek > ut.getHelyek()) {
			throw new NemSikerültException();
		}

		
		if (ut.getHelyek() >= helyek && mehet) {
			ut.getUtasok().add(utas);
			ut.setHelyek(ut.getHelyek()-helyek);
			utas.setFoglalások(ut);
			
			Hirdetés.Frissit(ut);
		}
	}

}
