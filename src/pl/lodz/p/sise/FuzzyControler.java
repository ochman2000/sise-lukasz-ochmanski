package pl.lodz.p.sise;

import java.util.Random;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
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
		START_X = rnd.nextInt(500)+100;
		START_Y = rnd.nextInt(400);
		this.setX(START_X);
		this.setY(START_Y);
		
		path.getElements().add(new MoveTo(getX(), getY()));
//		path.getElements().add(new CubicCurveTo(60, 350, 160, 400, 310, 350));
//		path.getElements().add(new CubicCurveTo(310, 350, 460, 250, 
//						DESTINATION_X-150, DESTINATION_Y));
		while (!(getX()==DESTINATION_X-150 && getY()==DESTINATION_Y)) {
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
		fb.setVariable("odlegloscXodKoperty", DESTINATION_X-x);
		fb.setVariable("odlegloscYodKoperty", DESTINATION_Y-y);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("kierunek").defuzzify();
		fb.getVariable("przod").defuzzify();

		// Print ruleSet
		// System.out.println(fb);
		double kierunek = fb.getVariable("kierunek").getValue();
		System.out.println("Kierunek: "+kierunek);
		double przod = fb.getVariable("przod").getValue();
		
		PathElement path=null;
		if (kierunek<=-1 && przod==1.0) {
			path = new LineTo(getX()+10, getFunctionOf(getX()+10));
			setX(getX()+10);
			setY(getFunctionOf(getX()+10));
			System.out.print("x,y "+getX()+", "+getY());
			System.out.print(" Do przodu i ");
			System.out.println("skręt w prawo");
		}
		else if (kierunek>1 && przod==1.0) {
			path = new LineTo(getX()+10, getFunctionOf(getX()+10));
			setX(getX()+10);
			setY(getFunctionOf(getX()+10));
			System.out.print("x,y "+getX()+", "+getY());
			System.out.print(" Do przodu i ");
			System.out.println("skręt w lewo");
		}
		else if (przod!=1.0) {
			if (getY()<250) {				
//				path = new ArcTo(20, 20, 0.0, 100.0, 350.0, true, true);
//				path = new QuadCurveTo(getX()-100, getY(), 600, 400, 200, 250);
				path = new QuadCurveTo(400, 448, 200, 250);
			}
			else {
//				path = new ArcTo(20, 20, 0.0, 100.0, 150.0, true, false);
//				path = new CubicCurveTo(getX()-100, getY(), 200, 400, 200, 250);
				path = new QuadCurveTo(400, 48, 200, 250);
			}
			setX(200);
			setY(250);
			System.out.println("Cofnij się");
		}
		else {
			path = new LineTo(DESTINATION_X-150, DESTINATION_Y);
			setX(DESTINATION_X-150);
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
	
	private double getFunctionOf(double x) {
		double translatedX = x-(DESTINATION_X-150);
		
		double a = (DESTINATION_Y-START_Y)/(Math.pow(START_X-(DESTINATION_X-150), 2));
		System.out.println("a ="+a);
		double y = a*Math.pow((translatedX), 2)-DESTINATION_Y;
		return -y;
	}
}
