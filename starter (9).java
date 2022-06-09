import pkg.*;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;


class starter {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("wordle.txt"));
		Scanner input = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Character> playerGuess = new ArrayList<>();
		
		while(scanner.hasNext()) {
			words.add(scanner.nextLine());
		}
		int x = (int)(Math.random()*words.size());
		String word = words.get(x);
		int wrongCount = 0;
		
		while(true) {
			HangedMan(wrongCount);
			if(wrongCount >= 5) {
				System.out.println("U lostttt. Ur baddddd");
				break;
			}
			WordState(word, playerGuess);
			if (!getPlayerGuess(input, word, playerGuess)) {
				wrongCount++;
			}
			if(WordState(word, playerGuess)) {
				System.out.println("You got lucky -_-");
				break;
			}
			System.out.println("Enter your guess for the word.");
			String wordg = input.nextLine();
			if(wordg.equals(word)) {
				System.out.println("You got lucky -_-");
				break;
			} else {
				System.out.println(wordle(wordg, word));
			}
			
		}
		System.out.println("The word was " + word);
		
	}
	public static boolean WordState(String word, ArrayList<Character> playerGuess) {
		int correctCount = 0;
		for(int i = 0; i < word.length(); i++) {
			if(playerGuess.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
				correctCount++;
			}
			else {
				System.out.print("-");
			}
		}
		System.out.println();
		return(word.length() == correctCount);
	}
	public static boolean getPlayerGuess(Scanner input, String word, ArrayList<Character>playerGuess) {
		System.out.println("Enter a letter if you dare");
		String letterGuess = input.nextLine();
		playerGuess.add(letterGuess.charAt(0));
		return word.contains(letterGuess);
	}
	public static void HangedMan(int wrongCount) {
			System.out.println(" -------");
			System.out.println(" |     |");
			if(wrongCount >= 1) {
				System.out.println(" 0");
			}
			if(wrongCount >= 2) {
				System.out.print("\\ ");
				if(wrongCount >= 3) {
					System.out.println(" /");
				} else {
					System.out.println("");
				}
			}
			if(wrongCount >= 4) {
				System.out.println(" |");
			}
			if(wrongCount >= 5) {
				System.out.println("/  \\");
			} else {
					System.out.println("");
			}
			System.out.println("");
			System.out.println("");
	}
	public static String wordle(String input, String word) {
		String result = "";
		for(int i = 0; i < word.length(); i++) {
			char in = input.charAt(i);
			if(in == word.charAt(i)) {
				result = result + " letter " + in + " is in the right place.";
			} else {
				for(int j = 0; j < word.length(); j++) {
					if(in == word.charAt(j)) {
						result = result + " letter " + in + " is in the wrong place, HOWEVER it is in the word.";
					}
				}
			}
		}
		return result;
	}
}
