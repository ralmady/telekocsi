package telekocsi.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import telekocsi.XMLFeldolgozó.Reg;
import telekocsi.model.Foglal;
import telekocsi.model.Utas;

public class RegAblController {
	
	@FXML
	Button KüldGomb;
	
	@FXML
	TextField FelNév;
	
	@FXML
	TextField Tel;
	
	@FXML
	PasswordField jsz;
	
	@FXML
	Label hibaLabel;
	
	public void reg() {
		if (Foglal.névOk(FelNév.getText()) && Foglal.telOk(Tel.getText())) {
		Utas u = new Utas(FelNév.getText(), Tel.getText(), jsz.getText());
			Reg.Regisztráció(u);
			hibaLabel.setText("Sikeres regisztráció");
			hibaLabel.setTextFill(Color.web("#008000"));
			
		}
		
	else {
			hibaLabel.setText("Hiba a bevitt adatokban!");
			hibaLabel.setTextFill(Color.RED);
		}
	} 

}
