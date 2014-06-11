package pl.lodz.p.sise.structure;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Plansza extends Application {

	private Pane pane;
	private Scene scene;
	private Rectangle rect01;
	private TranslateTransition translate;
	private RotateTransition rotate;
	private Rectangle line01;
	private Rectangle line02;
	private Rectangle rect02;

	@Override
	public void start(Stage stage) throws Exception {
		pane = new Pane();
		pane.setId("pane");

		scene = new Scene(pane, 900, 500);
		scene.getStylesheets().addAll(
				this.getClass().getResource("style.css").toExternalForm());

		rect01 = new Rectangle(100, 50);
		rect01.setId("autko");

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

		translate = new TranslateTransition();
		translate.setDuration(new Duration(5 * 1000));
		translate.setNode(rect01);
		translate.setToX(400);
		translate.setToY(200);
		translate.setAutoReverse(true);
		translate.setCycleCount(Timeline.INDEFINITE);
		translate.setInterpolator(Interpolator.EASE_BOTH);

		rotate = new RotateTransition();
		rotate.setDuration(new Duration(3 * 1000));
		rotate.setNode(rect01);
		rotate.setByAngle(180);
		rotate.setAutoReverse(true);
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setInterpolator(Interpolator.EASE_BOTH);

		pane.getChildren().addAll(rect01);
		pane.getChildren().addAll(rect02);
		pane.getChildren().addAll(line01);
		pane.getChildren().addAll(line02);

		stage.setTitle("Sztuczna Inteligencja i Systemy Ekspertowe by Łukasz Ochmański "
				+ "& Przemysław Szwajkowski");
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