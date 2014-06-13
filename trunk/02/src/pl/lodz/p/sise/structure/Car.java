package pl.lodz.p.sise.structure;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
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
		translate.setDuration(new Duration(5 * 1000));
		translate.setNode(this);
		translate.setFromX(0);
		translate.setFromY(0);
		translate.setToX(710);
		translate.setToY(0);
		translate.setAutoReverse(true);
		translate.setCycleCount(Timeline.INDEFINITE);
		translate.setInterpolator(Interpolator.EASE_BOTH);
		
		rotate = new RotateTransition();
		rotate.setDuration(new Duration(5 * 1000));
		rotate.setNode(this);
		rotate.setFromAngle(0);
		rotate.setToAngle(0);
		rotate.setAutoReverse(true);
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setInterpolator(Interpolator.EASE_BOTH);
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
//		final Point2D windowCoord = new Point2D(scene.getWindow().getX(), scene.getWindow().getY());
//		final Point2D sceneCoord = new Point2D(scene.getX(), scene.getY());
//		final Point2D paneCoord = new Point2D(pane.getLayoutX(), pane.getLayoutY());
//		System.out.println("Do celu:\tx: "+clickX+"\ty: "+clickY);
		
		//double celX = scene.getWidth()-(rect02.getWidth()-10);
		//double celY = scene.getHeight()/2-(rect02.getHeight()-10);
		
		Point2D nodeCoord = this.localToParent(this.getX(), this.getY());
//		Point2D nodeCoord = new Point2D(Plansza.this.pojazd01.getX(), Plansza.this.pojazd01.getY());
		
//		Point2D parkingCoord = new Point2D(Plansza.this.rect02.getX(), Plansza.this.rect02.getY());
		double offsetX = nodeCoord.getX() - x;
		double offsetY = nodeCoord.getY() - y;
		Point2D offset = new Point2D(offsetX, offsetY);
		
//		System.out.println("Parking:\tx: "+clickX+"\ty: "+clickY);
//		System.out.println("Pause");
//		System.out.println("Window " + windowCoord);
//		System.out.println("Scene " + sceneCoord);
//		System.out.println("Scene dimensions: " +scene.getWidth() +" "+ scene.getHeight());
//		System.out.println("Pane " + paneCoord);
//		System.out.println("Car " + nodeCoord);
//		System.out.println("Parking " + parkingCoord);
//		System.out.println("Missing " + offset);
		return offset;
	}
}
