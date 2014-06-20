package pl.lodz.p.sise.structure;

import pl.lodz.p.sise.handlers.*;
import pl.lodz.p.sise.Animation;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Simple example demonstrating JavaFX animations.
 * 
 * 2014-06-19, Warsaw, Poland
 * 
 * @author Łukasz Ochmański
 */
public class Parking extends Pane {
	private static final int SZEROKOSC_MIEJSCA_PARKINGOWEGO = 70;
	private Rectangle line01;
	private Rectangle line02;
	private Rectangle line03;
	private Rectangle line04;
	private Rectangle line05;
	private Rectangle line00;
	private ImageView vehicle00;
	private ImageView vehicle01;
	private ImageView vehicle02;
	private ImageView vehicle03;
	
	private MenuItem playButton;
	private MenuItem pauseButton;
	private MenuItem stopButton;
	private MenuItem restartButton;
	private MenuItem exitButton;
	private Menu fileMenu;
	private MenuBar mainMenu;
	
	private Animation animation;
	
	private static Parking instance;
	
	private Parking() {
		super();
		this.setId("pane");

		Image image = new Image("file:resources/car01.png");
		
		line00 = new Rectangle(120, 1);
		line00.setId("linia00");
		line00.getStyleClass().addAll("gruba", "biala");
		line00.setX(700);
		line00.setY(215-2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		vehicle00 = new ImageView();
        vehicle00.setImage(image);
        vehicle00.setX(700);
        vehicle00.setY(215+10-2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);

		line01 = new Rectangle(120, 1);
		line01.setId("linia01");
		line01.getStyleClass().addAll("gruba", "biala");
		line01.setX(700);
		line01.setY(215-1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		vehicle01 = new ImageView();
        vehicle01.setImage(image);
        vehicle01.setX(700);
        vehicle01.setY(215+10-1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);

		line02 = new Rectangle(120, 1);
		line02.setId("linia02");
		line02.getStyleClass().addAll("gruba", "biala");
		line02.setX(700);
		line02.setY(215+0*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line03 = new Rectangle(120, 1);
		line03.setId("linia03");
		line03.getStyleClass().addAll("gruba", "biala");
		line03.setX(700);
		line03.setY(215+1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		vehicle02 = new ImageView();
        vehicle02.setImage(image);
        vehicle02.setX(700);
        vehicle02.setY(215+10+1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line04 = new Rectangle(120, 1);
		line04.setId("linia04");
		line04.getStyleClass().addAll("gruba", "biala");
		line04.setX(700);
		line04.setY(215+2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		vehicle03 = new ImageView();
        vehicle03.setImage(image);
        vehicle03.setX(700);
        vehicle03.setY(215+10+2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line05 = new Rectangle(120, 1);
		line05.setId("linia05");
		line05.getStyleClass().addAll("gruba", "biala");
		line05.setX(700);
		line05.setY(215+3*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		playButton = new MenuItem("Play");
        pauseButton = new MenuItem("Pause");
        stopButton = new MenuItem("Stop");
        restartButton = new MenuItem("Restart");
        exitButton = new MenuItem("Exit");
        
        playButton.setOnAction(new PlayButtonHandler());
        pauseButton.setOnAction(new PauseButtonHandler());
        stopButton.setOnAction(new StopButtonHandler());
        restartButton.setOnAction(new RestartButtonHandler());
        exitButton.setOnAction(new ExitButtonHandler());

        
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
		
		this.getChildren().addAll(line00, line01, line02, line03, line04, line05,
				vehicle00, vehicle01, vehicle02, vehicle03, mainMenu);
	}
	
	public static Parking getInstance() {
		if (instance==null) 
			instance = new Parking();
		return instance;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation2) {
		this.animation = animation2;
	}
}