package pl.lodz.p.sise;

import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import pl.lodz.p.sise.structure.Car;

public class Animation {

	Application application;
	private Car pojazd02;
	
	/**
	 * Generate Path upon which animation will occur.
	 * 
	 * @param pathOpacity
	 *            The opacity of the path representation.
	 * @return Generated path.
	 */
	private Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		path.getElements().add(new MoveTo(100, 250));
		path.getElements().add(new CubicCurveTo(100, 250, 200, 300, 300, 200));
//		path.getElements().add(new CubicCurveTo(100, 200, 200, 300, 300, 200));
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
		final Parameters params = this.getApplication().getParameters();
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
	public void applyAnimation(final Pane group) {
		pojazd02 = new Car();
		final Path path = generateCurvyPath(determinePathOpacity());
		group.getChildren().add(path);
		group.getChildren().add(pojazd02);
		final PathTransition transition = generatePathTransition(pojazd02, path);
		transition.play();
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application aplication) {
		this.application = aplication;
	}

	public Car getPojazd02() {
		return pojazd02;
	}

	public void setPojazd02(Car pojazd02) {
		this.pojazd02 = pojazd02;
	}
}
