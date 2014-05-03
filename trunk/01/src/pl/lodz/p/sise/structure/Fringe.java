package pl.lodz.p.sise.structure;

import java.util.HashMap;
import java.util.Map;

import pl.lodz.p.sise.Heuristics;
import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

/**
 * Tak klasa dziedziczy po HashMapie, choć tak naprawdę powinno tu być
 * Fibbonacci Heap, żeby można natychmiast znajdywać najmniejszą wartość.
 * @author Lukasz
 *
 */
public class Fringe extends FibonacciHeap<Puzzle> {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4814714233235085597L;
	private Map<Puzzle, Puzzle> settled;
	private Map<Puzzle, Puzzle> unsettled;
	
	public Fringe() {
		settled = new HashMap<Puzzle, Puzzle>();
		unsettled = new HashMap<Puzzle, Puzzle>();
	}

	/**
	 * Funkcja zwraca węzeł, o najmniejszej wartości, który nie był jeszcze badany.
	 * Aby sprawić, żeby algorytm był deterministyczny, muszę zdecydować co robić w przypadku,
	 * gdy pojawią się dwa tak samo odległe wierzchołki. Jeśli jednak iterator pokonuje
	 * strukturę danych w ustalony sposób, powinno działać. Poza tym, nie będę tego teraz zmieniał,
	 * bo za chwile może wrzucę tu Fibbonacci Heap i mój wysiłek pójdzie na marne.
	 * @return
	 */
	public Puzzle getLowestCostPath(Heuristics heurystyka) {
		if (super.isEmpty()) {
			System.out.println("stop");
			int[] t_a = { 5, 3, 0, 8, 2, 6, 4, 7, 9, 10, 1, 12, 13, 14, 11, 15 };
			Puzzle puzzle = null;
			try {
				puzzle = new Puzzle(t_a);
			} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException e) {
				System.err.println(e.getMessage() + "\nDziałanie programu przerwane.");
				System.exit(1);
			}
			unsettled.remove(puzzle);
			settled.put(puzzle, puzzle);
			return puzzle;
		}
		Entry<Puzzle> ret = this.dequeueMin();
		unsettled.remove(ret.getValue());
		settled.put(ret.getValue(), ret.getValue());
		return ret.getValue();
	}
	
	
	/**
	 * Wstawia nowy element.
	 * @param a - obecnie przeszukiwany węzeł
	 * @param b - dotychczas uzyskana najkrótsza droga do a
	 * @param c - węzeł, przez który trzeba było przejść, aby dostać się do a.
	 * @param d - ruch, jaki doprowadził do tego węzła
	 * <br/>
	 * Na przykład: <br/>
	 * fringe.put(b, 1, a, d);<br/>
	 * Najkrótsza ścieżka do b przechodzi przez a i wynosi 1.
	 * Ostatnio wykonano ruch d.
	 */
	public void enqueue(Puzzle a, Heuristics h) {
		if (a==null)
			throw new NullPointerException("Próbujesz wstawić pustą układankę.");
		int priority = a.getMinDistance();
		switch (h) {
		case ManhattanDistance:
			priority += a.getManhattanDistance();
			break;
		case HammingDistance:
			priority += a.getHammingDistance();
			break;
		case SumOfManhattanDistances:
			priority += a.getTotalManhattanDistances();
			break;
		default:
			break;
		}
		this.enqueue(a, priority);
		unsettled.put(a, a);
	}
	
	public void decreaseKey(Puzzle a, Heuristics h) {
		if (a==null)
			throw new NullPointerException("Próbujesz wstawić pustą układankę.");
		int newPriority = a.getMinDistance();
		int oldPriority = unsettled.get(a).getMinDistance();
		switch (h) {
		case ManhattanDistance:
			newPriority += a.getManhattanDistance();
			oldPriority += a.getManhattanDistance();
			break;
		case HammingDistance:
			newPriority += a.getHammingDistance();
			oldPriority += a.getHammingDistance();
			break;
		case SumOfManhattanDistances:
			newPriority += a.getTotalManhattanDistances();
			oldPriority += a.getTotalManhattanDistances();
			break;
		default:
			break;
		}
		if (newPriority<oldPriority) {
			Entry<Puzzle> e = new Entry<Puzzle>(a, newPriority);
			this.decreaseKey(e, newPriority);
			unsettled.put(a, a);
		}
	}
	
	public boolean wasSettled(Puzzle key) {
		return settled.containsKey(key);
	}
	
	public boolean contains(Puzzle key) {
		return unsettled.containsKey(key);
	}
	
	public boolean isEmpty() {
		return unsettled.size()==0;
	}
	
	public int odwiedzoneWezly() {
		return unsettled.size()+settled.size();
	}
}
