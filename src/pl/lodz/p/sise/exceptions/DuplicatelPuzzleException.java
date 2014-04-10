package pl.lodz.p.sise.exceptions;

public class DuplicatelPuzzleException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118775245136552977L;

	public DuplicatelPuzzleException (int no) {
		super("Znaleziono duplikat. Liczba powtórzonych elementów: "+no);
	}
}
