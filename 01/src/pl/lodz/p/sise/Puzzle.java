package pl.lodz.p.sise;

import java.util.Arrays;

public class Puzzle {
	
	int[] plansza = new int[16];
	
	public Puzzle(int[] a) {
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
		if (e==0 || e==1 || e==2 || e==3)
			if (kierunek==Ruch.G) return false;
		if (e==12 || e==13 || e==14 || e==15)
			if (kierunek==Ruch.D) return false;
		if (e==0 || e==4 || e==8 || e==12)
			if (kierunek==Ruch.L) return false;
		if (e==3 || e==7 || e==11 || e==15)
			if (kierunek==Ruch.P) return false;
		return true;
	}
	
	private int getEmptyPuzzle() {
		for (int i=0; i<this.plansza.length; i++) {
			if (this.plansza[i]==0) return i;
		}
		return -1;
	}
}
