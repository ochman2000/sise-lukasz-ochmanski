package pl.lodz.p.sise.algorithm;

import java.util.LinkedList;
import java.util.List;

import pl.lodz.p.sise.Heuristics;
import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.exception.TimeoutException;
import pl.lodz.p.sise.structure.Fringe;
import pl.lodz.p.sise.structure.Statistics;

public class Dijkstra {
	private static final int TIMEOUT = 120;
	public static boolean DEBUG = false;
	int iteracje = 0;
	private int maxSize=0;
	Puzzle a,b,c,d,e;
	private Puzzle puzzle;
	private Statistics statistics;

	public Dijkstra(int[] a) {
		try {
			this.puzzle = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
			System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		try {
			this.setStatistics(this.search(puzzle));
		} catch (NoSolutionException | TimeoutException e) {
			Statistics stats = new Statistics();
			stats.setSuccess(false);
			stats.setFailMessage(e.getMessage());
			stats.setStartPoint(puzzle);
			stats.setAlgorytm("Breadth First Search");
			stats.setHeurystyka("Każda krawędź ma wagę 1");
			stats.setIterations(iteracje);
			stats.setTime(TIMEOUT*1000);
			stats.setMaxMemoryUsed(maxSize);
			stats.setStructureType("LinkedList");
			stats.setMemoryUnits("Węzeł");
			this.setStatistics(stats);
			System.err.println(e.getMessage());
		}
	}
	
	public Statistics search(Puzzle puzzle) throws NoSolutionException, TimeoutException {
		Statistics stats = new Statistics();
		Fringe fringe = new Fringe();
		long start = System.currentTimeMillis();
		
		puzzle.setMinDistance(0);
		fringe.put(puzzle); 	//WSKAŻ MIEJSCE STARTU
		stats.setStartPoint(puzzle);
		while (!fringe.isEmpty()) {
			if (((System.currentTimeMillis() - start)/1000) > TIMEOUT)
				throw new TimeoutException(TIMEOUT);
			//ZNAJDŹ NAJLEPSZY ZNANY NAM WĘZEŁ (ZNAJDUJĄCY SIĘ NAJBLIŻEJ STARTU)
			Puzzle currentNode = fringe.getLowestCostPath(Heuristics.None);
			if (currentNode==null)
				throw new NoSolutionException();
			if (currentNode.isSolved()) {
				stats.setSuccess(true);
				stats.setAlgorytm("Shortest Path Dijkstra");
				stats.setHeurystyka("Każda krawędź ma wagę 1");
				stats.setIterations(iteracje);
				stats.setTime((System.currentTimeMillis() - start));
				stats.setMaxMemoryUsed(fringe.size());
				stats.setStructureType("HashMap");
				stats.setMemoryUnits("Węzeł");
				stats.setMoves(backTrack(fringe, currentNode));
				return stats;
			}
			//ZNAJDŹ ODLEGŁOŚĆ OD PUNKTU POCZĄTKOWEGO DO TEGO WĘZŁA
			int pokonanyDystans = currentNode.getMinDistance();
			int nowaOdległość = 1 + pokonanyDystans;
			//TERAZ ZNAJDŹ WSZYSTKICH SĄSIADÓW TEGO WĘZŁA
			List<Ruch> sąsiedzi = currentNode.getNeighboors();
			//NASTEPNIE PRZELICZ ODLEGŁOŚCI DLA KAŻDEGO SĄSIADA I DODAJ DO FRINGE'A
			for (Ruch kierunek : sąsiedzi) {
				Puzzle węzeł = currentNode.move(kierunek);
				//JEŚLI JESZCZE NIGDY NIE LICZYLIŚMY ODLEGŁOŚCI DLA TEGO WĘZŁA WSTAW NOWĄ ODLEGŁOŚĆ
				if (!fringe.containsKey(węzeł)) {
					węzeł.setMinDistance(nowaOdległość);
				}
				else {
					//SPRAWDŹ CZY NOWO OBLICZONA ODLEGŁOŚĆ NIE JEST LEPSZA OD ISTNIEJĄCEJ
					if (nowaOdległość < fringe.get(węzeł).getMinDistance()) {
						węzeł.setMinDistance(nowaOdległość);
					}
				}
				węzeł.setPrevious(currentNode);
				węzeł.setKierunek(kierunek);
				fringe.put(węzeł);
				iteracje++;
				maxSize=fringe.size();
			}
		}
		return stats;
	}

	private List<Ruch> backTrack(Fringe fringe, Puzzle currentNode) {
		LinkedList<Ruch> ruchy = new LinkedList<Ruch>();
//		LinkedList<Puzzle> path = new LinkedList<Puzzle>();
		Puzzle last = fringe.get(currentNode);
		while (last!=null) {
			Ruch kierunek = last.getKierunek();
			if (kierunek!=null) {
				ruchy.addFirst(kierunek);
//				path.addFirst(last);
			}
			last = last.getPrevious();
		}
		return ruchy;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
}
