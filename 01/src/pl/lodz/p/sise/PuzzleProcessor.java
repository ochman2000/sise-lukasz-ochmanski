package pl.lodz.p.sise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import pl.lodz.p.sise.algorithm.AGwiazdka1;
import pl.lodz.p.sise.algorithm.AGwiazdka2;
import pl.lodz.p.sise.algorithm.AGwiazdka3;
import pl.lodz.p.sise.algorithm.BFS;
import pl.lodz.p.sise.algorithm.DFS;
import pl.lodz.p.sise.structure.Statistics;

public class PuzzleProcessor {

	public static void main(String[] args) {
		PuzzleProcessor processor = new PuzzleProcessor();
		
		for (int i=1; i<=10; i++) {
			processor.processBatch(i);
		}
	}
	
	public void processBatch(int level) {
		PuzzleProcessor processor = new PuzzleProcessor();
		
		String str = (level<10) ? "0"+level : ""+level;
		
//		processor.processFile("bfs", "level"+str+".txt", level);
//		processor.processFile("dijkstra", "level"+str+".txt", level);
//		processor.processFile("a1", "level"+str+".txt", level);
//		processor.processFile("a2", "level"+str+".txt", level);
//		processor.processFile("a3", "level"+str+".txt", level);
		processor.processFile("dfs", "level"+str+".txt", level);
		
	}
	
	public void processFile(String algorytm, String sourceFile, int level) {
		List<String> lista	= null;
		Path path = Paths.get("sample/"+sourceFile);
		PrintWriter out = null;
		int iteracje=0;
		try {
			lista = Files.readAllLines(path, StandardCharsets.UTF_8);
			path = Paths.get("solution/"+algorytm+"_"+sourceFile);
//			Files.deleteIfExists(path);
			boolean append = true;
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					"solution/"+algorytm+"_DGPL.txt", append)));
			for (String puzzle : lista) {
				int[]a = stringToArray(puzzle);
				Statistics stats = process(a, algorytm);
				out.println(level+"\t"
						+stats.getStartPoint()+"\t"
						+stats.getAlgorytm()+"\t"
						+stats.getHeurystyka()+"\t"
						+stats.getIterations()+"\t"
						+stats.getMaxMemoryUsed()+"\t"
						+stats.getMemoryUsageFromVM()+"\t"
						+stats.getTime()+"\t"
						+stats.getNanoTime()+"\t"
						+stats.getNumberOfSteps()+"\t"
						+stats.getFailMessage()+"\t"
						+stats.getZnalezionaSciezka()+"\t");
				System.out.println(++iteracje+"\t"+stats.getAlgorytm()+"\t"+stats.getStartPoint() +"\t"+stats.getMoves());
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
	}
	
	public Statistics process(int[] t_a, String algorytm) {
		switch (algorytm.toLowerCase()) {
//		case "dijkstra":			
//			Dijkstra dj = new Dijkstra(t_a);
//			return dj.getStatistics();
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
