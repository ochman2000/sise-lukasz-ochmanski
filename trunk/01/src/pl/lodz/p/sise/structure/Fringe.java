package pl.lodz.p.sise.structure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import pl.lodz.p.sise.Puzzle;

/**
 * Tak klasa dziedziczy po HashMapie, choć tak naprawdę powinno tu być
 * Fibbonacci Heap, żeby można natychmiast znajdywać najmniejszą wartość.
 * @author Lukasz
 *
 */
public class Fringe extends PriorityQueue<Puzzle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4814714233235085597L;
	private Map<Puzzle, Puzzle> settled;
	private Map<Puzzle, Puzzle> unsettled;
	
	public Fringe(Comparator<Puzzle> arg1) {
		super(8, arg1);
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
	public Puzzle getLowestCostPath() {
		Puzzle ret = this.remove();
		unsettled.remove(ret);
		settled.put(ret, ret);
		return ret;
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
	public void enqueue(Puzzle a) {
		if (a==null)
			throw new NullPointerException("Próbujesz wstawić pustą układankę.");
		this.add(a);
		unsettled.put(a, a);
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

	public void decreaseKey(Puzzle key) {
		enqueue(key);
		
	}
}
