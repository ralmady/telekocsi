package telekocsi.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import telekocsi.model.Foglal;
import telekocsi.model.NemSikerültException;
import telekocsi.model.Ut;
import telekocsi.model.Utas;

public class UtakViewController {
	
	@FXML
	private TableView<Ut> útTábla;
	
	@FXML
	private TableColumn<Ut, String> honnanOszlop;
	
	@FXML
	private TableColumn<Ut, String> hovaOszlop;
	
	@FXML
	private TableColumn<Ut, LocalDateTime> indulOszlop;
	
	@FXML
	private TableColumn<Ut, LocalDateTime> érkOszlop;
	
	@FXML
	private Label helyekL;
	
	@FXML
	private Label árL;
	
	@FXML 
	private Label sofL;
	
	@FXML
	Button hirdetGomb;
	
	@FXML
	Button foglalG;
	
	private BeController beController;

	private Utas utas;
	
	 public UtakViewController() {
	}
	
	@FXML
	private void initialize() {
		honnanOszlop.setCellValueFactory(cd -> cd.getValue().getHonnanp());
		hovaOszlop.setCellValueFactory(cellData -> cellData.getValue().getHovap());
		indulOszlop.setCellValueFactory(cd -> cd.getValue().getIndulásp());
		érkOszlop.setCellValueFactory(cd -> cd.getValue().getÉrkezésp());
		
		//showUtAdat(null);
		
		útTábla.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showUtAdat(newValue));
	}
	
	private void showUtAdat(Ut ut) {
		if (ut == null) {
			helyekL.setText("");
			árL.setText("");
			sofL.setText("");
		}
		else {
			helyekL.setText(new String(ut.getHelyek() + ""));
			árL.setText(new String(ut.getÁr() + ""));
			sofL.setText(ut.getSof());
		}
		
		
		
	}

	public void setBeController(BeController beController) {
		this.beController = beController;

		útTábla.setItems(beController.getUtAdatok());
	}
	
	public void h() {
		Ut ut = new Ut();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HirdFelad.fxml"));
		try {
			AnchorPane hirdAbl = loader.load();
			Stage st = new Stage();
			st.setTitle("Új hirdetés");
			
			Scene sc = new Scene(hirdAbl);
			st.setScene(sc);
			HirdetésController hc = loader.getController();
			hc.setUtid(beController.getUtAdatok().size());
			hc.setUtas(utas);
			hc.setUt(ut);
		
			hc.setStage(st);
			st.showAndWait();
			if (ut.getHelyek()!= 0) {
				beController.getUtAdatok().add(ut);			
			}
			
		}
		
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public void setUtas(Utas utas) {
		this.utas = utas;
		
	}
	
	public void Foglalás() {
		Ut ut = útTábla.getSelectionModel().getSelectedItem();
		if (ut!= null) {
		int helyek = 1;
		List<Integer> choices = new ArrayList<Integer>();
		for (int i =1; i<=ut.getHelyek(); i++) {
			choices.add(i);
		}
		
		ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
		dialog.setTitle("Foglalások száma");
		dialog.setHeaderText("Hány helyet szeretnél?");
		dialog.setContentText("Helyek");

		Optional<Integer> result = dialog.showAndWait();
		if (result.isPresent()){
		   helyek = result.get();
		}
		try {
			Foglal.Foglalás(ut, utas, helyek);
		}
		catch (NemSikerültException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Hiba történt.");
			alert.setHeaderText("Nem sikerült a foglalás");
			alert.setContentText("Próbáld újra!");

			alert.showAndWait();
		}
		}
	}

}