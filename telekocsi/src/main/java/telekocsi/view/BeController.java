package telekocsi.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import telekocsi.XMLFeldolgozó.Utak;
import telekocsi.XMLFeldolgozó.Utasok;
import telekocsi.model.Ut;
import telekocsi.model.Utas;

public class BeController {
	
	@FXML
	TextField FelhNévField;
	
	@FXML
	PasswordField PasswField;
		
	
	@FXML
	Button BelépőGomb;
	
	@FXML
	Button Reggomb;
	
	@FXML
	Label hLabel;
	
	private ObservableList<Ut> utAdatok= FXCollections.observableArrayList();
	
	public BeController() {
		utAdatok.addAll(Utak.listázó());
	}		
	
	public ObservableList<Ut> getUtAdatok() {
		return utAdatok;
	}
	
	
	
		
	public void Reg() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RegAbl.fxml"));            

			Stage s = new Stage();
			s.setTitle("Regisztráció");
			s.setScene(new Scene(root));
			s.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void Belép() {
		ArrayList<Utas> felhasználók = Utasok.xmlből();
		String név ="";
		String jelsz = "";
		Boolean n = false;
		    
		if (FelhNévField.getText()!= null) {
			név = FelhNévField.getText();
		}
		
		if (PasswField.getText() != null) {
			jelsz = PasswField.getText();
		}
			
		Utas u = null;
		for (int i =0; i<felhasználók.size(); i++) {
			if (felhasználók.get(i).getNév().equals(név) && felhasználók.get(i).getJelszó().equals(jelsz)) {
				u = new Utas(felhasználók.get(i).getNév(), felhasználók.get(i).getTelefon());
				hLabel.setText("");
				
			}
		}
		
		if (u!=null) {
		
		Parent rt=null;
		FXMLLoader loader = null;
		try {
			loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("UtakView.fxml"));
			rt = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            
		
		UtakViewController controller = loader.getController();
		controller.setBeController(this);
		
		Stage st = new Stage();
		controller.setUtas(u);
		st.setTitle("Utak");
		st.setScene(new Scene(rt));
		st.show();
		
		}
		
		if (u == null) {
			for (int i =0; i<felhasználók.size(); i++) {
				if (felhasználók.get(i).getNév().equals(név)) {
					hLabel.setText("Hibás jelszó");
					n = true;
					break;
				}
			}
			
			if (!n) {
				hLabel.setText("Hibás felhasználói név");
			}
			
			
		}
	}

}
