package pl.lodz.p.sise.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;

/**
 * Tak klasa dziedziczy po HashMapie, choć tak naprawdę powinno tu być
 * Fibbonacci Heap, żeby można natychmiast znajdywać najmniejszą wartość.
 * @author Lukasz
 *
 */
public class Fringe extends HashMap<Puzzle, Predecessor> {

	private Set<Puzzle> examined;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814714233235085597L;
	
	public Fringe() {
		examined = new HashSet<Puzzle>();
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
		Puzzle ret = null;
		int shortestDistance = Integer.MAX_VALUE;
		Iterator<Entry<Puzzle, Predecessor>> it = this.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Puzzle, Predecessor> e = it.next();
			int vertexDistance = e.getValue().getDistance();
			if (vertexDistance<shortestDistance && !e.getKey().wasVisited()) {
				ret = e.getKey();
			}	
		}
		if (ret!=null)
			ret.setVisited();
		return ret;
	}
	
	/**
	 * Funkcja zwraca poprzednika, czyli wierzchołek przez który należało przejść,
	 * aby uzyskać wartość: "odległość". Odległość jest to najkrótszą
	 * dotychczas osiągniętą drogą dla danego argumentu. Ponadto zwrócony obiekt zawiera
	 * informację, jaki ruch należało wykonać, aby tu dotrzeć: Lewo, Prawo, Góra, Dół.
	 * 
	 */
	public Predecessor get(Puzzle key) {
		return super.get(key);
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
	public void put(Puzzle a, int b, Puzzle c, Ruch d) {
		if (a==null)
			throw new NullPointerException("Próbujesz wstawić pustą układankę.");
		this.put(a, new Predecessor(b, c, d));
	}

}
