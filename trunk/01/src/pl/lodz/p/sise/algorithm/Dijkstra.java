package pl.lodz.p.sise.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.Visited;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.structure.Edge;
import pl.lodz.p.sise.structure.Fringe;
import pl.lodz.p.sise.structure.Graph;
import pl.lodz.p.sise.structure.Predecessor;

public class Dijkstra {
	Puzzle a,b,c,d,e;
	private Graph graph;
	private Ruch[] porządek = { Ruch.L, Ruch.P, Ruch.G, Ruch.D };

	public Dijkstra() {
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		int[] t_b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 13, 14, 15, 12 };
		int[] t_c = { 1, 2, 3, 4, 5, 6, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
		int[] t_d = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12 };
		int[] t_e = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0 };

		try {
			a = new Puzzle(t_a);
			b = new Puzzle(t_b);
			c = new Puzzle(t_c);
			d = new Puzzle(t_d);
			e = new Puzzle(t_e);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException ex) {
			System.err.println(ex.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		
		List<Puzzle> vertices = new ArrayList<Puzzle>();
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge("ab", a, b, 1));
		edges.add(new Edge("bc", b, c, 1));
		edges.add(new Edge("bd", b, d, 1));
		edges.add(new Edge("de", d, e, 1));
		
		graph = new Graph(vertices, edges);
		
		
	}
	
	public List<Ruch> search() {
		Fringe fringe = new Fringe(); 	//PREDECESSORS WITH THE DISTANCE
		List<Ruch> result = new ArrayList<Ruch>();
		Visited visited = new Visited();
		
		//DEFINIUJEMY MIEJSCE STARTU
		fringe.put(b, new Predecessor(1, a));
		Entry<Puzzle, Predecessor> currentNode = fringe.getLowestCostPath();
		
		while (true) {
			if (currentNode.getKey().isSolved())
				return result;
			
			//WYBIERZ NAJKRÓTSZĄ ŚCIEŻKĘ Z FRINGE'A
			currentNode = fringe.getLowestCostPath();
			int dist = currentNode.getValue().getDistance();
			//TERAZ ZNAJDŹ WSZYSTKICH SĄSIADÓW TEGO WĘZŁA

			for (int i = 0; i<Ruch.values().length; i++) {
				Puzzle przesunięcie = currentNode.getKey().move(porządek[i]);
				if (currentNode.getKey().isAllowed(porządek[i])	&& !visited.contains(przesunięcie)) {
					Predecessor p = fringe.get(przesunięcie);
					int staraOdległość = p==null ? Integer.MAX_VALUE : p.getDistance();
					int nowaOdległość = dist + 1;
					if (nowaOdległość < staraOdległość) {
						fringe.put(przesunięcie, new Predecessor(nowaOdległość, currentNode.getKey()));
						result.add(porządek[i]);
						visited.add(przesunięcie);
					}
				}
			}
		}
	}
}