package XMLFeldolgozó;

import java.io.File;
import java.util.ArrayList;

import telekocsi.model.Utas;

public class Reg {
	
	public static void Regisztráció (Utas utas, String jelszó) {
		ArrayList<Utas> lista = new ArrayList<Utas>();
		File f = new File("");
		lista = Utasok.xmlből(f);
		lista.add(utas);
		
		//xmloutput
	}
	
	public static void Frissít(Utas utas) {
		
	}

}
