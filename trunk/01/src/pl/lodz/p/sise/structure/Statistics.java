package pl.lodz.p.sise.structure;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;

public class Statistics {

	private Puzzle startPoint;
	private List<Ruch> moves;
	private int iterations;
	private long time;
	private int maxMemoryUsed;
	private String memoryUnits;
	private String structureType;
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
	public long getTime() {
		return time;
	}
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
}
