package pl.lodz.p.sise;

import java.util.List;

import pl.lodz.p.sise.algorithms.DFS;

public class Solver {

	public static void main(String[] args) {
		DFS dfs = new DFS();
		List<Ruch> list = dfs.search();
		for (Ruch ruch : list) {
			System.out.print(ruch+",");
		}		
	}
}
