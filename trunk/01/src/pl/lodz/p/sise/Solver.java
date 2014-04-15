package pl.lodz.p.sise;

import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;

public class Solver {

	public static void main(String[] args) {
		
		System.out.println("=========================================================");
		System.out.println("DEPTH FIRST SEARCH:");
		System.out.println("=========================================================");
		System.out.println();
		DFS dfs = new DFS();
		System.out.println(dfs.search());
		
		System.out.println("=========================================================");
		System.out.println("BREADTH FIRST SEARCH:");
		System.out.println("=========================================================");
		System.out.println();
		BFS bfs = new BFS();
		System.out.println(bfs.search());
		
	}
}
