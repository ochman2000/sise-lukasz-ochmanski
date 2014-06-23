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
	private double X;
	private double Y;

	public FuzzyControler() {
		super();
	}

	public Path generateCurvyPath(final double pathOpacity) {
		final Path path = new Path();
		Random rnd = new Random();
		this.setX(rnd.nextInt(500)+100);
		this.setY(rnd.nextInt(400));
		
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
		fb.setVariable("odlegloscXodKoperty", x-DESTINATION_X);
		fb.setVariable("odlegloscYodKoperty", y-DESTINATION_Y);

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
			path = new LineTo(getX()+1, getY()-kierunek);
			setX(getX()+1);
			setY(getY()-kierunek);
			System.out.print("Do przodu i ");
			System.out.println("skręt w lewo");
		}
		else if (kierunek>1 && przod==1.0) {
			path = new LineTo(getX()+1, getY()+kierunek);
			setX(getX()+1);
			setY(getY()+kierunek);
			System.out.print("Do przodu i ");
			System.out.println("skręt w prawo");
		}
		else if (przod!=1.0) {
			if (getY()<250) {				
//				path = new ArcTo(20, 20, 0.0, 100.0, 350.0, true, true);
//				path = new QuadCurveTo(getX()-100, getY(), 600, 400, 200, 250);
				path = new QuadCurveTo(400, 600, 200, 250);
			}
			else {
//				path = new ArcTo(20, 20, 0.0, 100.0, 150.0, true, false);
//				path = new CubicCurveTo(getX()-100, getY(), 200, 400, 200, 250);
				path = new QuadCurveTo(400, 200, 200, 250);
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
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}
}
