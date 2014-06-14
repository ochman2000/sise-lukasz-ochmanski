package pl.lodz.p.sise;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class DrivingClass {
	public static void main(String[] args) throws Exception {
		String filename = "fcl/driver.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		fb.setVariable("food", 8.5);
		fb.setVariable("service", 7.5);

		// Evaluate
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("zaparkowany").defuzzify();

		// Print ruleSet
//		System.out.println(fb);
		System.out.println("Samochód zaparkowany: " + fb.getVariable("zaparkowany").getName());
		System.out.println(fb.getVariable("zaparkowany").getValue());

	}
}