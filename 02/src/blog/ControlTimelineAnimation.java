package blog;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class ControlTimelineAnimation extends Application{
 
    Text hello;
 
    TextField playFromDuration;
    Button playFrom;
    Button playFromStart;
    Button stop;
 
    Scene scene;
    HBox buttonHolder;
    Pane pane;
    VBox layout;
 
    Timeline timeline;
    KeyFrame startFrame;
    KeyFrame endFrame;
 
    List<Paint> colors = new ArrayList<>();
    Random rand = new Random();
 
    @Override
    public void start(Stage stage) throws Exception {
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
 
        buttonHolder = HBoxBuilder
                .create()
                .alignment(Pos.CENTER_LEFT)
                .build();
 
        pane = new Pane();
 
        layout = VBoxBuilder
                .create()
                .alignment(Pos.CENTER)
                .padding(new Insets(10))
                .build();
 
        scene = SceneBuilder
                .create()
                .height(500)
                .width(500)
                .root(layout)
                .fill(Color.GRAY)
                .build();
 
        hello = TextBuilder
                .create()
                .text("Hello")
                .stroke(Color.ANTIQUEWHITE)
                .fill(Color.WHEAT)
                .font(Font.font("Ubuntu", 41))
                .effect(new Glow())
                .id("hello")
                .build();
 
        playFromDuration = TextFieldBuilder
                            .create()
                            .promptText("From")
                            .build();
 
        playFrom = ButtonBuilder
                   .create()
                   .text("Play From Durtation")
                   .build();
 
        playFromStart = ButtonBuilder
                        .create()
                        .text("Play From Start")
                        .build();
 
        stop = ButtonBuilder
                .create()
                .text("Stop")
                .build();
 
        startFrame = new KeyFrame(new Duration(0),
                                  new KeyValue(hello.xProperty(),-200));
 
        endFrame = new KeyFrame(new Duration(5 * 1000),
                   new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent arg0) {
                            hello.setFill(colors.get(rand.nextInt(colors.size())));
                        }
                    },
                  new KeyValue(hello.xProperty(),700));
 
        timeline = TimelineBuilder
                .create()
                .keyFrames(startFrame,endFrame)
                .autoReverse(true)
                .cycleCount(Timeline.INDEFINITE)
                .build();
 
        layout.getChildren().addAll(pane,buttonHolder);
        pane.getChildren().add(hello);
        buttonHolder.getChildren().addAll(playFromDuration,
                                          playFrom,
                                          playFromStart,
                                          stop);
 
        final Timeline tl = timeline;
        playFromStart.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                tl.playFromStart();
            }
        });
 
        stop.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                tl.stop();
            }
        });
 
        playFrom.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try{
                    int duration = Integer.parseInt(playFromDuration.getText());
                    tl.playFrom(new Duration(duration));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
 
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
//    public static void main(String[] args) {
//        Application.launch("blog.ControlTimelineAnimation");
//    }
}