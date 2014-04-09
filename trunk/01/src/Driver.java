import pl.lodz.p.sise.Puzzle;


public class Driver {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println(p);
	}
}
