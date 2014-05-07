package pl.lodz.p.sise.algorithm;

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
	int maxSize=0;
	int iteracje = 0;
	private Statistics statistics;
	private List<Puzzle> kolejka;
	private Puzzle puzzle;

	public BFS(int[] a) {
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		kolejka = new LinkedList<Puzzle>();
		Statistics stats = new Statistics();
		try {
			this.setStatistics(search(puzzle));
		} catch (TimeoutException | NoSolutionException e) {
			stats.setSuccess(false);
			stats.setFailMessage(e.getMessage());
			stats.setStartPoint(puzzle);
			stats.setAlgorytm("Breadth First Search");
			stats.setIterations(iteracje);
			stats.setTime(TIMEOUT*1000);
			stats.setMaxMemoryUsed(maxSize);
			stats.setStructureType("LinkedList and HashSet");
			stats.setMemoryUnits("Węzeł");
			this.setStatistics(stats);
//			System.err.println(e.getMessage());
		}
	}

	public Statistics search(Puzzle puzzle) throws TimeoutException, NoSolutionException {
		Set<Puzzle> result = new HashSet<Puzzle>();
		Statistics stats = new Statistics();
		stats.setStartPoint(puzzle);
		kolejka.add(puzzle);
		result.add(puzzle);
		long start = System.currentTimeMillis();
		while (!kolejka.isEmpty()) {
			Puzzle currentNode = kolejka.remove(0);
			if (((System.currentTimeMillis() - start)/1000) > TIMEOUT)
				throw new TimeoutException(TIMEOUT);
			if (DEBUG) {
				System.out.println("Iteracje: "+ iteracje + "\t Kolejka: "+ kolejka.size()
				+ "\t Czas: "+ (System.currentTimeMillis() - start)/1000 + " sekund"
				+ "\n=========================================================");
				System.out.println(currentNode.getStringRepresentation()+"\n");
			}
			for (Ruch kierunek : Ruch.values()) {
				Puzzle przesunięcie0 = currentNode.move(kierunek);
				if (currentNode.isAllowed(kierunek) && !result.contains(przesunięcie0)) {
					przesunięcie0.setPrevious(currentNode);
					przesunięcie0.setKierunek(kierunek);
					kolejka.add(przesunięcie0);
					result.add(przesunięcie0);
					iteracje++;
					if (result.size()>maxSize)
						maxSize=result.size();
					if (przesunięcie0.isSolved()) {
						stats.setAlgorytm("Breadth First Search");
						stats.setSuccess(true);
						stats.setIterations(iteracje);
						stats.setTime((System.currentTimeMillis() - start));
						stats.setMaxMemoryUsed(maxSize);
						stats.setStructureType("LinkedList and HashSet");
						stats.setMemoryUnits("Węzeł");
						stats.setMoves(backTrack(result, przesunięcie0));
						return stats;
					}
				}
			}			
		}
		throw new NoSolutionException();
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	private List<Ruch> backTrack(Set<Puzzle> result, Puzzle last) {
		LinkedList<Ruch> ruchy = new LinkedList<Ruch>();
		while (last!=null) {
			Ruch kierunek = last.getKierunek();
			if (kierunek!=null) {
				ruchy.addFirst(kierunek);
			}
			last = last.getPrevious();
		}
		return ruchy;
	}
}
