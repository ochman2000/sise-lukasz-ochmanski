package pl.lodz.p.sise.handlers;

import pl.lodz.p.sise.Animation;
import pl.lodz.p.sise.structure.Parking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Parking pane = Parking.getInstance();
		Animation animation = pane.getAnimation();
		animation.getTransition().play();
	}
}
