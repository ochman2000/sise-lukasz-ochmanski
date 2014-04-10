package pl.lodz.p.sise;

import java.util.HashSet;
import java.util.Iterator;

public class Visited extends HashSet<Puzzle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4387663413377150881L;

	public Visited() {
		super();
	}
	
	/**
	 * Nadpisana metoda.
	 */
	@Override
	public boolean contains(Object obj) {
		Iterator<Puzzle> it = this.iterator();
		while (it.hasNext()) {
			if (it.next().equals(obj))
				return true;
		}
		return false;
	}
}
