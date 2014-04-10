package pl.lodz.p.sise;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.lodz.p.sise.exceptions.DuplicatelPuzzleException;
import pl.lodz.p.sise.exceptions.IllegalPuzzleException;
import pl.lodz.p.sise.exceptions.PuzzleFormatException;

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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		System.out.println(p.getStringRepresentationi());
		System.out.println("Dół: "+p.isAllowed(Ruch.D));
		System.out.println("Góra: "+p.isAllowed(Ruch.G));
		System.out.println("Lewo: "+p.isAllowed(Ruch.L));
		System.out.println("Prawo: "+p.isAllowed(Ruch.P));
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
		assertTrue(true);
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
		assertTrue(true);
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
		assertTrue(true);
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
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		new Puzzle(a);
		assertTrue(true);
	}
}
