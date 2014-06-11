package blog;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TheTranslateTransition extends Application {

	Pane pane;
	Scene scene;
	Rectangle rect;
	TranslateTransition translate;
	RotateTransition rotate;

	@Override
	public void start(Stage stage) throws Exception {
		pane = new Pane();

		scene = new Scene(pane, 600, 300);

		rect = new Rectangle(100, 50);
		rect.setStroke(Color.SLATEGRAY);
		rect.setFill(Color.WHITESMOKE);

		translate = new TranslateTransition();
		translate.setDuration(new Duration(5 * 1000));
		translate.setNode(rect);
		translate.setToX(400);
		translate.setToY(200);
		translate.setAutoReverse(true);
		translate.setCycleCount(Timeline.INDEFINITE);
		translate.setInterpolator(Interpolator.EASE_BOTH);

		rotate = new RotateTransition();
		rotate.setDuration(new Duration(3 * 1000));
		rotate.setNode(rect);
		rotate.setByAngle(180);
		rotate.setAutoReverse(true);
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setInterpolator(Interpolator.EASE_BOTH);

		pane.getChildren().addAll(rect);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		translate.play();
		rotate.play();
	}

	public static void main(String[] args) {
		Application.launch("blog.TheTranslateTransition");
	}
}