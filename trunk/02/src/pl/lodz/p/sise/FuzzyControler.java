package pl.lodz.p.sise;

import java.util.Random;

import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class FuzzyControler extends Animation {

	private static final int DESTINATION_X = 760;
	private static final int DESTINATION_Y = 248;
	private static int START_X;
	private static int START_Y;
	private double X;
	private double Y;

	public FuzzyControler() {
		super();
	}

	public Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		Random rnd = new Random();
		START_X = rnd.nextInt(500) + 150;
		START_Y = rnd.nextInt(400);
		this.setX(START_X);
		this.setY(START_Y);

		path.getElements().add(new MoveTo(getX(), getY()));
		while (!(getX() == DESTINATION_X - 150 && getY() == DESTINATION_Y)) {
			path.getElements().add(getDirection());
		}
		path.getElements().add(new LineTo(DESTINATION_X, DESTINATION_Y));

		path.setOpacity(0.0);
		return path;
	}

	public PathElement getDirection() {
		String filename = "fcl/driver.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		double x = getX();
		double y = getY();

		fb.setVariable("odlegloscXodSciany", x);
		fb.setVariable("odlegloscYodSciany", y);
		fb.setVariable("odlegloscXodKoperty", DESTINATION_X - x);
		fb.setVariable("odlegloscYodKoperty", DESTINATION_Y - y);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("kierunek").defuzzify();
		fb.getVariable("przod").defuzzify();

		// Print ruleSet
		double kierunek = fb.getVariable("kierunek").getValue();
		System.out.println("Kierunek: " + kierunek);
		double przod = fb.getVariable("przod").getValue();

		PathElement path = null;
		if (kierunek <= -1 && przod == 1.0) {
			double radius = Math.abs(DESTINATION_Y - getY());
			if (radius < 30)
				radius = 30;
			double xEnd = getX() + radius;
			double yEnd = getY() - radius;
			if (xEnd > DESTINATION_X - 150) {
				xEnd = DESTINATION_X - 150;
				yEnd = getY() - (xEnd - getX());
			}
			path = new ArcTo(radius, radius, 0.0, xEnd, yEnd, false, true);
			setX(xEnd);
			setY(yEnd);
			System.out.print("x,y " + String.format("%.2f", getX()) + ", "
					+ String.format("%.2f", getY()));
			System.out.print(" Do przodu i ");
			System.out.println("skręt w prawo");
		} else if (kierunek > 1 && przod == 1.0) {
			double radius = Math.abs(DESTINATION_Y - getY());
			if (radius < 30)
				radius = 30;
			double xEnd = getX() + radius;
			double yEnd = getY() + radius;
			if (xEnd > DESTINATION_X - 150) {
				xEnd = DESTINATION_X - 150;
				yEnd = getY() + (xEnd - getX());
			}
			path = new ArcTo(radius, radius, 0.0, xEnd, yEnd, false, false);
			setX(xEnd);
			setY(yEnd);
			System.out.print("x,y " + String.format("%.2f", getX()) + ", "
					+ String.format("%.2f", getY()));
			System.out.print(" Do przodu i ");
			System.out.println("skręt w lewo");
		} else if (przod != 1.0) {
			if (getY() < 250) {
				path = new CubicCurveTo(400, DESTINATION_Y + 400, 100,
						DESTINATION_Y, 400, DESTINATION_Y);
			} else {
				path = new CubicCurveTo(400, DESTINATION_Y - 400, 100,
						DESTINATION_Y, 400, DESTINATION_Y);
			}
			setX(200);
			setY(250);
			System.out.println("Cofnij się");
		} else {
			path = new LineTo(DESTINATION_X - 150, DESTINATION_Y);
			setX(DESTINATION_X - 150);
			setY(DESTINATION_Y);
			System.out.println("Prosto");
		}
		return path;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		this.X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		this.Y = y;
	}
}
