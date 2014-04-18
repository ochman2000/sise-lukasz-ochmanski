package pl.lodz.p.sise.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

public class DFS {

	public static boolean DEBUG = true;
	private Ruch[] porządek = { Ruch.L, Ruch.P, Ruch.G, Ruch.D };
	private Stack<Puzzle> stos;
	private Set<Puzzle> visited;
	private Puzzle puzzle;

	public DFS() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		stos = new Stack<Puzzle>();
		stos.push(puzzle);
		visited = new HashSet<Puzzle>();
		visited.add(puzzle);
	}

	public List<Ruch> search() {
		ArrayList<Ruch> result = new ArrayList<Ruch>();
		int i = 0;
		long start = System.currentTimeMillis();
		while (!stos.empty()) {
			puzzle = stos.peek().copy();
			if (DEBUG) {
				System.out.println("Iteracje: "+ i++ + "\t Stos: "+ stos.size()
				+ "\t Czas: "+ (System.currentTimeMillis() - start)/1000 + " sekund"
				+ "\n=========================================================");
				System.out.println(puzzle.getStringRepresentation());
			}
			if (puzzle.isSolved())
				return result;
			Puzzle przesunięcie0 = puzzle.move(porządek[0]);
			Puzzle przesunięcie1 = puzzle.move(porządek[1]);
			Puzzle przesunięcie2 = puzzle.move(porządek[2]);
			Puzzle przesunięcie3 = puzzle.move(porządek[3]);
			if (puzzle.isAllowed(porządek[0]) && !visited.contains(przesunięcie0)) {
				stos.push(przesunięcie0);
				result.add(porządek[0]);
				visited.add(przesunięcie0);
			} else if (puzzle.isAllowed(porządek[1]) && !visited.contains(przesunięcie1)) {
				stos.push(przesunięcie1);
				result.add(porządek[1]);
				visited.add(przesunięcie1);
			} else if (puzzle.isAllowed(porządek[2]) && !visited.contains(przesunięcie2)) {
				stos.push(przesunięcie2);
				result.add(porządek[2]);
				visited.add(przesunięcie2);
			} else if (puzzle.isAllowed(porządek[3]) && !visited.contains(przesunięcie3)) {
				stos.push(przesunięcie3);
				result.add(porządek[3]);
				visited.add(przesunięcie3);
			} else {
				stos.pop();
				result.remove(result.size() - 1);
			}
		}
		return null;
	}
}
