package pl.lodz.p.sise.structure;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Car extends Rectangle {

	private TranslateTransition translate;
	private RotateTransition rotate;
	
	public Car() {
		super(100, 50);
		this.setId("autko");
		this.setY(225);
		
		translate = new TranslateTransition();
		translate.setNode(this);
//		translate.setDuration(new Duration(5 * 1000));
//		translate.setFromX(0);
//		translate.setFromY(0);
//		translate.setToX(710);
//		translate.setToY(0);
//		translate.setAutoReverse(true);
//		translate.setCycleCount(Timeline.INDEFINITE);
//		translate.setInterpolator(Interpolator.EASE_BOTH);
		
		rotate = new RotateTransition();
		rotate.setNode(this);
//		rotate.setDuration(new Duration(5 * 1000));
//		rotate.setFromAngle(0);
//		rotate.setToAngle(30);
//		rotate.setAutoReverse(true);
//		rotate.setCycleCount(Timeline.INDEFINITE);
//		rotate.setInterpolator(Interpolator.EASE_BOTH);
	}
	
	public TranslateTransition getTranslateTransition() {
		return translate;
	}

	public RotateTransition getRotateTransition() {
		return rotate;
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
	
	public void goForward(double distance) {
		System.out.println(this.getRotate());
		double x = distance * Math.cos(Math.toRadians(this.getRotate()));
		double y = distance * Math.sin(Math.toRadians(this.getRotate()));
		move(x, y);
	}
	
	public void rotateCar(double angle) {
		this.getRotateTransition().stop();
		double rot = this.getRotate();
		this.getRotateTransition().setFromAngle(rot);
		this.getRotateTransition().setToAngle(rot+angle);
		this.getRotateTransition().setDuration(new Duration(500));
		this.getRotateTransition().setCycleCount(1);
		this.getRotateTransition().setInterpolator(Interpolator.LINEAR);	
	}
	
	public void move(double x1, double y1) {
		this.getTranslateTransition().stop();
		this.getRotateTransition().stop();

		Point2D nodeCoord = this.localToParent(this.getX(), this.getY());
		double x = nodeCoord.getX();
		double y = nodeCoord.getY();
		
//		System.out.println("Local: "+nodeCoord);
//		System.out.println(this.getX()+" "+this.getY());
//		System.out.println(this.getOffset(0, 0));
//		System.out.println("Rotation: " + this.getRotate());

//		double rot = this.getRotate();
		this.setX(x);
		this.setY(y);
		
		this.getTranslateTransition().setFromX(0);
		this.getTranslateTransition().setFromY(0);
		this.getTranslateTransition().setToX(x1);
		this.getTranslateTransition().setToY(y1);
		this.getTranslateTransition().setDuration(new Duration(500));
		this.getTranslateTransition().setCycleCount(1);
		this.getTranslateTransition().setInterpolator(Interpolator.LINEAR);
	}
}