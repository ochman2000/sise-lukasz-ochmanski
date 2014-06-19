package pl.lodz.p.sise.structure;

import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Simple example demonstrating JavaFX animations.
 * 
 * 2014-06-19, Warsaw, Poland
 * 
 * @author Łukasz Ochmański
 */
public class Parking extends Application {
	private static final int SZEROKOSC_MIEJSCA_PARKINGOWEGO = 70;
	private Pane pane;
	private Scene scene;
	private Car pojazd02;
	private Rectangle line01;
	private Rectangle line02;
	private Rectangle line03;
	private Rectangle line04;
	private Rectangle line05;
	private Rectangle line00;
	private ImageView pojazd01;
	private ImageView pojazd03;
	private ImageView pojazd04;
	private ImageView pojazd00;

	/**
	 * Generate Path upon which animation will occur.
	 * 
	 * @param pathOpacity
	 *            The opacity of the path representation.
	 * @return Generated path.
	 */
	private Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		path.getElements().add(new MoveTo(100, 200));
		path.getElements().add(new CubicCurveTo(100, 200, 200, 300, 300, 200));
		path.getElements().add(new CubicCurveTo(300, 200, 400, 100, 500, 200));
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
	private PathTransition generatePathTransition(final ImageView shape,
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
		ImageView pojazd01 = new Car();
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

		Image image = new Image(this.getClass().getResource("car01.png").toExternalForm());
		pojazd02 = new Car();
		
		line00 = new Rectangle(120, 1);
		line00.setId("linia00");
		line00.getStyleClass().addAll("gruba", "biala");
		line00.setX(700);
		line00.setY(215-2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd00 = new ImageView();
        pojazd00.setImage(image);
        pojazd00.setX(700);
        pojazd00.setY(215+10-2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);

		line01 = new Rectangle(120, 1);
		line01.setId("linia01");
		line01.getStyleClass().addAll("gruba", "biala");
		line01.setX(700);
		line01.setY(215-1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd01 = new ImageView();
        pojazd01.setImage(image);
        pojazd01.setX(700);
        pojazd01.setY(215+10-1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);

		line02 = new Rectangle(120, 1);
		line02.setId("linia02");
		line02.getStyleClass().addAll("gruba", "biala");
		line02.setX(700);
		line02.setY(215+0*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line03 = new Rectangle(120, 1);
		line03.setId("linia03");
		line03.getStyleClass().addAll("gruba", "biala");
		line03.setX(700);
		line03.setY(215+1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd03 = new ImageView();
        pojazd03.setImage(image);
        pojazd03.setX(700);
        pojazd03.setY(215+10+1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line04 = new Rectangle(120, 1);
		line04.setId("linia04");
		line04.getStyleClass().addAll("gruba", "biala");
		line04.setX(700);
		line04.setY(215+2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd04 = new ImageView();
        pojazd04.setImage(image);
        pojazd04.setX(700);
        pojazd04.setY(215+10+2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line05 = new Rectangle(120, 1);
		line05.setId("linia05");
		line05.getStyleClass().addAll("gruba", "biala");
		line05.setX(700);
		line05.setY(215+3*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pane.getChildren().addAll(line00, line01, line02, line03, line04, line05,
				pojazd00, pojazd01, pojazd02, pojazd03, pojazd04);

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