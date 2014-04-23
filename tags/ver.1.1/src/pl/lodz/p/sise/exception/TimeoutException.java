package pl.lodz.p.sise.exception;

public class TimeoutException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118775245136552977L;

	public TimeoutException (int seconds) {
		super("Przekroczony dozwolony czas dokonywania obliczeń: "+seconds+"sekund");
	}
}
