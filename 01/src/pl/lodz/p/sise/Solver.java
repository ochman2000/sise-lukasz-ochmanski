package pl.lodz.p.sise;

import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;
import pl.lodz.p.sise.algorithm.Dijkstra;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.NoSolutionException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.exception.TimeoutException;

public class Solver {

	public static void main(String[] args) {
		
		Puzzle a,b,c,d; a=b=c=d=null;
		
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		int[] t_b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 13, 14, 15, 12 };
		int[] t_c = { 1, 2, 3, 4, 5, 6, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
		int[] t_d = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12 };

		try {
			a = new Puzzle(t_a);
			b = new Puzzle(t_b);
			c = new Puzzle(t_c);
			d = new Puzzle(t_d);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException ex) {
			System.err.println(ex.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		
		System.out.println("=========================================================");
		System.out.println("DEPTH FIRST SEARCH:");
		System.out.println("=========================================================");
		System.out.println();
		DFS dfs = new DFS(t_a);
//		System.out.println(dfs.search());
		
		System.out.println("=========================================================");
		System.out.println("BREADTH FIRST SEARCH:");
		System.out.println("=========================================================");
		System.out.println();
		BFS bfs = new BFS(t_a);
//		System.out.println(bfs.search());
		
		System.out.println("=========================================================");
		System.out.println("DIJKSTRA SEARCH:");
		System.out.println("=========================================================");
		System.out.println();
		Dijkstra dj = new Dijkstra(t_a);
		System.out.println(dj.getStatistics());
	}
}
