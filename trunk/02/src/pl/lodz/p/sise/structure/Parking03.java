package pl.lodz.p.sise.structure;

import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Simple example demonstrating JavaFX animations.
 * 
 * Slightly adapted from Example 2 ("Path Transition") which is provided in
 * "Creating Transitions and Timeline Animation in JavaFX"
 * (http://docs.oracle.com/javafx/2.0/animations/jfxpub-animations.htm).
 * 
 * @author Dustin
 */
public class Parking03 extends Application {
	private Pane pane;
	private Scene scene;
	private Car pojazd01;
	private Rectangle rect02;
	private Rectangle line01;
	private Rectangle line02;

	/**
	 * Generate Path upon which animation will occur.
	 * 
	 * @param pathOpacity
	 *            The opacity of the path representation.
	 * @return Generated path.
	 */
	private Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		path.getElements().add(new MoveTo(200, 200));
		path.getElements().add(new CubicCurveTo(200, 200, 200, 200, 300, 300));
		path.getElements().add(new CubicCurveTo(300, 300, 300, 300, 350, 300));
		path.setOpacity(pathOpacity);
		return path;
	}

	/**
	 * Generate the path transition.
	 * 
	 * @param shape
	 *            Shape to travel along path.
	 * @param path
	 *            Path to be traveled upon.
	 * @return PathTransition.
	 */
	private PathTransition generatePathTransition(final Shape shape,
			final Path path) {
		final PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.seconds(8.0));
		pathTransition.setDelay(Duration.seconds(2.0));
		pathTransition.setPath(path);
		pathTransition.setNode(shape);
		pathTransition
				.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		return pathTransition;
	}

	/**
	 * Determine the path's opacity based on command-line argument if supplied
	 * or zero by default if no numeric value provided.
	 * 
	 * @return Opacity to use for path.
	 */
	private double determinePathOpacity() {
		final Parameters params = getParameters();
		final List<String> parameters = params.getRaw();
		double pathOpacity = 1.0;
		if (!parameters.isEmpty()) {
			try {
				pathOpacity = Double.valueOf(parameters.get(0));
			} catch (NumberFormatException nfe) {
				pathOpacity = 0.0;
			}
		}
		return pathOpacity;
	}

	/**
	 * Apply animation, the subject of this class.
	 * 
	 * @param group
	 *            Group to which animation is applied.
	 */
	private void applyAnimation(final Pane group) {
		Rectangle pojazd01 = new Car();
		final Path path = generateCurvyPath(determinePathOpacity());
		group.getChildren().add(path);
		group.getChildren().add(pojazd01);
		final PathTransition transition = generatePathTransition(pojazd01, path);
		transition.play();
	}

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
		pane = new Pane();
		pane.setId("pane");

		scene = new Scene(pane, 900, 500);
		scene.getStylesheets().addAll(
				this.getClass().getResource("style.css").toExternalForm());

		pojazd01 = new Car();

		rect02 = new Rectangle(120, 70);
		rect02.setId("miejsce");
		rect02.getStyleClass().add("gruba");
		rect02.setX(700);
		rect02.setY(215);

		line01 = new Rectangle(136, 1);
		line01.setId("linia01");
		line01.getStyleClass().add("cienka");
		line01.setX(700 - 8);
		line01.setY(500 / 2 - (50 + 20) / 2 + 34);
		line01.setRotate(30.0);

		line02 = new Rectangle(136, 1);
		line02.setId("linia02");
		line02.getStyleClass().add("cienka");
		line02.setX(700 - 7);
		line02.setY(500 / 2 + (50 - 20) / 2 - 16);
		line02.setRotate(60 + 90.0);
		
		pane.getChildren().addAll(rect02, line01, line02, pojazd01);

		stage.setTitle("Sztuczna Inteligencja i Systemy Ekspertowe by Łukasz Ochmański "
				+ "& Przemysław Szwajkowski");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		applyAnimation(pane);
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