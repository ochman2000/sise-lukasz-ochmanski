package pl.lodz.p.sise.structure;

import pl.lodz.p.sise.Puzzle;
import pl.lodz.p.sise.Ruch;

public class Predecessor {

	private int shortestDistance;
	private Puzzle vertex;
	private Ruch kierunek;
	
	public Predecessor(int distance, Puzzle vertex, Ruch kierunek) {
		this.setDistance(distance);
		this.setVertex(vertex);
		this.setKierunek(kierunek);
	}

	public int getDistance() {
		return shortestDistance;
	}

	public void setDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	/**
	 * Zwraca obiekt reprezentujący poprzedni wierzchołek.
	 * Czyli węzeł, przez który tutaj doszliśmy.
	 * Funkcja jest szczególnie potrzebna podczas odnajdywania najkrótszej ścieżki.
	 * Gdy zostanie znalezione rozwiązanie należy prześledzić wszystkich poprzedników,
	 * i zatrzymać się na źródle.
	 * 
	 */
	public Puzzle getVertex() {
		return vertex;
	}

	public void setVertex(Puzzle vertex) {
		this.vertex = vertex;
	}

	public Ruch getKierunek() {
		return kierunek;
	}

	public void setKierunek(Ruch kierunek) {
		this.kierunek = kierunek;
	}
	
	public String toString() {
		String s = this.getVertex()==null ? "[brak poprzednika]" : this.getVertex().toString();
		s +=" odległość: "+ this.getDistance()
			+" ruch: "+this.getKierunek();
		return s;
	}
}
