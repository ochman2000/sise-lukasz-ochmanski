package pl.lodz.p.sise.exceptions;

public class PuzzleFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118775245136552977L;

	public PuzzleFormatException (int len) {
		super("Nieprawidłowy format układanki. Liczba elementów: "+len);
	}
}
