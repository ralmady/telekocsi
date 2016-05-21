package telekocsi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ut {
	String id;
	String honnan;
	String hova;
	int helyek;
	int ár;
	LocalDateTime indulás;
	LocalDateTime érkezés;
	ArrayList<Utas> utasok;
	
	public Ut(String id, String honnan, String hova, int helyek, int ár, LocalDateTime indulás, LocalDateTime érkezés) {
		super();
		this.id = id;
		this.honnan = honnan;
		this.hova = hova;
		this.helyek = helyek;
		this.ár = ár;
		this.indulás = indulás;
		this.érkezés = érkezés;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHonnan() {
		return honnan;
	}

	public void setHonnan(String honnan) {
		this.honnan = honnan;
	}

	public String getHova() {
		return hova;
	}

	public void setHova(String hova) {
		this.hova = hova;
	}

	public int getHelyek() {
		return helyek;
	}

	public void setHelyek(int helyek) {
		this.helyek = helyek;
	}

	public int getÁr() {
		return ár;
	}

	public void setÁr(int ár) {
		this.ár = ár;
	}

	public LocalDateTime getIndulás() {
		return indulás;
	}

	public void setIndulás(LocalDateTime indulás) {
		this.indulás = indulás;
	}

	public LocalDateTime getÉrkezés() {
		return érkezés;
	}

	public void setÉrkezés(LocalDateTime érkezés) {
		this.érkezés = érkezés;
	}

	public List<Utas> getUtasok() {
		return utasok;
	}

	public void setUtasok(ArrayList<Utas> utasok) {
		this.utasok = utasok;
	}
	
	
	

}
