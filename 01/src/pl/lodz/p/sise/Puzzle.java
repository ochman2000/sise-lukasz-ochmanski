package pl.lodz.p.sise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import pl.lodz.p.sise.exceptions.DuplicatelPuzzleException;
import pl.lodz.p.sise.exceptions.IllegalPuzzleException;
import pl.lodz.p.sise.exceptions.PuzzleFormatException;

public class Puzzle {
	/**
	 * Jak liczba klocków jest inna niż 4,8,16,25 to będzie problem!
	 */
	private final int LICZBA_KLOCKOW = 16;
	private int[] plansza = new int[LICZBA_KLOCKOW];
	
	public Puzzle(int[] a) throws IllegalPuzzleException,
			DuplicatelPuzzleException, PuzzleFormatException {
		
		Set<Integer> s = new HashSet<Integer>();
		for (int klocek : a) {
			if (klocek < 0 || klocek >= LICZBA_KLOCKOW)
				throw new IllegalPuzzleException(klocek);
			s.add(klocek);
		}
		if (s.size() < a.length)
			throw new DuplicatelPuzzleException(a.length - s.size());
		if (s.size() != LICZBA_KLOCKOW)
			throw new PuzzleFormatException(s.size());
		this.plansza = a;
	}
	
	public String getStringRepresentation() {
		String ret="";
		String a,b,c,d;	a=b=c=d="";
		for (int i=0; i<16; i+=4) {
			a = (plansza[i]<10)   ? "  "+plansza[i] : " "+plansza[i];
			b = (plansza[i+1]<10) ? "  "+plansza[i+1] : " "+plansza[i+1];
			c = (plansza[i+2]<10) ? "  "+plansza[i+2] : " "+plansza[i+2];
			d = (plansza[i+3]<10) ? "  "+plansza[i+3] : " "+plansza[i+3];
			ret = ret+a+b+c+d+"\n";
		}
		return ret;
	}
	
	public String toString() {
		return Arrays.toString(this.plansza);
	}
	
	public boolean isAllowed(Ruch kierunek) {
		int e = getEmptyPuzzle();
		if (e==12 || e==13 || e==14 || e==15)
			if (kierunek==Ruch.G) return false;
		if (e==0 || e==1 || e==2 || e==3)
			if (kierunek==Ruch.D) return false;
		if (e==3 || e==7 || e==11 || e==15)
			if (kierunek==Ruch.L) return false;
		if (e==0 || e==4 || e==8 || e==12)
			if (kierunek==Ruch.P) return false;
		return true;
	}
	
	private int getEmptyPuzzle() {
		for (int i=0; i<this.plansza.length; i++) {
			if (this.plansza[i]==0) return i;
		}
		return -1;
	}
	
	public Puzzle move(Ruch kierunek) {
		int kolumny = (int) Math.sqrt(LICZBA_KLOCKOW);
		Puzzle p = copy();
		if(p.isAllowed(kierunek)) {
			int index = p.getEmptyPuzzle();
			switch (kierunek) {
				case D: {
					int temp = p.plansza[index];
					p.plansza[index] = p.plansza[index-kolumny];
					p.plansza[index-kolumny]=temp;
					break;
				}
				case G: {
					int temp = p.plansza[index];
					p.plansza[index] = p.plansza[index+kolumny];
					p.plansza[index+kolumny]=temp;
					break;
				}
				case L: {
					int temp = p.plansza[index];
					p.plansza[index] = p.plansza[index+1];
					p.plansza[index+1]=temp;
					break;
				}
				case P: {
					int temp = p.plansza[index];
					p.plansza[index] = p.plansza[index-1];
					p.plansza[index-1]=temp;
					break;
				}
			}
			return p;
		}
		else
			return null;	
	}
	
	public boolean isSolved() {
		int[] solution = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		return Arrays.equals(solution, this.plansza);	
	}
	
	public Puzzle copy() {
		int[] a  = new int[LICZBA_KLOCKOW];
		for (int i=0; i<LICZBA_KLOCKOW; i++){
			a[i]=this.plansza[i];
		}
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()
					+ "\nDziałanie programu przerwane.");
			System.exit(1);
		}
		return p;
	}
	
	
	public int[] getUkładKlocków() {
		return plansza;
	}

	@Override 
	public boolean equals (Object object) {
		boolean result = false;
	    if (object == null || object.getClass() != getClass()) {
	        result = false;
	    } else {
	        Puzzle puzzle = (Puzzle) object;
	        if (Arrays.equals(this.plansza, puzzle.plansza)) {
	            result = true;
	        }
	    }
	    return result;
	}
	
	/**
	 * Zlicza ilość klocków, które nie są na swoim miejsu.
	 * @return
	 */
	public int getHammingDistance() {
		int hamming =0;
		for (int i=0; i<LICZBA_KLOCKOW-1; i++) {
			if (this.plansza[i]!=i+1)
				hamming++;
		}
		if (this.plansza[LICZBA_KLOCKOW-1]!=0)
			hamming++;
		return hamming;
	}
	
	/**
	 * Zlicz odległość taksówkową od pustego klocka do jego docelowej pozycji.
	 * Odległość taksówkowa jest równa sumie współrzędnych w układzie kartezjańskim.
	 * @return
	 */
	public int getManhattanDistance(){
		return getManhattanDistance(getEmptyPuzzle(), LICZBA_KLOCKOW-1);
	}
	private int getManhattanDistance(int index, int destination) {
		int x = Math.abs(getColumn(destination)-getColumn(index));
		int y = Math.abs(getRow(destination)-getRow(index));
		return x+y;
	}
	
	/**
	 * Zlicza sumę odległości taksówkowych dla wszystkich klocków.
	 */
	public int getTotalManhattanDistances() {
		int sum=0;
		for (int i=0; i<LICZBA_KLOCKOW; i++) {
			int destination;
			if (this.plansza[i]==0)
				destination = 15;
			else
				destination = this.plansza[i]-1;
			sum += getManhattanDistance(i, destination);
		}
		return sum;
	}
	
	private int getRow(int y) {
		return y / (int)Math.sqrt(LICZBA_KLOCKOW);
	}
	
	private int getColumn(int x) {
		return x % (int)Math.sqrt(LICZBA_KLOCKOW);
	}
}
