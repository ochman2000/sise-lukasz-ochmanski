package pl.lodz.p.sise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;

public class Puzzle implements Comparable<Puzzle> {
	/**
	 * Jak liczba klocków jest inna niż 4,8,16,25 to będzie problem!
	 */
	private final int LICZBA_KLOCKOW = 16;
	private int[] plansza = new int[LICZBA_KLOCKOW];
	private boolean visited;
	private Puzzle previous;
	private Ruch kierunek;
	private int minDistance;
	
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
			throw new PuzzleFormatException(s.size(), LICZBA_KLOCKOW);
		this.plansza = a;
	}
	
	public String getStringRepresentation() {
		String ret="";
		int sideLen = (int) Math.sqrt(LICZBA_KLOCKOW);
		for (int i=0; i<LICZBA_KLOCKOW; i++) {
			if (i%sideLen==0 && i!=0) ret+="\n";
			ret += (plansza[i]<10) ? " "+plansza[i]+" " : plansza[i]+" ";
		}
		return ret;
	}

	public String toStringDetailed() {
		String s = Arrays.toString(this.getUkładKlocków());
		s+= this.getPrevious()==null ? "[brak poprzednika]" : this.getPrevious().toString();
		s +=" odległość: "+ this.getMinDistance()
			+" ruch: "+this.getKierunek();
		return s;
	}
	public String toString() {
		return Arrays.toString(this.getUkładKlocków());
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
	public boolean equals(Object object) {
		return equals((Puzzle) object);
	}

	public boolean equals(Puzzle object) {
		boolean result = false;
	    if (object == null || object.getClass() != getClass()) {
	        result = false;
	    } else {
	        Puzzle puzzle = (Puzzle) object;
	        if (Arrays.equals(getUkładKlocków(), puzzle.plansza)) {
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
	
	/**
	 * Maksymalna liczba binów, do których trafią układanki to:
	 * 1*8^0 + 3*8^1 + 5*8^2 + 7*8^3 +  9*8^4 + 11*8^5 + 13*8^6 + 15*8^7 +
	 * 2*8^0 + 4*8^1 + 6*8^2 + 8*8^3 + 10*8^4 + 12*8^5 + 14*8^6 + 16*8^7
	 * =72 929 531 z 10 461 394 944 000 możliwych kombinacji.
	 * Niestety nie wiem jak policzyć, jakie jest prawdopodobieństwo wystąpienia kolizji,
	 * ale raczej na pewno nie jest możliwe, aby wpadły wszystkie do tego samego bina.
	 * Na pewno pierwsze osiem klocków nie wpadnie w to samo miejsce.
	 * Drugie osiem równiez nie może wpaść do tego samego bina.
	 * Jednak suma pierwszych ośmiu i drugich ośmiu może dać czasem taki sam numer.
	 */
	@SuppressWarnings("unused")
	public int hashCode() {
		if (LICZBA_KLOCKOW>16) {
			throw new UnsupportedClassVersionError("Jeśli chcesz, aby program działał"
					+ "poprawnie musisz napisać nową funkcję hashCode.");
		}
		int hashCode = 0;
		for (int i=0; i<LICZBA_KLOCKOW; i++) {
			int power = i%8;
			hashCode+=(this.plansza[i]+1)*Math.pow(8, power);
		}		
		return hashCode;
	}
	
	/**
	 * Zwraca listę dozwolonych ruchów.
	 * @return
	 */
	public List<Ruch> getNeighboors() {
		Ruch[] porządek = Ruch.values();
		return getNeighboors(porządek);
	}
	
	/**
	 * Zwraca listę dozwolonych ruchów, wśród podanych.
	 * Iteracja odbywa się w kolejności, w której występują w tablicy.
	 * @param order
	 * @return
	 */
	private List<Ruch> getNeighboors(Ruch[] order) {
		ArrayList<Ruch> sąsiedzi = new ArrayList<>();
		for (Ruch ruch : order) {
			if (this.isAllowed(ruch))
				sąsiedzi.add(ruch);
		}
		return sąsiedzi;
	}
	
	/**
	 * Zaznacza, że dany węzeł był już odwiedzony.
	 * @param node
	 */
	public void setVisited() {
		visited = true;
	}
	
	/**
	 * Sprawdza, czy podany węzeł był już odwiedzony.
	 * @param node
	 * @return
	 */
	public boolean wasVisited() {
		return visited;
	}
	
	public void setPrevious(Puzzle node) {
		this.previous = node;
	}

	public Puzzle getPrevious() {
		return previous;
	}

	public Ruch getKierunek() {
		return kierunek;
	}

	public void setKierunek(Ruch kierunek) {
		this.kierunek = kierunek;
	}

	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	@Override
	public int compareTo(Puzzle o) {
		if (o.getMinDistance()<this.getMinDistance()) {
			return -1;
		}
		else if (o.getMinDistance()>this.getMinDistance()) {
			return 1;
		}
		else
			return 0;
	}
}
