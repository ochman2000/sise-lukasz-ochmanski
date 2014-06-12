package pl.lodz.p.sise.structure;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Plansza extends Application {

	private Pane pane;
	private Scene scene;
	private Car pojazd01;
	private Rectangle line01;
	private Rectangle line02;
	private Rectangle rect02;
	private MenuItem playButton;
	private MenuBar mainMenu;
	private Menu fileMenu;
	private MenuItem stopButton;
	private MenuItem pauseButton;
	private MenuItem restartButton;
	private MenuItem exitButton;

	@Override
	public void start(Stage stage) throws Exception {

		pane = new Pane();
		pane.setId("pane");

		scene = new Scene(pane, 900, 500);
		scene.getStylesheets().addAll(
				this.getClass().getResource("style.css").toExternalForm());

		pojazd01 = new Car();

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

		playButton = new MenuItem("Play");
		pauseButton = new MenuItem("Pause");
		stopButton = new MenuItem("Stop");
		restartButton = new MenuItem("Restart");
		exitButton = new MenuItem("Exit");
		
		Plansza.this.pauseButton.setDisable(true);
		Plansza.this.playButton.setDisable(false);
		Plansza.this.stopButton.setDisable(true);

		fileMenu = new Menu("File");
		fileMenu.getItems().add(playButton);
		fileMenu.getItems().add(pauseButton);
		fileMenu.getItems().add(stopButton);
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(restartButton);
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(exitButton);

		mainMenu = new MenuBar();
		mainMenu.getMenus().add(fileMenu);

		pane.getChildren().addAll(pojazd01, rect02, line01, line02, mainMenu);

		stage.setTitle("Sztuczna Inteligencja i Systemy Ekspertowe by Łukasz Ochmański "
				+ "& Przemysław Szwajkowski");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		playButton.setOnAction(new PlayButtonHandler());
		pauseButton.setOnAction(new PauseButtonHandler());
		stopButton.setOnAction(new StopButtonHandler());
		restartButton.setOnAction(new RestartButtonHandler());
		exitButton.setOnAction(new ExitButtonHandler());
	}

	public static void main(String[] args) {
		Application.launch();
	}

	class PlayButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Plansza.this.pojazd01.getTranslateTransition().play();
			Plansza.this.pojazd01.getRotateTransition().play();
			Plansza.this.pauseButton.setDisable(false);
			Plansza.this.playButton.setDisable(true);
			Plansza.this.stopButton.setDisable(false);
		}
	}

	class PauseButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Plansza.this.pojazd01.getTranslateTransition().pause();
			Plansza.this.pojazd01.getRotateTransition().pause();
			Plansza.this.pauseButton.setDisable(true);
			Plansza.this.playButton.setDisable(false);
			Plansza.this.stopButton.setDisable(false);
		}
	}

	class StopButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Plansza.this.pojazd01.getTranslateTransition().stop();
			Plansza.this.pojazd01.getRotateTransition().stop();
			Plansza.this.pane.getChildren().remove(Plansza.this.pojazd01);

			Plansza.this.pojazd01 = new Car();
			Plansza.this.pane.getChildren().add(Plansza.this.pojazd01);
			Plansza.this.pauseButton.setDisable(true);
			Plansza.this.playButton.setDisable(false);
			Plansza.this.stopButton.setDisable(true);
		}
	}

	class RestartButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Plansza.this.pojazd01.getTranslateTransition().pause();
			Plansza.this.pojazd01.getRotateTransition().pause();

			Plansza.this.pojazd01.getTranslateTransition().jumpTo(Duration.ZERO);
			Plansza.this.pojazd01.getRotateTransition().jumpTo(Duration.ZERO);

			Plansza.this.pojazd01.getTranslateTransition().stop();
			Plansza.this.pojazd01.getRotateTransition().stop();

			Random rnd = new Random();
			int x = rnd.nextInt(500);
			int y = rnd.nextInt(400) - 200;

			Plansza.this.pojazd01.getTranslateTransition().setFromX(x);
			Plansza.this.pojazd01.getTranslateTransition().setFromY(y);
			Plansza.this.pojazd01.setRotate(rnd.nextInt(90) - 45);
			Plansza.this.pojazd01.getTranslateTransition().playFromStart();
			Plansza.this.pojazd01.getRotateTransition().playFromStart();
			
			Plansza.this.pauseButton.setDisable(true);
			Plansza.this.playButton.setDisable(false);
			Plansza.this.stopButton.setDisable(true);
		}
	}

	class ExitButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
		}
	}
}