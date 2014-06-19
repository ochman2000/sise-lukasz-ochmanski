package pl.lodz.p.sise.structure;

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
	private ImageView pojazd00;
	private ImageView pojazd01;
	private ImageView pojazd03;
	private ImageView pojazd04;
	
	public Parking() {
		super();
		this.setId("pane");

		Image image = new Image("file:resources/car01.png");
		
		line00 = new Rectangle(120, 1);
		line00.setId("linia00");
		line00.getStyleClass().addAll("gruba", "biala");
		line00.setX(700);
		line00.setY(215-2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd00 = new ImageView();
        pojazd00.setImage(image);
        pojazd00.setX(700);
        pojazd00.setY(215+10-2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);

		line01 = new Rectangle(120, 1);
		line01.setId("linia01");
		line01.getStyleClass().addAll("gruba", "biala");
		line01.setX(700);
		line01.setY(215-1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd01 = new ImageView();
        pojazd01.setImage(image);
        pojazd01.setX(700);
        pojazd01.setY(215+10-1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);

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
		
		pojazd03 = new ImageView();
        pojazd03.setImage(image);
        pojazd03.setX(700);
        pojazd03.setY(215+10+1*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line04 = new Rectangle(120, 1);
		line04.setId("linia04");
		line04.getStyleClass().addAll("gruba", "biala");
		line04.setX(700);
		line04.setY(215+2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		pojazd04 = new ImageView();
        pojazd04.setImage(image);
        pojazd04.setX(700);
        pojazd04.setY(215+10+2*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		line05 = new Rectangle(120, 1);
		line05.setId("linia05");
		line05.getStyleClass().addAll("gruba", "biala");
		line05.setX(700);
		line05.setY(215+3*SZEROKOSC_MIEJSCA_PARKINGOWEGO);
		
		this.getChildren().addAll(line00, line01, line02, line03, line04, line05,
				pojazd00, pojazd01, pojazd03, pojazd04);
	}
}