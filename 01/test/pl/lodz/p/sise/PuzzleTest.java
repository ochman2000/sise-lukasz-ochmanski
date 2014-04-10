package pl.lodz.p.sise;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuzzleTest {

	@Test
	public void test01() {
		int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==false;
	}
	
	@Test
	public void test02() {
		int[] a = {1,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test03() {
		int[] a = {1,2,0,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test04() {
		int[] a = {1,2,3,0,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test05() {
		int[] a = {1,2,3,4,0,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test06() {
		int[] a = {1,2,3,4,5,0,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test07() {
		int[] a = {1,2,3,4,5,6,0,7,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test08() {
		int[] a = {1,2,3,4,5,6,7,0,8,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test09() {
		int[] a = {1,2,3,4,5,6,7,8,0,9,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test10() {
		int[] a = {1,2,3,4,5,6,7,8,9,0,10,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test11() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0,11,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test12() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,0,12,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test13() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,0,13,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test14() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,0,14,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test15() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,0,15};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test16() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}
	
	@Test
	public void test17() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0,11,12,13,14,15,0};
		Puzzle p = new Puzzle(a);
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
	}

}
