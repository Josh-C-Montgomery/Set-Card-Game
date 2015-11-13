//AUTHOR: JOSHUA MONTGOMERY

import java.util.ArrayList;

public class SetGame {

	public static void main(String[] args) {
		Board b1 = new Board();
		int deckSize1 = 36;
		ArrayList<Card[]> sets = b1.playSet(deckSize1);
		b1.printSets(sets);
	}
}