package pl.lodz.p.sise;

import java.util.Random;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import javafx.geometry.Point2D;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;

public class FuzzyControler extends Animation {

	private static final int DESTINATION_X = 760;
	private static final int DESTINATION_Y = 248;
	private double X;
	private double Y;

	public FuzzyControler() {
		super();
	}

	public Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		Random rnd = new Random();
		this.setX(rnd.nextInt(600));
		this.setY(rnd.nextInt(600));
		
		path.getElements().add(new MoveTo(getX(), getY()));
		path.getElements().add(new CubicCurveTo(60, 350, 160, 400, 310, 350));
		path.getElements().add(new CubicCurveTo(310, 350, 460, 250, 
						DESTINATION_X-150, DESTINATION_Y));
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
		// System.out.println(fb);
		double kierunek = fb.getVariable("kierunek").getValue();
		double przod = fb.getVariable("przod").getValue();
		
		PathElement path=null;
		if (kierunek<=-1) {
			path = new CubicCurveTo(getX(), getY(), getX()+100, getY()+100, getX()+50, getY()+50);
			setX(getX()+50);
			setY(getY()+50);
		}
		else if (kierunek>1) {
			path = new CubicCurveTo(getX(), getY(), getX()-100, getY()-100, getX()-50, getY()-50);
			setX(getX()-50);
			setY(getY()-50);
		}
		else {
			path = new LineTo(DESTINATION_X, DESTINATION_Y);
			setX(DESTINATION_X);
			setY(DESTINATION_Y);
		}
		return path;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

//	public void parkuj() {
//		String filename = "fcl/driver.fcl";
//		FIS fis = FIS.load(filename, true);
//
//		if (fis == null) {
//			System.err.println("Can't load file: '" + filename + "'");
//			System.exit(1);
//		}
//
//		// Get default function block
//		FunctionBlock fb = fis.getFunctionBlock(null);
//
//		// Set inputs
//		Point2D nodeCoord = this.localToParent(this.getX(), this.getY());
//		double x = nodeCoord.getX();
//		double y = nodeCoord.getY();
//
//		fb.setVariable("odlegloscXodSciany", x);
//		fb.setVariable("odlegloscYodSciany", y);
//		fb.setVariable("odlegloscXodKoperty", 700 - x);
//		fb.setVariable("odlegloscYodKoperty", 225 - y);
//
//		// Evaluate
//		fb.evaluate();
//
//		// Show output variable's chart
//		fb.getVariable("kierunekX").defuzzify();
//		fb.getVariable("kierunekY").defuzzify();
//
//		// Print ruleSet
//		// System.out.println(fb);
//		double kierunekX = fb.getVariable("kierunekX").getValue();
//		double kierunekY = fb.getVariable("kierunekY").getValue();
//
//		// System.out.println("Kierunek w poziomie: " +
//		// fb.getVariable("kierunekX"));
//		System.out.println(fb.getVariable("kierunekX").getValue());
//		// System.out.println("Kierunek w pionie: " +
//		// fb.getVariable("kierunekY"));
//		System.out.println(fb.getVariable("kierunekY").getValue());
//
//		if (kierunekX > 10 && kierunekX < 14)
//			kierunekX = 10 * 3;
//		else if (kierunekX > 14)
//			kierunekX = 20 * 3;
//		else
//			kierunekX = 5 * 3;
//
//		if (kierunekY > 10 && kierunekY < 20)
//			kierunekY = 10 * 3;
//		else if (kierunekY > 20)
//			kierunekY = 20 * 3;
//		else
//			kierunekY = -30;
//		System.out.println(kierunekX + ", " + kierunekY);
//
//	}
}
