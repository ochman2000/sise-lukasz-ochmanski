package pl.lodz.p.sise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

public class PuzzleGenerator {

	public static void main(String[] args) {
		PuzzleGenerator generator = new PuzzleGenerator();
//		generator.generateABatchOfPuzzles(2, 1, "sample/level01.txt");
//		generator.generateABatchOfPuzzles(4, 2, "sample/level02.txt");
//		generator.generateABatchOfPuzzles(10, 3, "sample/level03.txt");
//		generator.generateABatchOfPuzzles(24, 4, "sample/level04.txt");
//		generator.generateABatchOfPuzzles(54, 5, "sample/level05.txt");
//		generator.generateABatchOfPuzzles(107, 6, "sample/level06.txt");
//		generator.generateABatchOfPuzzles(120, 7, "sample/level07.txt");
//		generator.generateABatchOfPuzzles(120, 8, "sample/level08.txt");
//		generator.generateABatchOfPuzzles(120, 9, "sample/level09.txt");
//		generator.generateABatchOfPuzzles(120, 10, "sample/level10.txt");
		generator.generateABatchOfPuzzles(120, 11, "sample/level11.txt");
		generator.generateABatchOfPuzzles(120, 12, "sample/level12.txt");
		generator.generateABatchOfPuzzles(120, 13, "sample/level13.txt");
		generator.generateABatchOfPuzzles(120, 14, "sample/level14.txt");
		generator.generateABatchOfPuzzles(120, 15, "sample/level15.txt");
		generator.generateABatchOfPuzzles(120, 16, "sample/level16.txt");
		generator.generateABatchOfPuzzles(120, 17, "sample/level17.txt");
		generator.generateABatchOfPuzzles(120, 18, "sample/level18.txt");
		generator.generateABatchOfPuzzles(120, 19, "sample/level19.txt");
		generator.generateABatchOfPuzzles(120, 20, "sample/level20.txt");
		generator.generateABatchOfPuzzles(120, 21, "sample/level21.txt");
		generator.generateABatchOfPuzzles(120, 22, "sample/level22.txt");
		generator.generateABatchOfPuzzles(120, 23, "sample/level23.txt");
		generator.generateABatchOfPuzzles(120, 24, "sample/level24.txt");
		generator.generateABatchOfPuzzles(120, 25, "sample/level25.txt");
		
	}

	public Puzzle generate(int level) {
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0 };
		Puzzle a = null;
		try {
			a = new Puzzle(t_a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			e.printStackTrace();
		}
		int i = 0;
		Set<Puzzle> visited = new HashSet<Puzzle>();
		while (i < level) {
			Puzzle b = losuj(a);
			if (!visited.contains(b) && !b.isSolved()) {
				visited.add(b);
				a = b;
				i++;
			}
		}
		return a;
	}

	private Puzzle losuj(Puzzle a) {
		Random r = new Random();
		int c = r.nextInt(a.getNeighboors().size());
		return a.move(a.getNeighboors().get(c));
	}

	public void generateABatchOfPuzzles(int amount, int level, String filename) {
		Set<Puzzle> visited = new HashSet<Puzzle>();
		PrintWriter out = null;
		Path file = Paths.get(filename);
		try {
			Files.deleteIfExists(file);
			boolean append = true;
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					filename, append)));
			while (visited.size() < amount) {
				Puzzle a = this.generate(level);
				if (!visited.contains(a)) {
					visited.add(a);
					out.println(a.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Układanki zapisano do pliku: " + filename);
		out.close();
	}
}