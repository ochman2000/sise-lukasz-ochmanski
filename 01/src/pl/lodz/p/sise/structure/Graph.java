package pl.lodz.p.sise.structure;

import java.util.List;

import pl.lodz.p.sise.Puzzle;

public class Graph {
	private final List<Puzzle> vertexes;
	private final List<Edge> edges;

	public Graph(List<Puzzle> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Puzzle> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}