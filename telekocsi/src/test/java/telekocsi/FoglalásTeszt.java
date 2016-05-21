package telekocsi;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;

import telekocsi.model.Foglal;
import telekocsi.model.Ut;
import telekocsi.model.Utas;

public class FoglalásTeszt {
	
	private static Ut ut1;
	private static Ut ut2;
	private static Utas utas;
	
	@BeforeClass
	public static void setup() {
		ut1 = new Ut("1", "Debrecen", "Budapest", 2, 3000, LocalDateTime.of(2016, 5, 24, 16, 0) , LocalDateTime.of(2016, 5, 24, 18, 0));
		ut2 = new Ut("2", "Budapest", "Debrecen", 1, 3500, LocalDateTime.of(2016, 5, 24, 19, 0) , LocalDateTime.of(2016, 5, 24, 21, 0));
		utas = new Utas("B", "30");
	}

	@Test
	public void test() {
		utas.setFoglalások(ut1);
		assertEquals(true,Foglal.időtartam(ut2, utas));
	}
	
	@Test
	public void test2() {
		ut1 = new Ut("1", "Debrecen", "Budapest", 2, 3000, LocalDateTime.of(2016, 5, 24, 19, 30) , LocalDateTime.of(2016, 5, 24, 23, 0));
		utas.setFoglalások(ut1);
		assertEquals(false, Foglal.időtartam(ut2, utas));
	}

}
