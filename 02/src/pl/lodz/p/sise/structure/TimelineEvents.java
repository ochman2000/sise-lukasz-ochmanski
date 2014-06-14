package pl.lodz.p.sise.structure;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
 
public class TimelineEvents extends Application {
    
    //main timeline
    private Timeline timeline;
    private AnimationTimer timer;
 
    //variable for storing actual frame
    private Integer i=0;
	private Car pojazd01;
	private Rectangle rect02;
	private Rectangle line01;
	private Rectangle line02;
 
    @Override public void start(Stage stage) {
        Group p = new Group();
        Scene scene = new Scene(p);
        p.setId("pane");
        stage.setScene(scene);
        stage.setWidth(900);
        stage.setHeight(500);
        p.setTranslateX(0);
        p.setTranslateY(0);
 
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
        
        //create a layout for circle with text inside
        final StackPane stack = new StackPane();
        stack.getChildren().addAll(pojazd01);
        stack.setLayoutX(30);
        stack.setLayoutY(30);
 
        p.getChildren().addAll(rect02, line01, line02, stack);
        stage.show();
 
        //create a timeline for moving the circle
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
 
//You can add a specific action when each frame is started.
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
//                pojazd01.move(10, 10);
            	System.out.println("go");
                i++;
            }
        };
 
        //create a keyValue with factory: scaling the circle 2times
//        Timeline timeline = new Timeline();

//                    new KeyFrame(new Duration(40000), // set end position at 40s
//                       new KeyValue(pojazd01.translateXProperty(), 100),
//                       new KeyValue(pojazd01.translateYProperty(), 100));

        // play 40s of animation
//        timeline.play();
 
        final DoubleProperty translate = new SimpleDoubleProperty();
        pojazd01.translateXProperty().bind(translate);
        
        //create a keyFrame, the keyValue is reached at time 2s
        Duration duration = Duration.millis(2000);
        //one can add a specific action when the keyframe is reached
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	timeline.stop();
                 pojazd01.setX(400);
                 KeyFrame keyFrame = new KeyFrame(
                         Duration.seconds(2),
                         new KeyValue(translate, 200)
                     
                 );
                
                       //add the keyframe to the timeline
                       timeline.getKeyFrames().add(keyFrame);
                
                       timeline.play();

                 System.out.println("move");
                 //reset counter
                 i = 0;
            }
        };
 
  KeyFrame keyFrame = new KeyFrame(duration, onFinished , 
		  new KeyValue(pojazd01.translateXProperty(), 100),
          new KeyValue(pojazd01.translateYProperty(), 100));
 
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
 
        timeline.play();
//        timer.start();
    }
        
        
    public static void main(String[] args) {
        Application.launch(args);
    }
  } 