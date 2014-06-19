package pl.lodz.p.sise.structure;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class Car extends Rectangle {

	private Duration elapsed;
	
	public Car() {
		super(100, 50);
		this.setId("autko");
		this.setY(225);
	}
	
	public boolean equals(Object obj) {
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
	
	public Point2D getOffset(double x, double y) {
		Point2D nodeCoord = this.localToParent(this.getX(), this.getY());
		double offsetX = nodeCoord.getX() - x;
		double offsetY = nodeCoord.getY() - y;
		Point2D offset = new Point2D(offsetX, offsetY);
		return offset;
	}
	
	public void incrementElapsed(double d) {
		if (this.getElapsed()==null) {
			this.setElapsed(d);
		}
		else {
			this.setElapsed(this.getElapsed().add(Duration.seconds(d)).toSeconds());
		}
	}
	
	public void parkuj() {
		String filename = "fcl/driver.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		Point2D nodeCoord = this.localToParent(this.getX(), this.getY());
		double x = nodeCoord.getX();
		double y = nodeCoord.getY();
		
		fb.setVariable("odlegloscXodSciany", x);
		fb.setVariable("odlegloscYodSciany", y);
		fb.setVariable("odlegloscXodKoperty", 700-x);
		fb.setVariable("odlegloscYodKoperty", 225-y);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("kierunekX").defuzzify();
		fb.getVariable("kierunekY").defuzzify();

		// Print ruleSet
//		System.out.println(fb);
		double kierunekX = fb.getVariable("kierunekX").getValue();
		double kierunekY = fb.getVariable("kierunekY").getValue();
		
//		System.out.println("Kierunek w poziomie: " + fb.getVariable("kierunekX"));
		System.out.println(fb.getVariable("kierunekX").getValue());
//		System.out.println("Kierunek w pionie: " + fb.getVariable("kierunekY"));
		System.out.println(fb.getVariable("kierunekY").getValue());
		
		if (kierunekX>10 && kierunekX<14)
			kierunekX = 10* 3;
		else if (kierunekX>14)
			kierunekX = 20 *3;
		else
			kierunekX = 5 *3;
		
		if (kierunekY>10 && kierunekY<20)
			kierunekY = 10 *3;
		else if (kierunekY>20)
			kierunekY = 20 *3;
		else
			kierunekY = -30;
		System.out.println(kierunekX+", "+kierunekY);
		
//			this.move(kierunekX, kierunekY);
		this.relocate(kierunekY, kierunekY);
	}

	public Duration getElapsed() {
		return elapsed;
	}

	public void setElapsed(double sec) {
		this.elapsed = Duration.seconds(sec);
	}
}