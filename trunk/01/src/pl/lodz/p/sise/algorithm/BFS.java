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
	private static final int TIMEOUT = 30;
	public static boolean DEBUG = false;
	int maxSize=0;
	int iteracje = 0;
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
		visited = new HashSet<Puzzle>();
		try {
			this.setStatistics(search(puzzle));
		} catch (TimeoutException | NoSolutionException e) {
			Statistics stats = new Statistics();
			stats.setSuccess(false);
			stats.setFailMessage(e.getMessage());
			stats.setStartPoint(puzzle);
			stats.setAlgorytm("Breadth First Search");
			stats.setIterations(iteracje);
			stats.setTime(TIMEOUT*1000);
			stats.setMaxMemoryUsed(maxSize);
			stats.setStructureType("LinkedList");
			stats.setMemoryUnits("Węzeł");
			this.setStatistics(stats);
//			System.err.println(e.getMessage());
		}
	}

	public Statistics search(Puzzle puzzle) throws TimeoutException, NoSolutionException {
		List<Puzzle> result = new LinkedList<Puzzle>();
		Statistics stats = new Statistics();
		stats.setStartPoint(puzzle);
		kolejka.add(puzzle);
		visited.add(puzzle);
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
			Puzzle przesunięcie0 = currentNode.move(porządek[0]);
			if (currentNode.isAllowed(porządek[0]) && !visited.contains(przesunięcie0)) {
				przesunięcie0.setPrevious(currentNode);
				przesunięcie0.setKierunek(porządek[0]);
				kolejka.add(przesunięcie0);
				result.add(przesunięcie0);
				visited.add(przesunięcie0);
				iteracje++;
				if (przesunięcie0.isSolved()) {
					stats.setAlgorytm("Breadth First Search");
					stats.setIterations(iteracje);
					stats.setTime((System.currentTimeMillis() - start));
					stats.setMaxMemoryUsed(maxSize);
					stats.setStructureType("LinkedList");
					stats.setMemoryUnits("Węzeł");
					stats.setMoves(backTrack(result));
					return stats;
				}
			}
			Puzzle przesunięcie1 = currentNode.move(porządek[1]);
			if (currentNode.isAllowed(porządek[1]) && !visited.contains(przesunięcie1)) {
				przesunięcie1.setPrevious(currentNode);
				przesunięcie1.setKierunek(porządek[1]);
				kolejka.add(przesunięcie1);
				result.add(przesunięcie1);
				visited.add(przesunięcie1);
				iteracje++;
				if (przesunięcie1.isSolved()) {
					stats.setAlgorytm("Breadth First Search");
					stats.setIterations(iteracje);
					stats.setTime((System.currentTimeMillis() - start));
					stats.setMaxMemoryUsed(maxSize);
					stats.setStructureType("LinkedList");
					stats.setMemoryUnits("Węzeł");
					stats.setMoves(backTrack(result));
					return stats;
				}
			}

			Puzzle przesunięcie2 = currentNode.move(porządek[2]);
			if (currentNode.isAllowed(porządek[2]) && !visited.contains(przesunięcie2)) {
				przesunięcie2.setPrevious(currentNode);
				przesunięcie2.setKierunek(porządek[2]);
				kolejka.add(przesunięcie2);
				result.add(przesunięcie2);
				visited.add(przesunięcie2);
				iteracje++;
				if (przesunięcie2.isSolved()) {
					stats.setAlgorytm("Breadth First Search");
					stats.setIterations(iteracje);
					stats.setTime((System.currentTimeMillis() - start));
					stats.setMaxMemoryUsed(maxSize);
					stats.setStructureType("LinkedList");
					stats.setMemoryUnits("Węzeł");
					stats.setMoves(backTrack(result));
					return stats;
				}
			}
			Puzzle przesunięcie3 = currentNode.move(porządek[3]);
			if (currentNode.isAllowed(porządek[3]) && !visited.contains(przesunięcie3)) {
				przesunięcie3.setPrevious(currentNode);
				przesunięcie3.setKierunek(porządek[3]);
				kolejka.add(przesunięcie3);
				result.add(przesunięcie3);
				visited.add(przesunięcie3);
				iteracje++;
				if (przesunięcie3.isSolved()) {
					stats.setAlgorytm("Breadth First Search");
					stats.setIterations(iteracje);
					stats.setTime((System.currentTimeMillis() - start));
					stats.setMaxMemoryUsed(maxSize);
					stats.setStructureType("LinkedList");
					stats.setMemoryUnits("Węzeł");
					stats.setMoves(backTrack(result));
					return stats;
				}
			}
			if (result.size()>maxSize)
				maxSize=result.size();
		}
		throw new NoSolutionException();
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	private List<Ruch> backTrack(List<Puzzle> result) {
		LinkedList<Ruch> ruchy = new LinkedList<Ruch>();
		Puzzle last = result.get(result.size()-1);
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
