package pl.lodz.p.sise.structure;

import java.util.Comparator;

import pl.lodz.p.sise.Puzzle;

public class PuzzleComparator implements Comparator<Puzzle>{

	@Override
	public int compare(Puzzle o1, Puzzle o2) {
		if (o1.getMinDistance()<o2.getMinDistance()) {
			return -1;
		}
		else if (o1.getMinDistance()>o2.getMinDistance()) {
			return 1;
		}
		else
			return 0;
	}
}
