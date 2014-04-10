package pl.lodz.p.sise.exceptions;

public class IllegalPuzzleException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118775245136552977L;

	public IllegalPuzzleException (int index) {
		super("Nieprawidłowy index. Próbowano wprowadzić: "+index);
	}
}
