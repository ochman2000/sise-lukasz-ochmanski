package pl.lodz.p.sise.algorithm;

import java.util.Comparator;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.structure.Statistics;

public class AGwiazdka1 {
	private static final String STRUKTURA_DANYCH = "HashMap / FibonacciHeap";
	private static final String OPIS_HEURYSTYKI = "Odległość taksówkowa";
	private static final String NAZWA_ALGORYTMU = "Shortest Path A*";
	public static boolean DEBUG = false;
	private Statistics stats;

	public AGwiazdka1(int[] a) {
		Puzzle puzzle = null;
		try {
			puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()
					+ "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		Dijkstra dijkstra = new Dijkstra();
		stats = new Statistics();
		stats.setStartPoint(puzzle);
		stats.setAlgorytm(NAZWA_ALGORYTMU);
		stats.setHeurystyka(OPIS_HEURYSTYKI);
		stats.setStructureType(STRUKTURA_DANYCH);
		stats.setMemoryUnits("Węzeł");
		dijkstra.setStatistics(stats);
		try {
			stats = dijkstra.search(puzzle, new PuzzleComparator1());
		} catch (NoSolutionException e) {
			System.err.println(e.getMessage());
		}
	}

	public Statistics getStatistics() {
		return this.stats;
	}

	private class PuzzleComparator1 implements Comparator<Puzzle> {

		@Override
		public int compare(Puzzle o1, Puzzle o2) {
			if (o1.getMinDistance() + o1.getManhattanDistance() < o2
					.getMinDistance() + o2.getManhattanDistance()) {
				return -1;
			} else if (o1.getMinDistance() + o1.getManhattanDistance() > o2
					.getMinDistance() + o2.getManhattanDistance()) {
				return 1;
			} else
				return 0;
		}
	}
}