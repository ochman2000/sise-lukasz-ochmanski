package pl.lodz.p.sise.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pl.lodz.p.sise.Animation;
import pl.lodz.p.sise.structure.Parking;

public class RestartButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Parking pane = Parking.getInstance();
		Animation animation = pane.getAnimation();
		//this line of code actually removes the object "pojazd" from the pane.
		//Therefore it is different from animation.play();
		//animation.play() simply repeats the transition from time 0.0;
		animation.applyAnimation(pane);
	}
}