package pl.lodz.p.sise;

import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;
import pl.lodz.p.sise.algorithm.Dijkstra;
import pl.lodz.p.sise.exception.NoSolutionException;

public class Solver {

	public static void main(String[] args) {
		
//		System.out.println("=========================================================");
//		System.out.println("DEPTH FIRST SEARCH:");
//		System.out.println("=========================================================");
//		System.out.println();
//		DFS dfs = new DFS();
//		System.out.println(dfs.search());
//		
//		System.out.println("=========================================================");
//		System.out.println("BREADTH FIRST SEARCH:");
//		System.out.println("=========================================================");
//		System.out.println();
//		BFS bfs = new BFS();
//		System.out.println(bfs.search());
		
		System.out.println("=========================================================");
		System.out.println("DIJKSTRA SEARCH:");
		System.out.println("=========================================================");
		System.out.println();
		Dijkstra dj = new Dijkstra();
		try {
			System.out.println(dj.search());
		} catch (NoSolutionException e) {
			System.err.println(e.getMessage());
		}
		
		
	}
}
