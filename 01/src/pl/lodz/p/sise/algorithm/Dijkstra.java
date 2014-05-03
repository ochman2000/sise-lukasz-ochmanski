package pl.lodz.p.sise.algorithm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.structure.Fringe;
import pl.lodz.p.sise.structure.Statistics;

public class Dijkstra {
	@SuppressWarnings("unused")
	private String STRUKTURA_DANYCH = "HashMap / PriorityQueue";
	@SuppressWarnings("unused")
	private String OPIS_HEURYSTYKI = "Każda krawędź ma wagę 1";
	@SuppressWarnings("unused")
	private String NAZWA_ALGORYTMU = "Shortest Path Dijkstra";
	private static final int TIMEOUT = 120;
	public static boolean DEBUG = false;
	private int iteracje = 0;
	private int maxSize=0;
	private Statistics statistics;

	public Dijkstra() {
	}
	
	public Statistics search(Puzzle puzzle, Comparator<Puzzle> arg1)
			throws NoSolutionException {
		
		Fringe fringe = new Fringe(arg1);
		long start = System.currentTimeMillis();

		puzzle.setMinDistance(0);
		fringe.enqueue(puzzle);
		// WSKAŻ MIEJSCE STARTU
		getStatistics().setStartPoint(puzzle);
		while (!fringe.isEmpty()) {
			if (((System.currentTimeMillis() - start) / 1000) > TIMEOUT) {
				getStatistics().setSuccess(false);
				getStatistics().setFailMessage("Przekroczony dozwolony czas dokonywania obliczeń: "+TIMEOUT+" sekund");
				getStatistics().setIterations(iteracje);
				getStatistics().setTime(TIMEOUT*1000);
				getStatistics().setMaxMemoryUsed(maxSize);
				return getStatistics();
			}
			// ZNAJDŹ NAJLEPSZY ZNANY NAM WĘZEŁ (ZNAJDUJĄCY SIĘ NAJBLIŻEJ STARTU)
			Puzzle currentNode = fringe.getLowestCostPath();
			if (currentNode == null)
				throw new NoSolutionException();
			// ZNAJDŹ ODLEGŁOŚĆ OD PUNKTU POCZĄTKOWEGO DO TEGO WĘZŁA
			int pokonanyDystans = currentNode.getMinDistance();
			int nowaOdległość = 1 + pokonanyDystans;
			// TERAZ ZNAJDŹ WSZYSTKICH SĄSIADÓW TEGO WĘZŁA
			List<Ruch> sąsiedzi = currentNode.getNeighboors();
			// NASTEPNIE PRZELICZ ODLEGŁOŚCI DLA KAŻDEGO SĄSIADA I DODAJ DO FRINGE'A
			for (Ruch kierunek : sąsiedzi) {
				Puzzle sąsiad = currentNode.move(kierunek);
				sąsiad.setPrevious(currentNode);
				sąsiad.setKierunek(kierunek);
				sąsiad.setMinDistance(nowaOdległość);
				if (sąsiad.isSolved()) {
					getStatistics().setSuccess(true);
					getStatistics().setIterations(iteracje);
					getStatistics().setTime((System.currentTimeMillis() - start));
					getStatistics().setMaxMemoryUsed(fringe.size());
					getStatistics().setMoves(backTrack(sąsiad));
					return getStatistics();
				}
				if (!fringe.wasSettled(sąsiad)) {
					// JEŚLI JESZCZE NIGDY NIE LICZYLIŚMY ODLEGŁOŚCI DLA TEGO
					// WĘZŁA WSTAW/UAKTUALNIJ NOWĄ ODLEGŁOŚĆ
					fringe.enqueue(sąsiad);
				}
				iteracje++;
				maxSize = fringe.size();
			}
		}
		getStatistics().setSuccess(false);
		getStatistics().setIterations(iteracje);
		getStatistics().setTime((System.currentTimeMillis() - start));
		getStatistics().setMaxMemoryUsed(fringe.size());
		getStatistics().setFailMessage("Przeprocesowano wszystkie węzły.");
		return getStatistics();
	}

	private List<Ruch> backTrack(Puzzle currentNode) {
		LinkedList<Ruch> ruchy = new LinkedList<Ruch>();
		Puzzle last = currentNode;
		while (last!=null) {
			Ruch kierunek = last.getKierunek();
			if (kierunek!=null) {
				ruchy.addFirst(kierunek);
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
