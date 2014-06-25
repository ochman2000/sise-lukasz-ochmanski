package pl.lodz.p.sise;

import java.util.List;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import pl.lodz.p.sise.structure.Car;

public class Animation {

	Application application;
	private Car vehicle;
	private PathTransition transition;
	
	public Animation(){
		vehicle = new Car();
	}
	
	/**
	 * Generate Path upon which animation will occur.
	 * 
	 * @param pathOpacity
	 *            The opacity of the path representation.
	 * @return Generated path.
	 */
	public Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		path.getElements().add(new MoveTo(60, 250));
		path.getElements().add(new CubicCurveTo(60, 350, 160, 400, 310, 350));
		path.getElements().add(new CubicCurveTo(310, 350, 460, 250, 610, 248));
		path.getElements().add(new LineTo(760, 248));
		
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
		pathTransition.setPath(path);
		pathTransition.setNode(shape);
		pathTransition
				.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
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
		double pathOpacity = 0.0;
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
		final Path path = generateCurvyPath(determinePathOpacity());
		group.getChildren().remove(path);
		group.getChildren().remove(vehicle);
		group.getChildren().add(path);
		group.getChildren().add(vehicle);
		transition = generatePathTransition(vehicle, path);
		transition.play();
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application aplication) {
		this.application = aplication;
	}

	public Car getRedVehicle() {
		return vehicle;
	}

	public void setRedVehicle(Car vehicle) {
		this.vehicle = vehicle;
	}

	public PathTransition getTransition() {
		return transition;
	}

	public void setTransition(PathTransition transition) {
		this.transition = transition;
	}
}
