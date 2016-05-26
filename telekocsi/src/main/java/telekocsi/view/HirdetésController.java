package telekocsi.view;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import telekocsi.XMLFeldolgozó.Hirdetés;
import telekocsi.model.Ut;
import telekocsi.model.Utas;

public class HirdetésController {
	
	@FXML
	Button küldGomb;
	
	@FXML
	TextField idF;
	
	@FXML
	TextField honnanF;
	
	@FXML
	TextField hovaF;
	
	@FXML
	TextField árF;
	
	@FXML
	TextField helyekF;
	
	@FXML
	TextField sofF;
	
	@FXML
	DatePicker indF;
	
	@FXML
	TextField indóF;
	
	@FXML
	DatePicker érkF;
	
	@FXML
	TextField érkóF;
	
	private Stage st;
	private Ut ut;

	private Utas utas;

	private int size;
	
	@FXML
	public void setUt(Ut ut) {
		this.ut = ut;
			sofF.setText(utas.getNév());
			idF.setText(new String(size + ""));
			ut.setId(idF.getText());
			ut.setHonnan(honnanF.getText());
			ut.setHova(hovaF.getText());
			ut.setSof(sofF.getText());			
		}
	
	@FXML
	public void ok() {		
		String[] parts = indóF.getText().split(":");		
		LocalTime time = LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		LocalDateTime lInd = LocalDateTime.of(indF.getValue(), time);
		parts = érkóF.getText().split(":");
		time = LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		LocalDateTime lÉrk = LocalDateTime.of(érkF.getValue(), time);
		ut.setId(idF.getText());
		ut.setHonnan(honnanF.getText());
		ut.setHova(hovaF.getText());
		ut.setHelyek(Integer.parseInt(helyekF.getText()));
		ut.setÁr(Integer.parseInt(árF.getText()));
		ut.setIndulás(lInd);
		ut.setÉrkezés(lÉrk);
		ut.setSof(sofF.getText());

		Hirdetés.Beszúr(ut);
		st.close();
	}


	public void setStage(Stage st) {
		this.st = st;
		
	}

	public void setUtas(Utas utas) {
		this.utas= utas;
		
	}

	public void setUtid(int size) {
		this.size = size;
		
	}
	
}
