package pl.lodz.p.sise;

import pl.lodz.p.sise.exceptions.DuplicatelPuzzleException;
import pl.lodz.p.sise.exceptions.IllegalPuzzleException;
import pl.lodz.p.sise.exceptions.PuzzleFormatException;

public class Solver {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		
	}
}
