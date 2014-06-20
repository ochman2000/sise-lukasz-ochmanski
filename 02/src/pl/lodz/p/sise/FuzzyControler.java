package pl.lodz.p.sise;

import pl.lodz.p.sise.structure.Parking;

public class FuzzyControler {

	public FuzzyControler() {
		Parking pane = Parking.getInstance();
		Animation animation = pane.getAnimation();
		
		animation.applyAnimation(pane);
	}
}
