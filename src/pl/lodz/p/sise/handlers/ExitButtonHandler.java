package pl.lodz.p.sise.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExitButtonHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.exit(0);
	}
}