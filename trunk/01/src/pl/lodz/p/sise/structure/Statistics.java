package pl.lodz.p.sise.structure;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;

public class Statistics {

	private boolean success = true;
	private String failMessage;
	private Puzzle startPoint;
	private List<Ruch> moves;
	private int iterations;
	private long time;
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
	
	public String toString() {
		String heurystyka = "";
		String failMessage = "";
		String poziomTrudnosci = "";
		String znalezionaSciezka = "Nie znaleziono rozwiązania.\n";
		if (isSuccess()) {
			poziomTrudnosci = "Poziom trudności: \t\t"+getMoves().size()+"\n";
			znalezionaSciezka = "Najkrótsza znaleziona ścieżka: \t"+getMoves().size()+"\n"+getMoves()+"\n";
		}
		else {
			failMessage =  getFailMessage();
		}
		if (getHeurystyka()!=null)
			heurystyka="Rodzaj użytej heurystyki: \t"+getHeurystyka()+"\n";
		String s = "=========================================================\n"
				+  failMessage+"\n"
				+ "Algorytm: \t\t\t"+getAlgorytm()+"\n"
				+  heurystyka 
				+ "Czas wykonania: \t\t"+getTime()+" sekund\n"
				+ "Liczba operacji: \t\t"+getIterations()+"\n"
				+ "Użyte jednostki pamięci: \t"+getMaxMemoryUsed()+"\n"
				+ "Użyta struktura danych: \t"+getStructureType()+"\n"
				+ "Obowiązująca jednostka pamięci: "+getMemoryUnits()+"\n"
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
}
