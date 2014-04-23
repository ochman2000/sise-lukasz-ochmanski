package pl.lodz.p.sise.exception;

public class NoSolutionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118775245136552977L;

	public NoSolutionException () {
		super("Wszystkie węzły zostały przepadane i wciąż nie znaleziono rozwiązania.\n"
				+ "Może to oznaczać, że układanka jest nierozwiązywalna.");
	}
}
