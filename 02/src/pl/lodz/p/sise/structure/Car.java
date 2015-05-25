package pl.lodz.p.sise.structure;

import java.io.InputStream;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Car extends ImageView {

	private Duration elapsed;
	
	public Car() {
		super();
		String filename = "/pl/lodz/p/sise/resources/car02.png";
		InputStream in = this.getClass().getResourceAsStream(filename);
		Image image = new Image(in);
		this.setImage(image);
		this.setId("autko");
//		this.setY(225);
		this.setX(-200);
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		if (obj == this)
			return true;
		if ((((Car) obj).getId()).equals(this.getId()))
			return true;
		else
			return false;
	}
	
	public Point2D getOffset(double x, double y) {
		Point2D nodeCoord = this.localToParent(this.getX(), this.getY());
		double offsetX = nodeCoord.getX() - x;
		double offsetY = nodeCoord.getY() - y;
		Point2D offset = new Point2D(offsetX, offsetY);
		return offset;
	}
	
	public void incrementElapsed(double d) {
		if (this.getElapsed()==null) {
			this.setElapsed(d);
		}
		else {
			this.setElapsed(this.getElapsed().add(Duration.seconds(d)).toSeconds());
		}
	}
	
	public Duration getElapsed() {
		return elapsed;
	}

	public void setElapsed(double sec) {
		this.elapsed = Duration.seconds(sec);
	}
}