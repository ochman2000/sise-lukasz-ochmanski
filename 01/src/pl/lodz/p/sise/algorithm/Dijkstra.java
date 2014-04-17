package pl.lodz.p.sise.algorithm;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;
import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.structure.Fringe;
import pl.lodz.p.sise.structure.Graph;
import pl.lodz.p.sise.structure.Predecessor;

public class Dijkstra {
	public static boolean DEBUG = true;
	Puzzle a,b,c,d,e;
	private Graph graph;

	public Dijkstra() {
		int[] t_a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 13, 14, 15, 12 };
		int[] t_b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 13, 14, 15, 12 };
		int[] t_c = { 1, 2, 3, 4, 5, 6, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
		int[] t_d = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 12 };
		int[] t_e = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0 };

		try {
			a = new Puzzle(t_a);
			b = new Puzzle(t_b);
			c = new Puzzle(t_c);
			d = new Puzzle(t_d);
			e = new Puzzle(t_e);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException	| PuzzleFormatException ex) {
			System.err.println(ex.getMessage() + "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		
		graph = new Graph(a);
	}
	
	public List<Ruch> search() {
		Fringe fringe = new Fringe(); 	//PREDECESSORS WITH THE DISTANCE
		List<Ruch> result = new ArrayList<Ruch>();
		int i = 0;
		long start = System.currentTimeMillis();
		
		fringe.put(b, 1, a, null); 	//TO TRZEBA POTEM ZAMIENIĆ NA PRAWDZIWY ELEMENT GRAFU
		int waga=1; 				//TRZEBA TO SKASOWAĆ PRZY UŻYWANIU HEURYSTYKI
		
		while (true) {
			//ZNAJDŹ NAJLEPSZY ZNANY NAM WĘZEŁ (ZNAJDUJĄCY SIĘ NAJBLIŻEJ STARTU)
			Puzzle currentNode = fringe.getLowestCostPath();
			if (DEBUG) {
				System.out.println("Iteracje: "+ i++ + "\t Fringe: "+ fringe.size()
				+ "\t Czas: "+ (System.currentTimeMillis() - start)/1000 + " sekund"
				+ "\n=========================================================");
				System.out.println(currentNode.getStringRepresentation());
			}
			if (currentNode.isSolved())
				return result;
			//ZNAJDŹ ODLEGŁOŚĆ TEGO WĘZŁA DO PUNKTU POCZĄTKOWEGO
			int pokonanyDystans = fringe.get(currentNode).getDistance();
			//TERAZ ZNAJDŹ WSZYSTKICH SĄSIADÓW TEGO WĘZŁA
			List<Ruch> sąsiedzi = graph.getNeighboors(currentNode);
			//NASTEPNIE PRZELICZ ODLEGŁOŚCI DLA KAŻDEGO SĄSIADA I DODAJ DO FRINGE'A
			for (Ruch kierunek : sąsiedzi) {
				Puzzle węzeł = currentNode.move(kierunek);
				Predecessor p = fringe.get(węzeł);
				//JEŚLI JESZCZE NIGDY NIE LICZYLIŚMY ODLEGŁOŚCI DLA TEGO WĘZŁA WSTAW NIESKOŃCZONOŚĆ
				int staraOdległość = p==null ? Integer.MAX_VALUE : p.getDistance();
				int nowaOdległość = waga + pokonanyDystans;
				//SPRAWDŹ CZY NOWO OBLICZONA ODLEGŁOŚĆ NIE JEST LEPSZA OD TEJ POPRZEDNIEJ
				if (nowaOdległość < staraOdległość) {
					fringe.put(węzeł, nowaOdległość, currentNode, kierunek);
				}
			}
			//ODZNACZ WĘZEŁ JAKO ODWIEDZONY, ŻEBY NIE LICZYĆ PONOWNIE ODLEGŁOŚCI
			graph.setVisited(currentNode);
			//ZAPAMIĘTAJ PRZEBYTĄ ŚCIEŻKĄ
			result.add(fringe.get(currentNode).getKierunek());
		}
	}
}