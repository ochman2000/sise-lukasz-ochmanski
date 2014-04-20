package pl.lodz.p.sise.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.exception.TimeoutException;
import pl.lodz.p.sise.structure.Statistics;

public class BFS {
	private static final int TIMEOUT = 120;
	public static boolean DEBUG = false;
	private Statistics statistics;
	private Ruch[] porządek;
	private List<Puzzle> kolejka;
	private Set<Puzzle> visited;
	private Puzzle puzzle;

	public BFS(int[] a) {
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		porządek = Ruch.values();
		kolejka = new LinkedList<Puzzle>();
		kolejka.add(puzzle);
		visited = new HashSet<Puzzle>();
		visited.add(puzzle);
		try {
			this.setStatistics(search(puzzle));
		} catch (TimeoutException | NoSolutionException e) {
			System.err.println(e.getMessage());
		}
	}

	public Statistics search(Puzzle puzzle) throws TimeoutException, NoSolutionException {
		Statistics stats = new Statistics();
		stats.setStartPoint(puzzle);
		int maxSize=0;
		Puzzle currentNode = puzzle.copy();
		List<Ruch> result = new ArrayList<Ruch>();
		int i = 0;
		long start = System.currentTimeMillis();
		while (!kolejka.isEmpty()) {
			if (((System.currentTimeMillis() - start)/1000) > TIMEOUT)
				throw new TimeoutException(TIMEOUT);
			if (DEBUG) {
				System.out.println("Iteracje: "+ i + "\t Kolejka: "+ kolejka.size()
				+ "\t Czas: "+ (System.currentTimeMillis() - start)/1000 + " sekund"
				+ "\n=========================================================");
				System.out.println(currentNode.getStringRepresentation()+"\n");
			}
			if (currentNode.isSolved()) {
				stats.setAlgorytm("Breadth First Search");
//				stats.setHeurystyka("Brak");
				stats.setIterations(i);
				stats.setTime((System.currentTimeMillis() - start));
				stats.setMaxMemoryUsed(maxSize);
				stats.setStructureType("LinkedList");
				stats.setMemoryUnits("Węzeł");
				stats.setMoves(result);
				return stats;
			}
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
				currentNode = kolejka.remove(0);
				result.remove(result.size() - 1);
			}
			i++;
			if (kolejka.size()>maxSize)
				maxSize=kolejka.size();
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
