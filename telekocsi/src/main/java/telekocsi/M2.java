package telekocsi;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class M2 extends Application {
	
	private Stage primaryStage;
	private Pane rootPane;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Telekocsi belépés");
		
		createBejelAblak();
		
		
	}

	private void createBejelAblak() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/P.fxml"));
		
		try {
			rootPane = loader.load();
			
			Scene scene = new Scene(rootPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createRegAblak() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/RegAblak.fxml"));
		
		try {
			rootPane = loader.load();
			
			Scene scene = new Scene(rootPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
