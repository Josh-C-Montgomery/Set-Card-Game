//AUTHOR: JOSHUA MONTGOMERY

import java.util.Random;

public class Card {

	//vars
	String color;
	String shape;
	String shading;
	String number;

	//constructor
	public Card() {
		genCard();
	}

	//creates cards with random qualities
	private void genCard() {
		//declare variables
		int randomInt;

		//initialize variables
		String[] colors = {"red", "green", "purple"};
		String[] shapes = {"diamond", "squiggle", "oval"};
		String[] shadings = {"solid", "empty", "striped"};
		String[] numbers = {"one", "two", "three"};
		Random randNumGen = new Random();

		// color
		randomInt = randNumGen.nextInt(3);
		set(randomInt, colors, "color");

		// shape
		randomInt = randNumGen.nextInt(3);
		set(randomInt, shapes, "shape");

		//shading
		randomInt = randNumGen.nextInt(3);
		set(randomInt, shadings, "shading");

		//number
		randomInt = randNumGen.nextInt(3);
		set(randomInt, numbers, "number");
	
	}

	//sets random qualities
	private void set(int rand, String[] a, String type) {

		//color
		if (type.equals("color")) {
			switch (rand) {
				case 0: color = a[0];
					break;
				case 1: color = a[1];
					break;
				case 2: color = a[2];
					break;
			}
		//shape
		} else if (type.equals("shape")) {
			switch (rand) {
				case 0: shape = a[0];
					break;
				case 1: shape = a[1];
					break;
				case 2: shape = a[2];
					break;
			}
		//shading
		} else if (type.equals("shading")) {
			switch (rand) {
				case 0: shading = a[0];
					break;
				case 1: shading = a[1];
					break;
				case 2: shading = a[2];
					break;
			}
		//number
		} else if (type.equals("number")) {
			switch (rand) {
				case 0: number = a[0];
					break;
				case 1: number = a[1];
					break;
				case 2: number = a[2];
					break;
			}
		}
	}
}