package pl.lodz.p.sise.structure;

import pl.lodz.p.sise.Puzzle;

public class Edge {
	private final String id;
	private final Puzzle source;
	private final Puzzle destination;
	private final int weight;

	/**
	 * 
	 * @param id - nazwa
	 * @param source - koniec A
	 * @param destination - koniec B
	 * @param weight - odległość
	 */
	public Edge(String id, Puzzle source, Puzzle destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public Puzzle getDestination() {
		return destination;
	}

	public Puzzle getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

}