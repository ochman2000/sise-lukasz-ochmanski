package pl.lodz.p.sise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.lodz.p.sise.structure.Parking;

/**
 * Simple example demonstrating JavaFX animations.
 * 
 * 2014-06-19, Warsaw, Poland
 * 
 * @author Łukasz Ochmański
 */
public class DrivingClass extends Application {
	
	private Pane pane;
	private Scene scene;

	

	/**
	 * Start the JavaFX application
	 * 
	 * @param stage
	 *            Primary stage.
	 * @throws Exception
	 *             Exception thrown during application.
	 */
	@Override
	public void start(final Stage stage) throws Exception {
		pane = new Parking();

		scene = new Scene(pane, 900, 500);
		scene.getStylesheets().addAll("file:resources/style.css");

		stage.setTitle("Sztuczna Inteligencja i Systemy Ekspertowe by Łukasz Ochmański "
				+ "& Przemysław Szwajkowski");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		Animation animation = new Animation();
		animation.setApplication(this);
		animation.applyAnimation(pane);
		
	}

	/**
	 * Main function for running JavaFX application.
	 * 
	 * @param arguments
	 *            Command-line arguments; optional first argument is the opacity
	 *            of the path to be displayed (0 effectively renders path
	 *            invisible).
	 */
	public static void main(final String[] arguments) {
		Application.launch(arguments);
	}
}