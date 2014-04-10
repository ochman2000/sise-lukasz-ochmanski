package pl.lodz.p.sise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import pl.lodz.p.sise.exceptions.DuplicatelPuzzleException;
import pl.lodz.p.sise.exceptions.IllegalPuzzleException;
import pl.lodz.p.sise.exceptions.PuzzleFormatException;

public class Puzzle {
	private final int LICZBA_KLOCKOW = 16;
	private int[] plansza = new int[LICZBA_KLOCKOW];
	
	public Puzzle(int[] a) {
		
		Set<Integer> s = new HashSet<Integer>();
		for (int klocek : a) {
			try {
				if (klocek<0 || klocek>=LICZBA_KLOCKOW)
					throw new IllegalPuzzleException(klocek);
			} catch (IllegalPuzzleException e) {
				System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
				System.exit(1);
			}
			s.add(klocek);
		}
		try {
			if	(s.size()<a.length)
				throw new DuplicatelPuzzleException(a.length-s.size());
			if (s.size()!=LICZBA_KLOCKOW)
				throw new PuzzleFormatException(s.size());
		} catch (PuzzleFormatException|DuplicatelPuzzleException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
		this.plansza = a;
	}
	
	public String getStringRepresentationi() {
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
	
	public boolean move(Ruch kierunek) {
		if(this.isAllowed(kierunek)) {
			int index = getEmptyPuzzle();
			switch (kierunek) {
				case D: {
					int temp = plansza[index];
					plansza[index] = plansza[index-4];
					plansza[index-4]=temp;
				}
				case G: {
					int temp = plansza[index];
					plansza[index] = plansza[index-4];
					plansza[index-4]=temp;
				}
				case L: {
					int temp = plansza[index];
					plansza[index] = plansza[index-4];
					plansza[index-4]=temp;
				}
				case P: {
					int temp = plansza[index];
					plansza[index] = plansza[index-4];
					plansza[index-4]=temp;
				}
			}
			return true;
		}
		else
			return false;
			
		
	}
}
