package pl.lodz.p.sise.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;

public class Graph {
//	private final List<Puzzle> vertexes;
//	private final List<Edge> edges;
	private HashSet<Puzzle> visited;
	private Ruch[] porządek = { Ruch.L, Ruch.P, Ruch.G, Ruch.D };

	public Graph(Puzzle startNode) {
		this.visited = new HashSet<Puzzle>();
		visited.add(startNode);
	}

//	public List<Puzzle> getVertexes() {
//		return vertexes;
//	}
//
//	public List<Edge> getEdges() {
//		return edges;
//	}
	
	/**
	 * Zwraca liczbę odwiedzonych węzłów.
	 * @return
	 */
	public int numberOfVisitedNodes() {
		return this.visited.size();
	}
	
	/**
	 * Zwraca listę wszystkich bezpośrednich sąsiadów, którzy nie byli
	 * jeszcze odwiedzeni.
	 * @param puzzle
	 * @return
	 */
	public List<Ruch> getNeighboors(Puzzle puzzle) {
		ArrayList<Ruch> sąsiedzi = new ArrayList<>();
//		Puzzle przesunięcie0 = puzzle.move(porządek[0]);
		if (puzzle.isAllowed(porządek[0])) {// && !wasNodeVisited(przesunięcie0)) {
			sąsiedzi.add(porządek[0]);
		}
//		Puzzle przesunięcie1 = puzzle.move(porządek[1]);
		if (puzzle.isAllowed(porządek[1])) {// && !wasNodeVisited(przesunięcie1)) {
			sąsiedzi.add(porządek[1]);
		}
//		Puzzle przesunięcie2 = puzzle.move(porządek[2]);
		if (puzzle.isAllowed(porządek[2])) {// && !wasNodeVisited(przesunięcie2)) {
			sąsiedzi.add(porządek[2]);
		}
//		Puzzle przesunięcie3 = puzzle.move(porządek[3]);
		if (puzzle.isAllowed(porządek[3])) {// && !wasNodeVisited(przesunięcie3)) {
			sąsiedzi.add(porządek[3]);
		}
		return sąsiedzi;
	}
	
	/**
	 * Zaznacza, że dany węzeł był już odwiedzony.
	 * @param node
	 */
	public void setVisited(Puzzle node) {
		visited.add(node);
	}
	
	/**
	 * Sprawdza, czy podany węzeł był już odwiedzony.
	 * @param node
	 * @return
	 */
	public boolean wasNodeVisited(Puzzle node) {
		return visited.contains(node);
	}
}