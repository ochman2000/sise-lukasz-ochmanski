package pl.lodz.p.sise.structure;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
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

public class Parking02 extends Application {

    //main timeline
    private Timeline timeline;
    private AnimationTimer timer;
 
    //variable for storing actual frame
    private Integer i=0;
    
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
		
		pauseButton.setDisable(true);
		playButton.setDisable(false);
		stopButton.setDisable(true);

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

		pane.getChildren().addAll(rect02, line01, line02, pojazd01, mainMenu);

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
	
	private void run() {
		TranslateTransition tt00 = new TranslateTransition();
		tt00.setNode(pojazd01);
		tt00.setFromX(0);
		tt00.setFromY(0);
		tt00.setToX(100);
		tt00.setToY(100);
		tt00.setDuration(Duration.seconds(2.0));
		
		RotateTransition rt = new RotateTransition();
		rt.setNode(pojazd01);
		rt.setFromAngle(0);
		rt.setToAngle(30);
		rt.setDuration(Duration.seconds(2.0));
		
		Transition t01 = new ParallelTransition(tt00,rt);
		
		TranslateTransition tt01 = new TranslateTransition();
		tt01.setNode(pojazd01);
		tt01.setFromX(100);
		tt01.setFromY(100);
		tt01.setToX(200);
		tt01.setToY(0);
		tt01.setDuration(Duration.seconds(2.0));
		
		RotateTransition rt01 = new RotateTransition();
		rt01.setNode(pojazd01);
		rt01.setFromAngle(30);
		rt01.setToAngle(-30);
		rt01.setDuration(Duration.seconds(2.0));
		
		Transition t02 = new ParallelTransition(tt01,rt01);
		
		TranslateTransition tt02 = new TranslateTransition();
		tt02.setNode(pojazd01);
		tt02.setFromX(200);
		tt02.setFromY(0);
		tt02.setToX(300);
		tt02.setToY(100);
		tt02.setDuration(Duration.seconds(2.0));
		
		RotateTransition rt02 = new RotateTransition();
		rt02.setNode(pojazd01);
		rt02.setFromAngle(-30);
		rt02.setToAngle(30);
		rt02.setDuration(Duration.seconds(2.0));
		
		Transition t03 = new ParallelTransition(tt02,rt02);
		
		Transition all = new SequentialTransition(t01, t02, t03);
		all.playFrom(Duration.seconds(0.0));
	}

	public static void main(String[] args) {
		Application.launch();
	}

	class PlayButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Parking02.this.run();
//			Plansza.this.pojazd01.rotateCar(10);
//			Plansza.this.pojazd01.goForward(50);
//			Plansza.this.pojazd01.move(50, 50);
//			Parking02.this.pojazd01.parkuj();
//			Parking.this.pojazd01.getTranslateTransition().play();
//			Parking.this.pojazd01.getRotateTransition().play();
//			Plansza.this.pauseButton.setDisable(false);
//			Plansza.this.playButton.setDisable(true);
//			Plansza.this.stopButton.setDisable(false);
			
	        
		}
	}

	class PauseButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
//			Parking.this.pojazd01.getTranslateTransition().pause();
//			Parking.this.pojazd01.getRotateTransition().pause();
			Parking02.this.pauseButton.setDisable(true);
			Parking02.this.playButton.setDisable(false);
			Parking02.this.stopButton.setDisable(false);
			System.out.println(Parking02.this.pojazd01.getOffset(
					Parking02.this.rect02.getX()+10, Parking02.this.rect02.getY()+10));
		}
	}

	class StopButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Parking02.this.pojazd01.getTranslateTransition().stop();
			Parking02.this.pojazd01.getRotateTransition().stop();
			Parking02.this.pane.getChildren().remove(Parking02.this.pojazd01);

			Parking02.this.pojazd01 = new Car();
			Parking02.this.pane.getChildren().add(Parking02.this.pojazd01);
			Parking02.this.pauseButton.setDisable(true);
			Parking02.this.playButton.setDisable(false);
			Parking02.this.stopButton.setDisable(true);
		}
	}

	class RestartButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			Parking02.this.pojazd01.getTranslateTransition().stop();
			Parking02.this.pojazd01.getRotateTransition().stop();
			Parking02.this.pane.getChildren().remove(Parking02.this.pojazd01);

			Parking02.this.pojazd01 = new Car();
			Parking02.this.pane.getChildren().add(Parking02.this.pojazd01);

			Random rnd = new Random();
			int x = rnd.nextInt(500)+100;
			int y = rnd.nextInt(300)+100;
			int rot = rnd.nextInt(90) - 45;
			
			Parking02.this.pojazd01.setX(x);
			Parking02.this.pojazd01.setY(y);
			Parking02.this.pojazd01.setRotate(rot);

			Parking02.this.pojazd01.getTranslateTransition().setFromX(0);
			Parking02.this.pojazd01.getTranslateTransition().setFromY(0);
			Parking02.this.pojazd01.getRotateTransition().setFromAngle(rot);
			
			Parking02.this.pauseButton.setDisable(true);
			Parking02.this.playButton.setDisable(false);
			Parking02.this.stopButton.setDisable(false);
		}
	}

	class ExitButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
    class OnFinishedHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent t) {
//             Parking.this.pojazd01.setTranslateX(20);
//             Parking.this.pojazd01.parkuj();
             //reset counter
             i = 0;
        }
    };
}