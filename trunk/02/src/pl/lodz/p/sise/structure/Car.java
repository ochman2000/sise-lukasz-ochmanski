package pl.lodz.p.sise.structure;

import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {

	public Car() {
		super(100, 50);
		this.setId("autko");
		this.setY(225);
	}

	public boolean equals(Object obj) {
		System.out.println("equals");
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		if (obj == this)
			return true;
		if ((((Car) obj).getId()).equals(this.getId()))
			return true;
		else
			return false;
	}
}
