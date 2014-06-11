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

	private Pane pane;
	private Scene scene;
	private Rectangle rect;
	private TranslateTransition translate;
	private RotateTransition rotate;
	private Rectangle line01;
	private Rectangle line02;

	@Override
	public void start(Stage stage) throws Exception {
		pane = new Pane();

		scene = new Scene(pane, 600, 300);

		rect = new Rectangle(100, 50);
		rect.setStroke(Color.PINK);
		rect.setFill(Color.RED);
		
		line01 = new Rectangle(2, 20);
		line01.setStroke(Color.WHITE);
		line01.setFill(Color.WHITE);
		
		line02 = new Rectangle(2, 20);
		line02.setStroke(Color.WHITE);
		line02.setFill(Color.WHITE);

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
		pane.getChildren().addAll(line01);
		pane.getChildren().addAll(line02);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		translate.play();
		rotate.play();
	}

//	public static void main(String[] args) {
//		Application.launch("blog.TheTranslateTransition");
//	}
}