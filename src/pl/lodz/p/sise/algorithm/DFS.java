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
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.exception.TimeoutException;
import pl.lodz.p.sise.structure.Statistics;

public class DFS {

	private static final int TIMEOUT = 30;
	public static boolean DEBUG = false;
	private int maxSize=0;
	private int iteracje = 0;
	private Ruch[] porządek;
	private Stack<Puzzle> stos;
	private Set<Puzzle> visited;
	private Puzzle puzzle;
	private Statistics statistics;

	public DFS(int[] a) {
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		porządek = Ruch.values();
		stos = new Stack<Puzzle>();
		stos.push(puzzle);
		visited = new HashSet<Puzzle>();
		visited.add(puzzle);
		try {
			this.setStatistics(this.search(puzzle));
		} catch (TimeoutException | NoSolutionException e) {
			Statistics stats = new Statistics();
			stats.setSuccess(false);
			stats.setFailMessage(e.getMessage());
			stats.setStartPoint(puzzle);
			stats.setAlgorytm("Depth First Search");
			stats.setIterations(iteracje);
			stats.setTime(TIMEOUT*1000);
			stats.setMaxMemoryUsed(maxSize);
			stats.setStructureType("Stack and HashSet");
			stats.setMemoryUnits("Węzeł");
			this.setStatistics(stats);
			System.err.println(e.getMessage());
		}
	}

	public Statistics search(Puzzle puzzle) throws TimeoutException, NoSolutionException {
		Statistics stats = new Statistics();
		stats.setStartPoint(puzzle);
		List<Ruch> result = new ArrayList<Ruch>();
		long start = System.currentTimeMillis();
		while (!stos.empty()) {
			if (((System.currentTimeMillis() - start)/1000) > TIMEOUT)
				throw new TimeoutException(TIMEOUT);
			puzzle = stos.peek().copy();
			if (DEBUG) {
				System.out.println("Iteracje: "+ iteracje + "\t Stos: "+ stos.size()
				+ "\t Czas: "+ (System.currentTimeMillis() - start)/1000 + " sekund"
				+ "\n=========================================================");
				System.out.println(puzzle.getStringRepresentation()+"\n");
			}
			if (puzzle.isSolved()) {
				stats.setAlgorytm("Depth First Search");
				stats.setIterations(iteracje);
				stats.setTime((System.currentTimeMillis() - start));
				stats.setMaxMemoryUsed(maxSize);
				stats.setStructureType("Stack and HashSet");
				stats.setMemoryUnits("Węzeł");
				stats.setMoves(result);
				return stats;
			}
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
			iteracje++;
			if (visited.size()>maxSize)
				maxSize=visited.size();
		}
		throw new NoSolutionException();
	}
	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
}
