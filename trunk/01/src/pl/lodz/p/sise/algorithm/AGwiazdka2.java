package pl.lodz.p.sise.algorithm;

import pl.lodz.p.sise.Heuristics;
import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.exception.TimeoutException;
import pl.lodz.p.sise.structure.Statistics;

public class AGwiazdka2 {
	private static final String STRUKTURA_DANYCH = "HashMap / FibonacciHeap";
	private static final String OPIS_HEURYSTYKI = "Odległość Hamminga";
	private static final String NAZWA_ALGORYTMU = "Shortest Path A*";
	private static final int TIMEOUT = 120;
	public static boolean DEBUG = false;
	private int iteracje = 0;
	private int maxSize=0;
	private Statistics stats;

	public AGwiazdka2(int[] a) {
		Puzzle puzzle = null;
		try {
			puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
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
			stats = dijkstra.search(puzzle, Heuristics.HammingDistance);
		} catch (NoSolutionException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Statistics getStatistics() {
		return this.stats;
	}
}