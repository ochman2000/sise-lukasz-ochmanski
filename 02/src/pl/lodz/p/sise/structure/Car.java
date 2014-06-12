package pl.lodz.p.sise.structure;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
		translate.setToX(400);
		translate.setToY(200);
		translate.setAutoReverse(true);
		translate.setCycleCount(Timeline.INDEFINITE);
		translate.setInterpolator(Interpolator.EASE_BOTH);
		
		rotate = new RotateTransition();
		rotate.setDuration(new Duration(3 * 1000));
		rotate.setNode(this);
		rotate.setFromAngle(0);
		rotate.setToAngle(180);
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
//		System.out.println("equals");
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
}
