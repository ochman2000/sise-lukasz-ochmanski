package pl.lodz.p.sise;

import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;
import pl.lodz.p.sise.algorithm.Dijkstra;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

public class Solver {

	public static void main(String[] args) {
		
//		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
//		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 13, 14, 15, 12 };
		int[] t_a = { 1, 2, 3, 4, 5, 6, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
//		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12 };
		
		System.out.println("DFS");
		DFS dfs = new DFS(t_a);
		System.out.println(dfs.getStatistics());

		System.out.println("BFS");
		BFS bfs = new BFS(t_a);
		System.out.println(bfs.getStatistics());
		
		System.out.println("Dijkstra");
		Dijkstra dj = new Dijkstra(t_a);
		System.out.println(dj.getStatistics());
	}
}
