package application;

import Controllers.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/fxml/MainWindow.fxml"));
			StackPane stackPane = loader.load();

			MainWindowController controller = loader.getController();

			Scene scene = new Scene(stackPane);

			primaryStage.setScene(scene);
			primaryStage.setTitle("TempConverter");
			primaryStage.setMinWidth(440);
			primaryStage.setMinHeight(360);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
