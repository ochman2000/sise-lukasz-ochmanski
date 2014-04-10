package pl.lodz.p.sise.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.Visited;
import pl.lodz.p.sise.exceptions.DuplicatelPuzzleException;
import pl.lodz.p.sise.exceptions.IllegalPuzzleException;
import pl.lodz.p.sise.exceptions.PuzzleFormatException;

public class DFS {

	private Ruch[] porządek = { Ruch.L, Ruch.P, Ruch.G, Ruch.D };
	private Stack<Puzzle> stos;
	private Set<Puzzle> visited;
	private Puzzle puzzle;

	public DFS() {
		int[] a = { 1, 0, 3, 4, 14, 2, 5, 7, 11, 9, 6, 8, 10, 13, 15, 12 };
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()
					+ "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		stos = new Stack<Puzzle>();
		stos.push(puzzle);
		visited = new Visited();
		visited.add(puzzle);
	}

	public List<Ruch> search() {
		ArrayList<Ruch> result = new ArrayList<Ruch>();
		while (!stos.empty()) {
			puzzle = stos.peek().copy();
			System.out.println(puzzle);
			if (puzzle.isSolved())
				return result;
			if (puzzle.move(porządek[0]) == true && !visited.contains(puzzle)) {
				stos.push(puzzle);
				result.add(porządek[0]);
				visited.add(puzzle);

			} else if (puzzle.move(porządek[1]) == true
					&& !visited.contains(puzzle)) {
				stos.push(puzzle);
				result.add(porządek[1]);
				visited.add(puzzle);
			} else if (puzzle.move(porządek[2]) == true
					&& !visited.contains(puzzle)) {
				stos.push(puzzle);
				result.add(porządek[2]);
				visited.add(puzzle);
			} else if (puzzle.move(porządek[3]) == true
					&& !visited.contains(puzzle)) {
				stos.push(puzzle);
				result.add(porządek[3]);
				visited.add(puzzle);
			} else {
				stos.pop();
			}
		}
		return result;
	}
}
