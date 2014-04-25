package pl.lodz.p.sise.structure;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;

public class Statistics {

	private boolean success = true;
	private String failMessage;
	private Puzzle startPoint;
	private int difficultyLevel;
	private List<Ruch> moves;
	private int iterations;
	private long time;
	private long nanotime;
	private int maxMemoryUsed;
	private String memoryUnits;
	private String structureType;
	private String algorytm;
	private String heurystyka;
	public String getAlgorytm() {
		return algorytm;
	}
	public void setAlgorytm(String algorytm) {
		this.algorytm = algorytm;
	}
	public String getHeurystyka() {
		return heurystyka;
	}
	public void setHeurystyka(String heurystyka) {
		this.heurystyka = heurystyka;
	}
	public List<Ruch> getMoves() {
		return moves;
	}
	public void setMoves(List<Ruch> moves) {
		this.moves = moves;
	}
	public int getIterations() {
		return iterations;
	}
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	public String getTime() {
		return ""+((double)time)/1000;
//		return ""+time;
	}
	/**
	 * @param time - Czas w milisekundach
	 */
	public void setTime(long time) {
		this.time = time;
	}
	public int getMaxMemoryUsed() {
		return maxMemoryUsed;
	}
	public void setMaxMemoryUsed(int maxMemoryUsed) {
		this.maxMemoryUsed = maxMemoryUsed;
	}
	public String getMemoryUnits() {
		return memoryUnits;
	}
	public void setMemoryUnits(String memoryUnits) {
		this.memoryUnits = memoryUnits;
	}
	public String getStructureType() {
		return structureType;
	}
	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}
	public Puzzle getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Puzzle startPoint) {
		this.startPoint = startPoint;
	}
	public String getMemoryUsageFromVM() {
		long MEGABYTE = 1024L * 1024L;
		long KILOBYTE = 1024L;
		Runtime runtime = Runtime.getRuntime();
	    // Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    String decimal = customFormat("###,###,###,###", memory);
	    return (""+memory/MEGABYTE+"."+memory/KILOBYTE+" MB ("
	    		+decimal+" bytes)");
	}
	public List<Puzzle> getSteps() {
		ArrayList<Puzzle> steps = new ArrayList<>();
		List<Ruch> ruchy = this.getMoves();
		Puzzle currentNode = getStartPoint();
		steps.add(currentNode);
		for (Ruch kierunek : ruchy) {
			currentNode = currentNode.move(kierunek);
			steps.add(currentNode);
		}
		return steps;
	}
	
	public void visualizeSolution() {
		int i=0;
		for (Puzzle step : this.getSteps()) {
			System.out.println("========="+ ++i +"============");
			System.out.println(step.getStringRepresentation());
			System.out.println("======================");
		}
	}
	
	public String toString() {
		String heurystyka = "";
		String failMessage = "";
		String poziomTrudnosci = "";
		String znalezionaSciezka = "Nie znaleziono rozwiązania.\n";
		if (isSuccess()) {
			if (getDifficultyLevel()!=0)
				poziomTrudnosci = "Poziom trudności: \t\t"+getDifficultyLevel()+"\n";
			if (getMoves().size()<100)
				znalezionaSciezka = "Najkrótsza znaleziona ścieżka: \t"+getMoves().size()+"\n"+getMoves()+"\n";
			else
				znalezionaSciezka = "Znaleziona ścieżka jest za długa aby ją wyświetlić. "
				+getMoves().size()+" kroków.";
		}
		else {
			failMessage =  getFailMessage()+"\n";
		}
		if (getHeurystyka()!=null)
			heurystyka="Rodzaj użytej heurystyki: \t"+getHeurystyka()+"\n";
		String s = "=========================================================\n"
				+  failMessage
				+ "Algorytm: \t\t\t"+getAlgorytm()+"\n"
				+  heurystyka 
				+ "Czas wykonania: \t\t"+getTime()+" sekund\n"
				+ "Liczba operacji: \t\t"+getIterations()+"\n"
				+ "Użyte jednostki pamięci: \t"+getMaxMemoryUsed()+"\n"
				+ "Obowiązująca jednostka pamięci: "+getMemoryUnits()+"\n"
				+ "Rozmiar w pamięci: \t\t"+getMemoryUsageFromVM()+"\n"
				+ "Użyta struktura danych: \t"+getStructureType()+"\n"
				+  poziomTrudnosci
				+ "Układ początkowy:\n"+getStartPoint().getStringRepresentation()+"\n\n"
				+  znalezionaSciezka
//				+ "Wizualizacja: "
//				+"=========================================================\n"
				;
		return s;	
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getFailMessage() {
		return failMessage;
	}
	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	static public String customFormat(String pattern, double value ) {
	      DecimalFormat myFormatter = new DecimalFormat(pattern);
	      return myFormatter.format(value);
	   }
	public int getNumberOfSteps() {
		if (getMoves()!=null) {
			return getMoves().size();
		}
		return 0;
	}
	public void setNano(long l) {
		this.nanotime = l;
	}
	public String getNanoTime() {
		return ""+this.nanotime;
	}
}
