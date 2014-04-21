package pl.lodz.p.sise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import pl.lodz.p.sise.algorithm.AGwiazdka1;
import pl.lodz.p.sise.algorithm.AGwiazdka2;
import pl.lodz.p.sise.algorithm.AGwiazdka3;
import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;
import pl.lodz.p.sise.algorithm.Dijkstra;
import pl.lodz.p.sise.structure.Statistics;

public class PuzzleProcessor {

	private static final String CHARSET = "UTF-8";
	
	public static void main(String[] args) {
		PuzzleProcessor processor = new PuzzleProcessor();
//		processor.processBatch(1);
		processor.processBatch(2);
//		processor.processBatch(3);
//		processor.processBatch(4);
//		processor.processBatch(5);
//		processor.processBatch(6);
//		processor.processBatch(7);
//		processor.processBatch(9);
//		processor.processBatch(10);
	}
	
	public void processBatch(int level) {
		PuzzleProcessor processor = new PuzzleProcessor();
		if (level == 1) {
			processor.processFile("bfs", "level01.txt");
//			processor.processFile("dijkstra", "level01.txt");
//			processor.processFile("a1", "level01.txt");
//			processor.processFile("a2", "level01.txt");
//			processor.processFile("a3", "level01.txt");
//			processor.processFile("dfs", "level01.txt");
		}
		if (level == 2) {
			processor.processFile("bfs", "level02.txt");
//			processor.processFile("dijkstra", "level02.txt");
//			processor.processFile("a1", "level02.txt");
//			processor.processFile("a2", "level02.txt");
//			processor.processFile("a3", "level02.txt");
//			processor.processFile("dfs", "level02.txt");
		}
		if (level == 3) {
			processor.processFile("bfs", "level03.txt");
//			processor.processFile("dijkstra", "level03.txt");
//			processor.processFile("a1", "level03.txt");
//			processor.processFile("a2", "level03.txt");
//			processor.processFile("a3", "level03.txt");
//			processor.processFile("dfs", "level03.txt");
		}
		if (level == 4) {
			processor.processFile("bfs", "level04.txt");
//			processor.processFile("dijkstra", "level04.txt");
//			processor.processFile("a1", "level04.txt");
//			processor.processFile("a2", "level04.txt");
//			processor.processFile("a3", "level04.txt");
//			processor.processFile("dfs", "level04.txt");
		}
		if (level == 5) {
			processor.processFile("bfs", "level05.txt");
//			processor.processFile("dijkstra", "level05.txt");
//			processor.processFile("a1", "level05.txt");
//			processor.processFile("a2", "level05.txt");
//			processor.processFile("a3", "level05.txt");
//			processor.processFile("dfs", "level05.txt");
		}
		if (level == 6) {
			processor.processFile("bfs", "level06.txt");
//			processor.processFile("dijkstra", "level06.txt");
//			processor.processFile("a1", "level06.txt");
//			processor.processFile("a2", "level06.txt");
//			processor.processFile("a3", "level06.txt");
//			processor.processFile("dfs", "level06.txt");
		}
		if (level == 7) {
			processor.processFile("bfs", "level07.txt");
//			processor.processFile("dijkstra", "level07.txt");
//			processor.processFile("a1", "level07.txt");
//			processor.processFile("a2", "level07.txt");
//			processor.processFile("a3", "level07.txt");
//			processor.processFile("dfs", "level07.txt");
		}
		if (level == 8) {
			processor.processFile("bfs", "level08.txt");
//			processor.processFile("dijkstra", "level08.txt");
//			processor.processFile("a1", "level08.txt");
//			processor.processFile("a2", "level08.txt");
//			processor.processFile("a3", "level08.txt");
//			processor.processFile("dfs", "level08.txt");
		}
		if (level == 9) {
			processor.processFile("bfs", "level09.txt");
//			processor.processFile("dijkstra", "level09.txt");
//			processor.processFile("a1", "level09.txt");
//			processor.processFile("a2", "level09.txt");
//			processor.processFile("a3", "level09.txt");
//			processor.processFile("dfs", "level09.txt");
		}
		if (level == 10) {
			processor.processFile("bfs", "level10.txt");
			processor.processFile("dijkstra", "level10.txt");
			processor.processFile("a1", "level10.txt");
			processor.processFile("a2", "level10.txt");
			processor.processFile("a3", "level10.txt");
//			processor.processFile("dfs", "level10.txt");
		}
	}
	
	public void processFile(String algorytm, String sourceFile) {
		List<String> lista	= null;
		Path path = Paths.get("sample/"+sourceFile);
		PrintWriter out = null;
		int iteracje=0;
		try {
			lista = Files.readAllLines(path, Charset.forName(CHARSET));
			path = Paths.get("solution/"+algorytm+"_"+sourceFile);
			Files.deleteIfExists(path);
			boolean append = true;
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					"solution/"+algorytm+"_"+sourceFile, append)));
			for (String puzzle : lista) {
				int[]a = stringToArray(puzzle);
				Statistics stats = process(a, algorytm);
				out.println(stats.getStartPoint()+"\t"
						+stats.getAlgorytm()+"\t"
						+stats.getHeurystyka()+"\t"
						+stats.getIterations()+"\t"
						+stats.getMaxMemoryUsed()+"\t"
						+stats.getMemoryUsageFromVM()+"\t"
						+stats.getTime()+"\t"
						+stats.getMoves().size()+"\t"
						+stats.getFailMessage()+"\t"
						+stats.getMoves()+"\t");
				System.out.println(++iteracje+"\t"+stats.getStartPoint() +"\t"+stats.getMoves());
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
	}
	
	public Statistics process(int[] t_a, String algorytm) {
		switch (algorytm.toLowerCase()) {
		case "dijkstra":			
			Dijkstra dj = new Dijkstra(t_a);
			return dj.getStatistics();
		case "bfs":
			BFS bfs = new BFS(t_a);
			return bfs.getStatistics();
		case "dfs":
			DFS dfs = new DFS(t_a);
			return dfs.getStatistics();
		case "a1":
			AGwiazdka1 ag1 = new AGwiazdka1(t_a);
			return ag1.getStatistics();
		case "a2":
			AGwiazdka2 ag2 = new AGwiazdka2(t_a);
			return ag2.getStatistics();
		case "a3":
			AGwiazdka3 ag3 = new AGwiazdka3(t_a);
			return ag3.getStatistics();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public int[] stringToArray(final String input) {
	    String[] elements = input.substring(1, input.length() - 1).split(", ");
	    int[] result = new int[elements.length];
	    for (int i=0; i<elements.length; i++) {
	        result[i] = (Integer.valueOf(elements[i]));
	    }
	    return result;
	}
}
