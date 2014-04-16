package pl.lodz.p.sise.structure;

import pl.lodz.p.sise.Puzzle;

public class Predecessor {

	private int shortestDistance;
	private Puzzle vertex;
	
	public Predecessor(int distance, Puzzle vertex) {
		this.setDistance(distance);
		this.setVertex(vertex);
	}

	public int getDistance() {
		return shortestDistance;
	}

	public void setDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	public Puzzle getVertex() {
		return vertex;
	}

	public void setVertex(Puzzle vertex) {
		this.vertex = vertex;
	}
}
