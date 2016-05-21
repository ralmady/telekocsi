package XMLFeldolgozó;

import java.io.File;
import java.util.ArrayList;

import telekocsi.model.Ut;

public class Hirdetés {
	
	public void Beszúr (Ut ut) {
		File f = new File("");
		ArrayList<Ut> lista = new ArrayList<Ut>();
		lista = (ArrayList<Ut>) Utak.listázó(f);
		
		lista.add(ut);
		
		//xml output				
	}
	
	

}
