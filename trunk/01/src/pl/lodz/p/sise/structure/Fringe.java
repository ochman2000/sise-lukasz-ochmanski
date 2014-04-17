package pl.lodz.p.sise.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.Visited;

public class Fringe extends HashMap<Puzzle, Predecessor> {

	private Visited visited;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814714233235085597L;
	
	public Fringe() {
		visited = new Visited();
	}

	public Puzzle getLowestCostPath() {
		Puzzle ret = null;
		int shortestDistance = Integer.MAX_VALUE;
		Iterator<Entry<Puzzle, Predecessor>> it = this.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Puzzle, Predecessor> e = it.next();
			int vertexDistance = e.getValue().getDistance();
			if (vertexDistance<shortestDistance && !visited.contains(e.getKey())) {
				ret = e.getKey();
			}	
		}
		return ret;
	}
	
	public Predecessor get(Object key) {
		for (Iterator<Entry<Puzzle, Predecessor>> iterator = this.entrySet().iterator(); iterator.hasNext();) {
			Entry<Puzzle, Predecessor> e = iterator.next();
			if (e.getKey().equals(key))
				return e.getValue();
		}
		return null;
	}
	
	/**
	 * Wstawia nowy element.
	 * @param a - węzeł do którego szuka się najkrótszej drogi
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
		this.put(a, new Predecessor(b, c, d));
	}

}
