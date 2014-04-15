package pl.lodz.p.sise.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.Visited;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

public class BFS {
	public static boolean DEBUG = true;
	private Ruch[] porządek = { Ruch.L, Ruch.P, Ruch.G, Ruch.D };
	private LinkedList<Puzzle> kolejka;
	private Set<Puzzle> visited;
	private Puzzle puzzle;

	public BFS() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		kolejka = new LinkedList<Puzzle>();
		kolejka.add(puzzle);
		visited = new Visited();
		visited.add(puzzle);
	}

	public List<Ruch> search() {
		Puzzle currentNode = puzzle.copy();
		ArrayList<Ruch> result = new ArrayList<Ruch>();
		int i = 0;
		long start = System.currentTimeMillis();
		while (!kolejka.isEmpty()) {
			if (DEBUG) {
				System.out.println("Iteracje: "+ i++ + "\t Kolejka: "+ kolejka.size()
				+ "\t Czas: "+ (System.currentTimeMillis() - start)/1000 + " sekund"
				+ "\n=========================================================");
				System.out.println(currentNode.getStringRepresentation());
			}
			if (currentNode.isSolved())
				return result;
			Puzzle przesunięcie0 = currentNode.move(porządek[0]);
			Puzzle przesunięcie1 = currentNode.move(porządek[1]);
			Puzzle przesunięcie2 = currentNode.move(porządek[2]);
			Puzzle przesunięcie3 = currentNode.move(porządek[3]);
			if (currentNode.isAllowed(porządek[0]) && !visited.contains(przesunięcie0)) {
				currentNode = currentNode.move(porządek[0]);
				kolejka.add(przesunięcie0);
				result.add(porządek[0]);
				visited.add(przesunięcie0);
			} else if (currentNode.isAllowed(porządek[1]) && !visited.contains(przesunięcie1)) {
				currentNode = currentNode.move(porządek[1]);
				kolejka.add(przesunięcie1);
				result.add(porządek[1]);
				visited.add(przesunięcie1);
			} else if (currentNode.isAllowed(porządek[2]) && !visited.contains(przesunięcie2)) {
				currentNode = currentNode.move(porządek[2]);
				kolejka.add(przesunięcie2);
				result.add(porządek[2]);
				visited.add(przesunięcie2);
			} else if (currentNode.isAllowed(porządek[3]) && !visited.contains(przesunięcie3)) {
				currentNode = currentNode.move(porządek[3]);
				kolejka.add(przesunięcie3);
				result.add(porządek[3]);
				visited.add(przesunięcie3);
			} else {
				currentNode = kolejka.remove();
				result.remove(result.size() - 1);
			}
		}
		return null;
	}
}
