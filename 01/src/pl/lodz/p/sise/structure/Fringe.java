package pl.lodz.p.sise.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import pl.lodz.p.sise.Puzzle;

public class Fringe<V> extends HashMap<Puzzle, Predecessor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4814714233235085597L;

	public Map.Entry<Puzzle, Predecessor> getLowestCostPath() {
		Map.Entry<Puzzle, Predecessor> ret = null;
		int shortestDistance = Integer.MAX_VALUE;
		for (Iterator<Entry<Puzzle, Predecessor>> iterator = this.entrySet().iterator(); iterator.hasNext();) {
			Entry<Puzzle, Predecessor> e = iterator.next();
			int vertexDistance = e.getValue().getDistance();
			if (vertexDistance<shortestDistance) {
				ret = e;
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

}
