package pl.lodz.p.sise;

import javafx.application.Application;
import javafx.scene.Scene;
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
	
	private Parking pane;
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
		pane = Parking.getInstance();
		
		Animation animation = new FuzzyControler();
		animation.setApplication(this);
		animation.applyAnimation(pane);
		pane.setAnimation(animation);

		scene = new Scene(pane, 900, 500);
		String fileName = "/pl/lodz/p/sise/resources/style.css";
		String css = DrivingClass.class.getResource(fileName).toExternalForm();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(css);

		stage.setTitle("Sztuczna Inteligencja i Systemy Ekspertowe by Łukasz Ochmański "
				+ "& Przemysław Szwajkowski");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		
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