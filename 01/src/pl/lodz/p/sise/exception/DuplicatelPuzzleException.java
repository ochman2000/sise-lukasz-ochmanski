package pl.lodz.p.sise.exception;

import java.util.List;

public class DuplicatelPuzzleException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118775245136552977L;

	public DuplicatelPuzzleException (List<Integer> param) {
		super("Znaleziono duplikat. Powtórzony element: "+param);
	}
}
