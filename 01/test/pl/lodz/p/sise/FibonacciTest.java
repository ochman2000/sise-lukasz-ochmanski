package pl.lodz.p.sise;

import org.hamcrest.core.IsSame;

import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.structure.Fringe;
import pl.lodz.p.sise.structure.Statistics;

public class FibonacciTest {

	public static void main(String[] args) {
		Statistics s = new Statistics();
		System.out.println(s.isSuccess());
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 12, 13, 14, 11, 15 };
		
		Puzzle start = null;
		Puzzle second = null;
		try {
			start = new Puzzle(t_a);
			second = new Puzzle(t_a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Fringe p	 = new Fringe();
//		start.setMinDistance(0);
//		p.enqueue(start, Heuristics.None);
//		
//		if (!p.contains(second))
//			p.enqueue(second, 1.0);
//		else
//			System.out.println("Już tam jest.");

	}

}
