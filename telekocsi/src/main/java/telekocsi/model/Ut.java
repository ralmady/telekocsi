package telekocsi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ut {
	StringProperty id;
	StringProperty honnan;
	StringProperty hova;
	IntegerProperty helyek;
	IntegerProperty ár;
	ObjectProperty<LocalDateTime> indulás;
	ObjectProperty<LocalDateTime> érkezés;
	StringProperty sof;
	ArrayList<Utas> utasok;
	
	public Ut(String id, String honnan, String hova, int helyek, int ár, LocalDateTime indulás, LocalDateTime érkezés, String sof) {
		this.id = new SimpleStringProperty(id);
		this.honnan = new SimpleStringProperty(honnan);
		this.hova = new SimpleStringProperty(hova);
		this.helyek = new SimpleIntegerProperty(helyek);
		this.ár = new SimpleIntegerProperty(ár);
		this.indulás = new SimpleObjectProperty<LocalDateTime>(indulás);
		this.érkezés = new SimpleObjectProperty<LocalDateTime>(érkezés);
		this.sof = new SimpleStringProperty(sof);
		this.utasok = new ArrayList<Utas>();
	}
	
	public Ut(String id, String honnan, String hova, int helyek, int ár, LocalDateTime indulás, LocalDateTime érkezés, String sof, String utasaim) {
		this.id = new SimpleStringProperty(id);
		this.honnan = new SimpleStringProperty(honnan);
		this.hova = new SimpleStringProperty(hova);
		this.helyek = new SimpleIntegerProperty(helyek);
		this.ár = new SimpleIntegerProperty(ár);
		this.indulás = new SimpleObjectProperty<LocalDateTime>(indulás);
		this.érkezés = new SimpleObjectProperty<LocalDateTime>(érkezés);
		this.sof = new SimpleStringProperty(sof);
		this.utasok = new ArrayList<Utas>();
		String[] uk = utasaim.split(",");
		
		for (int i =0; i<uk.length; i++) {
			utasok.add(new Utas(uk[i]));
		}
		
	}

	public Ut() {
		this(null, null, null, 0, 0, null, null, null);
	}

	public String getId() {
		return id.get();
	}
	
	public StringProperty getIdp() {
		return id;
	}

	public void setId(String id) {
		this.id.set(id);
	}
	
	public String getSof() {
		return sof.get();
	}
	
	public StringProperty getSofp() {
		return sof;
	}	

	public void setSof(String sof) {
		this.sof.set(sof);
	}

	public String getHonnan() {
		return honnan.get();
	}
	
	public StringProperty getHonnanp() {
		return honnan;
	}

	public void setHonnan(String honnan) {
		this.honnan.set(honnan);
	}

	public String getHova() {
		return hova.get();
	}
	
	public StringProperty getHovap() {
		return hova;
	}

	public void setHova(String hova) {
		this.hova.set(hova);
	}

	public int getHelyek() {
		return helyek.get();
	}
	
	public IntegerProperty getHelyekp() {
		return helyek;
	}

	public void setHelyek(int helyek) {
		this.helyek.set(helyek);
	}

	public int getÁr() {
		return ár.get();
	}
	
	public IntegerProperty getÁrp() {
		return ár;
	}

	public void setÁr(int ár) {
		this.ár.set(ár);
	}

	public LocalDateTime getIndulás() {
		return indulás.get();
	}
	
	public ObjectProperty<LocalDateTime> getIndulásp() {
		return indulás;
	}

	public void setIndulás(LocalDateTime indulás) {
		this.indulás.set(indulás);
	}

	public LocalDateTime getÉrkezés() {
		return érkezés.get();
	}
	
	public ObjectProperty<LocalDateTime> getÉrkezésp() {
		return érkezés;
	}

	public void setÉrkezés(LocalDateTime érkezés) {
		this.érkezés.set(érkezés);
	}

	public List<Utas> getUtasok() {
		return utasok;
	}

	public void setUtasok(ArrayList<Utas> utasok) {
		this.utasok = utasok;
	}
}
