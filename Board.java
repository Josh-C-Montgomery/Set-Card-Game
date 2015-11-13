//AUTHOR: JOSHUA MONTGOMERY

import java.util.ArrayList;

public class Board {

	private int drawCards(int desiredNum, ArrayList<Card> aBoard, int aDeckSize) {
		//adds desiredNum of cards to boardList
		Card c;
		for (int i = 0; i < desiredNum; i++) {
			c = new Card();
			aBoard.add(c);
			aDeckSize--;
		}
		return aDeckSize;
	}

	private boolean AllOrNothing(Card c1, Card c2, Card c3, String type) {
		switch (type) {
			//color
			case "color": 
				if (!((c1.color == c2.color && c2.color == c3.color) || (c1.color != c2.color && c2.color != c3.color && c1.color != c3.color)))
					return false;
				break;

			//shape
			case "shape":
				if (!((c1.shape == c2.shape && c2.shape == c3.shape) || (c1.shape != c2.shape && c2.shape != c3.shape && c1.shape != c3.shape))) 
					return false;
				break;

			//shading
			case "shading":
				if (!((c1.shading == c2.shading && c2.shading == c3.shading) || (c1.shading != c2.shading && c2.shading != c3.shading && c1.shading != c3.shading)))
					return false;
				break;

			//number
			case "number":
				if (!((c1.number == c2.number && c2.number == c3.number) || (c1.number != c2.number && c2.number != c3.number && c1.number != c3.number)))
					return false;
				break;
		}
		//if all or nothing
		return true;
	} 

	private boolean isSet(Card c1, Card c2, Card c3) {
		//parse colors, if not all equal or not all different ret false
		if (!AllOrNothing(c1, c2, c3, "color"))
			return false;

		//parse shapes, if not all equal or not all different ret false
		if (!AllOrNothing(c1, c2, c3, "shape"))	
			return false;

		//parse shadings, if not all equal or not all different ret false
		if (!AllOrNothing(c1, c2, c3, "shading"))	
			return false;

		//parse numbers, if not all equal or not all different ret false
		if (!AllOrNothing(c1, c2, c3, "number"))	
			return false;
		
		//if is set, ret true
		return true;
	}

	private Card[] findSet(ArrayList<Card> aBoard) {
		//declares variables
    int i, j, k;
    Card c1, c2, c3;

    //initializes variables
    int len = aBoard.size();

    /* 
    * checks all combinations for sets
    * if set is found removes set from board and returns set
    */
    for (i = 0; i < len - 2; i++)
    {
      for (j = i + 1; j < len - 1; j++)
      {
        for (k = j + 1; k < len; k++) {
          if (isSet(aBoard.get(i), aBoard.get(j), aBoard.get(k))) {
          	c1 = aBoard.get(i);
          	c2 = aBoard.get(j); 
          	c3 = aBoard.get(k);
          	aBoard.remove(i);
          	aBoard.remove(j-1);
          	aBoard.remove(k-2);
          	aBoard.trimToSize();

            Card[] set = {c1, c2, c3};
           	return set;
          }
        }
      }
    }  	
		return null;
	}

	//prints sizes of deck, sets (in cards), and cards on board
	public void printSizes(int aDeckSize, ArrayList<Card[]> aSetOfSets, ArrayList<Card> aBoard) {
		System.out.print("deck size: "+aDeckSize);
		System.out.print(" setOfSets size: "+aSetOfSets.size()*3);
		System.out.println(" board size: "+aBoard.size());
	}

	//prints out set of sets
	public void printSets(ArrayList<Card[]> aSetOfSets) {
		System.out.println("\n\nPRINTING OUT SET OF SETS:");

		for (int i = 0; i < aSetOfSets.size(); i++) {
			System.out.println("\nSet "+i+": ");
			for (int j = 0; j < aSetOfSets.get(i).length; j++) {
				System.out.print("index: "+j);
				System.out.print(" color: "+aSetOfSets.get(i)[j].color);
				System.out.print(" shape: "+aSetOfSets.get(i)[j].shape);
				System.out.print(" shading: "+aSetOfSets.get(i)[j].shading);
				System.out.print(" number: "+aSetOfSets.get(i)[j].number+"\n");
			}
		}

		System.out.println("\nFINISHED PRINTING OUT SET OF SETS:");
	}	

	//prints cards on board
	public void printBoard(ArrayList<Card> aBoard) {
		System.out.println("\n\nPRINTING OUT CARDS ON BOARD");

		for (int i = 0; i < aBoard.size(); i++) {
			System.out.print("Card "+i);
			System.out.print(" color: "+aBoard.get(i).color);
			System.out.print(" shape: "+aBoard.get(i).shape);
			System.out.print(" shading: "+aBoard.get(i).shading);
			System.out.print(" number: "+aBoard.get(i).number+"\n");
		}

		System.out.println("\nFINISHED PRINTING OUT CARDS ON BOARD");

	}

	public ArrayList<Card[]> playSet(int aDeckSize) {
		System.out.println("\nTHE GAME HAS STARTED!");
		//declare variables
		int deckSize;
		Card[] set;
		ArrayList<Card[]> setOfSets;
		ArrayList<Card> boardList;

		//create board
		deckSize = aDeckSize;
		boardList = new ArrayList<Card>();
		deckSize = drawCards(12,boardList, deckSize);
		setOfSets = new ArrayList<Card[]>();

		//initial values
		System.out.println("\nINITIAL SIZES");
		printSizes(deckSize, setOfSets, boardList);
		//printBoard(boardList);
		//printSets(setOfSets);
		
		//find sets, remove them from board, add to list, & add new cards until limit reached
		System.out.println("\nPROCESS SIZES");
		while (deckSize != 0) {
			set = findSet(boardList);

			if (set != null) {
				//DEBUG: System.out.println("Add set to setOfSets");
				setOfSets.add(set);
				printSizes(deckSize, setOfSets, boardList);
			} else {
				//DEBUG: System.out.println("Draw 3");
				deckSize = drawCards(3, boardList, deckSize);
			}
		}
		
		//final values
		System.out.println("\nFINAL SIZES");
		printSizes(deckSize, setOfSets, boardList);
		//printBoard(boardList);
		//printSets(setOfSets);
		
		//return set list
		System.out.println("\nTHE GAME HAS FINISHED WITH "+setOfSets.size()+" SETS!");
		return setOfSets;
	}
}