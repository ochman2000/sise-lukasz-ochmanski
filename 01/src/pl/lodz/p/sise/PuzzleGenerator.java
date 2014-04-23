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
		generator.generateABatchOfPuzzles(2, 1, "sample/level01.txt");
		generator.generateABatchOfPuzzles(4, 2, "sample/level02.txt");
		generator.generateABatchOfPuzzles(10, 3, "sample/level03.txt");
		generator.generateABatchOfPuzzles(24, 4, "sample/level04.txt");
		generator.generateABatchOfPuzzles(54, 5, "sample/level05.txt");
		generator.generateABatchOfPuzzles(107, 6, "sample/level06.txt");
		generator.generateABatchOfPuzzles(120, 7, "sample/level07.txt");
		generator.generateABatchOfPuzzles(120, 8, "sample/level08.txt");
		generator.generateABatchOfPuzzles(120, 9, "sample/level09.txt");
		generator.generateABatchOfPuzzles(120, 10, "sample/level10.txt");
		generator.generateABatchOfPuzzles(10, 20, "sample/level20.txt");
		generator.generateABatchOfPuzzles(10, 30, "sample/level30.txt");
		generator.generateABatchOfPuzzles(10, 40, "sample/level40.txt");
		generator.generateABatchOfPuzzles(10, 50, "sample/level50.txt");
		generator.generateABatchOfPuzzles(10, 60, "sample/level60.txt");
		generator.generateABatchOfPuzzles(10, 70, "sample/level70.txt");
		generator.generateABatchOfPuzzles(10, 80, "sample/level80.txt");
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