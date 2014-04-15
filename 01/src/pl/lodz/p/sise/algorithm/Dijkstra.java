package pl.lodz.p.sise.algorithm;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.structure.Edge;
import pl.lodz.p.sise.structure.Graph;

public class Dijkstra {

	private Graph graph;
	

	public Dijkstra() {
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		int[] t_b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 13, 14, 15, 12 };
		int[] t_c = { 1, 2, 3, 4, 5, 6, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
		int[] t_d = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12 };
		int[] t_e = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0 };
		Puzzle a,b,c,d,e; a=b=c=d=e=null;
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
		
		
		return null;
	}
}