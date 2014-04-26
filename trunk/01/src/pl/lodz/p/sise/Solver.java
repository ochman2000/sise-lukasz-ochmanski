package pl.lodz.p.sise;

import pl.lodz.p.sise.algorithm.AGwiazdka1;
import pl.lodz.p.sise.algorithm.AGwiazdka2;
import pl.lodz.p.sise.algorithm.AGwiazdka3;
import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;
import pl.lodz.p.sise.algorithm.Dijkstra;

public class Solver {

	public static void main(String[] args) {

//		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
//		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 13, 14, 15, 12 };
//		int[] t_a = { 1, 2, 3, 4, 5, 6, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
//		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12 };
//		int[] t_a = { 0, 6, 3, 4, 2, 1, 7, 8, 5, 10, 11, 12, 9, 13, 14, 15 };
//		int[] t_a = { 0, 2, 3, 4, 1, 6, 7, 8, 5, 13, 10, 11, 14, 9, 15, 12 };
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 12, 13, 14, 11, 15 };
		
		if (args.length>0) {
			if (args.length!=17) {
				System.out.println("Wymagany format: [algorytm] [indeksy odzielone spacjami]\n"
						+ "np. bfs 0 2 3 4 1 6 7 8 5 13 10 11 14 9 15 12");
				System.out.println("algorytmy do wyboru: bfs, dfs, dijkstra, a1, a2, a3, all");
				System.exit(-1);
			}
			int start = 1;
			int end = start+15;
			for (int i=start; i<end; i++) {
				try {
					t_a[i-start]=Integer.parseInt(args[i]);
				} catch (NumberFormatException e) {
					System.out.println("Wymagany format: [algorytm] [indeksy odzielone spacjami]\n"
							+ "np. bfs 0 2 3 4 1 6 7 8 5 13 10 11 14 9 15 12");
					System.out.println("algorytmy do wyboru: bfs, dfs, dijkstra, a1, a2, a3, all");
					System.exit(-1);
				}
			}
			switch (args[0]) {
			case "dfs":
			{
				System.out.println("DFS\t Trwa obliczanie...");
				DFS dfs = new DFS(t_a);
				System.out.println(dfs.getStatistics());
			}
				break;
			case "bfs": {
				System.out.println("BFS\t Trwa obliczanie...");
				BFS bfs = new BFS(t_a);
				System.out.println(bfs.getStatistics());
			}
				break;
			case "dijkstra": {
				System.out.println("Dijkstra\t Trwa obliczanie...");
				Dijkstra dj = new Dijkstra(t_a);
				System.out.println(dj.getStatistics());
			}
				break;
			case "a1": {
				System.out.println("A* Odległość taksówkowa\t Trwa obliczanie...");
				AGwiazdka1 ag1 = new AGwiazdka1(t_a);
				System.out.println(ag1.getStatistics());
			}
				break;
			case "a2": {
				System.out.println("A* Odległość Hamminga\t Trwa obliczanie...");
				AGwiazdka2 ag2 = new AGwiazdka2(t_a);
				System.out.println(ag2.getStatistics());
			}
				break;
			case "a3": {
				System.out.println("A* Suma odległości taksówkowych\t Trwa obliczanie...");
				AGwiazdka3 ag3 = new AGwiazdka3(t_a);
				System.out.println(ag3.getStatistics());
			}
				break;
			case "all": {
				wszystkie(t_a);
				break;
			}
			default: {
				System.out.println("Nieznany algorytm");
				System.out.println("Wymagany format: [algorytm] [indeksy odzielone spacjami]\n"
						+ "np. bfs 0 2 3 4 1 6 7 8 5 13 10 11 14 9 15 12");
				System.out.println("algorytmy do wyboru: bfs, dfs, dijkstra, a1, a2, a3, all");
				System.exit(-1);
			}
				break;
			} 
		}	
		
		if (args.length==0) {
			wszystkie(t_a);
		}
	}
	
	public static void wszystkie(int[] t_a) {

		System.out.println("Dijkstra\t Trwa obliczanie...");
		Dijkstra dj = new Dijkstra(t_a);
		System.out.println(dj.getStatistics());
		
		System.out.println("A* Odległość taksówkowa\t Trwa obliczanie...");
		AGwiazdka1 ag1 = new AGwiazdka1(t_a);
		System.out.println(ag1.getStatistics());
		
		System.out.println("A* Odległość Hamminga\t Trwa obliczanie...");
		AGwiazdka2 ag2 = new AGwiazdka2(t_a);
		System.out.println(ag2.getStatistics());
		
		System.out.println("A* Suma odległości taksówkowych\t Trwa obliczanie...");
		AGwiazdka3 ag3 = new AGwiazdka3(t_a);
		System.out.println(ag3.getStatistics());

		System.out.println("BFS\t Trwa obliczanie...");
		BFS bfs = new BFS(t_a);
		System.out.println(bfs.getStatistics());
		
		System.out.println("DFS\t Trwa obliczanie...");
		DFS dfs = new DFS(t_a);
		System.out.println(dfs.getStatistics());
	}
}
