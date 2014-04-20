package pl.lodz.p.sise;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pl.lodz.p.sise.exception.DuplicatelPuzzleException;
import pl.lodz.p.sise.exception.IllegalPuzzleException;
import pl.lodz.p.sise.exception.PuzzleFormatException;
import pl.lodz.p.sise.structure.Fringe;

public class PuzzleTest {

	@Test
	public void test01() {
		int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
////		System.out.println(p.getStringRepresentation());
////		System.out.println("Dół: "+p.isAllowed(Ruch.D));
////		System.out.println("Góra: "+p.isAllowed(Ruch.G));
////		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
////		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==false
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==false;
		assertTrue(condition);
	}
	
	@Test
	public void test02() {
		int[] a = {1,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
////		System.out.println(p.getStringRepresentation());
////		System.out.println("Dół: "+p.isAllowed(Ruch.D));
////		System.out.println("Góra: "+p.isAllowed(Ruch.G));
////		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
////		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==false
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test03() {
		int[] a = {1,2,0,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==false
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test04() {
		int[] a = {1,2,3,0,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==false
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==false
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test05() {
		int[] a = {1,2,3,4,0,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==false;
		assertTrue(condition);
	}
	
	@Test
	public void test06() {
		int[] a = {1,2,3,4,5,0,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test07() {
		int[] a = {1,2,3,4,5,6,0,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test08() {
		int[] a = {1,2,3,4,5,6,7,0,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==false
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test09() {
		int[] a = {1,2,3,4,5,6,7,8,0,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==false;
		assertTrue(condition);
	}
	
	@Test
	public void test10() {
		int[] a = {1,2,3,4,5,6,7,8,9,0,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test11() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test12() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,0,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==true
				&& p.isAllowed(Ruch.L)==false
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test13() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,0,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==false
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==false;
		assertTrue(condition);
	}
	
	@Test
	public void test14() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,0,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==false
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test15() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,0,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==false
				&& p.isAllowed(Ruch.L)==true
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	@Test
	public void test16() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
//		System.out.println("Dół: "+p.isAllowed(Ruch.D));
//		System.out.println("Góra: "+p.isAllowed(Ruch.G));
//		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
//		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
		boolean condition = p.isAllowed(Ruch.D)==true
				&& p.isAllowed(Ruch.G)==false
				&& p.isAllowed(Ruch.L)==false
				&& p.isAllowed(Ruch.P)==true;
		assertTrue(condition);
	}
	
	/**
	 * Dwa razy wstawiłem 0.
	 * 
	 * @throws IllegalPuzzleException
	 * @throws DuplicatelPuzzleException
	 * @throws PuzzleFormatException
	 */
	@Test(expected = DuplicatelPuzzleException.class)
	public void test17() throws IllegalPuzzleException, DuplicatelPuzzleException, PuzzleFormatException {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0,11,12,13,14,15,0};
		new Puzzle(a);
	}
	
	/**
	 * Dwa razy wstawiłem zero.
	 * Układanka jest za krótka.
	 * 
	 * @throws IllegalPuzzleException
	 * @throws DuplicatelPuzzleException
	 * @throws PuzzleFormatException
	 */
	@Test(expected = DuplicatelPuzzleException.class)
	public void test18() throws IllegalPuzzleException, DuplicatelPuzzleException, PuzzleFormatException {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0,11,0};
		new Puzzle(a);
	}
	
	/**
	 * Układanka jest za krótka.
	 * 
	 * @throws IllegalPuzzleException
	 * @throws DuplicatelPuzzleException
	 * @throws PuzzleFormatException
	 */
	@Test(expected = PuzzleFormatException.class)
	public void test19() throws IllegalPuzzleException, DuplicatelPuzzleException, PuzzleFormatException {
		int[] a = {1,2,3,4,5,6,7,8,9,10,0};
		new Puzzle(a);
	}
	
	/**
	 * Wstawiłem element z poza zakresu: 28
	 * 
	 * @throws IllegalPuzzleException
	 * @throws DuplicatelPuzzleException
	 * @throws PuzzleFormatException
	 */
	@Test(expected = IllegalPuzzleException.class)
	public void test20() throws IllegalPuzzleException, DuplicatelPuzzleException, PuzzleFormatException {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,28};
		new Puzzle(a);
	}
	
	/**
	 * Układanka jest za długa.
	 * 
	 * @throws IllegalPuzzleException
	 * @throws DuplicatelPuzzleException
	 * @throws PuzzleFormatException
	 */
	@Test(expected = IllegalPuzzleException.class)
	public void test21() throws IllegalPuzzleException, DuplicatelPuzzleException, PuzzleFormatException {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		new Puzzle(a);
	}
	
	@Test
	public void test30() {
		int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		p = p.move(Ruch.G);
		a = p.getUkładKlocków();
//		System.out.println(p.getStringRepresentation());
		int[] b = {4,1,2,3,0,5,6,7,8,9,10,11,12,13,14,15};
		assertTrue(Arrays.toString(a).equals(Arrays.toString(b)));
	}
	
	@Test
	public void test31() {
		int[] a = {4,1,2,3,0,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		p = p.move(Ruch.D);
		a = p.getUkładKlocków();
//		System.out.println(p.getStringRepresentation());
		int[] b = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		assertTrue(Arrays.toString(a).equals(Arrays.toString(b)));
	}
	
	@Test
	public void test32() {
		int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		p = p.move(Ruch.L);
		a = p.getUkładKlocków();
//		System.out.println(p.getStringRepresentation());
		int[] b = {1,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		assertTrue(Arrays.toString(a).equals(Arrays.toString(b)));
	}
	
	@Test
	public void test33() {
		int[] a = {1,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		p = p.move(Ruch.P);
		a = p.getUkładKlocków();
//		System.out.println(p.getStringRepresentation());
		int[] b = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		assertTrue(Arrays.toString(a).equals(Arrays.toString(b)));
	}
	
	@Test
	public void test34() {
		int[] a = {1,2,3,4,5,0,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		p = p.move(Ruch.G);
		a = p.getUkładKlocków();
//		System.out.println(p.getStringRepresentation());
		int[] b = {1,2,3,4,5,9,6,7,8,0,10,11,12,13,14,15};
		assertTrue(Arrays.toString(a).equals(Arrays.toString(b)));
	}
	
	@Test
	public void test35() {
		int[] a = {1,2,3,4,5,0,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		p = p.move(Ruch.D);
		a = p.getUkładKlocków();
//		System.out.println(p.getStringRepresentation());
		int[] b = {1,0,3,4,5,2,6,7,8,9,10,11,12,13,14,15};
		assertTrue(Arrays.toString(a).equals(Arrays.toString(b)));
	}
	
	@Test
	public void test36() {
		int[] a = {1,2,3,4,5,0,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		int h = p.getManhattanDistance();
		assertTrue(""+h, 4==h);
	}
	
	@Test
	public void test37() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		int h = p.getManhattanDistance();
		assertTrue(""+h, 0==h);
	}
	
	@Test
	public void test38() {
		int[] a = {1,2,3,4,5,0,6,7,8,9,10,11,12,13,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		int h = p.getHammingDistance();
		assertTrue(""+h, 11==h);
	}
	
	@Test
	public void test39() {
		int[] a = {1,2,3,4,5,6,7,8,9,11,10,12,13,14,0,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		int h = p.getHammingDistance();
		assertTrue(""+h, 4==h);
	}
	
	@Test
	public void test40() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,0,14,15};
		Puzzle p = null;
		try {
			p = new Puzzle(a);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
//		System.out.println(p.getStringRepresentation());
		int h = p.getTotalManhattanDistances();
		assertTrue(""+h, 4==h);
	}
	
	@Test
	public void test41() {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,0,14,15};
		int[] b = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		Puzzle p = null;
		Puzzle q = null;
		try {
			p = new Puzzle(a);
			q = new Puzzle(b);
		} catch (IllegalPuzzleException | DuplicatelPuzzleException
				| PuzzleFormatException e) {
			System.err.println(e.getMessage()+"\nDziałanie programu przerwane.");
			System.exit(1);
		}
		Fringe fringe = new Fringe();
		fringe.put(p);
		Puzzle z = fringe.get(q);
		assertTrue(z==null);
	}
	
	
}
