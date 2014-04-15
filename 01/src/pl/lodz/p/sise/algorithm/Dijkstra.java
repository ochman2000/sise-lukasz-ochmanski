package pl.lodz.p.sise.algorithm;

import java.util.HashMap;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

public class Dijkstra {

	private Puzzle puzzle;
	private HashMap<String, Puzzle> graph;

	public Dijkstra() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		
//		graph =  		
	}
}