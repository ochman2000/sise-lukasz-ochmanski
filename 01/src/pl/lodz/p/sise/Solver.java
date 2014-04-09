package pl.lodz.p.sise;

public class Solver {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
}
