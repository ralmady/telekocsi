package telekocsi.model;

import java.util.ArrayList;

import XMLFeldolgozó.Utak;

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
		return időok;
	}
	
	public static void Foglalás (Ut ut, Utas utas, int helyek) {
		
		Boolean mehet = időtartam(ut, utas);		

		
		if (ut.getHelyek() > helyek && mehet) {
			ut.getUtasok().add(utas);
			ut.setHelyek(ut.getHelyek()-helyek);
			utas.setFoglalások(ut);
			
			//xml-ek frissítése
		}
	}

}
