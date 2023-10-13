import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

//this class is used to represent the word people are trying to solve.
public class WordleObject {
    private String[] letters = new String[5]; // size 5
    private ArrayList<String> alphabet; // everytime a user guesses a letter, take out a letter
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";

    public WordleObject(String[] letters) {
        this.letters = letters;
        alphabet = new ArrayList<String>();
        String[] x = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z", };
        for (String temp : x)
            alphabet.add(temp);
    }

    
    public static void startGame(ArrayList<String> wordList) {
        String word = WordleMain.getRandomWord(wordList);
        String guess = "";
        //System.out.println(word);
        char[] wordle = word.toCharArray();

        Scanner pen = new Scanner(System.in);
        //  if (word.equals(pen)) {
        //      System.out.println(GREEN + guess);

        // }
        while (!(word.equals(guess))) {

            HashMap<Character, String> firstLetter = new HashMap<>();
            HashMap<Character, String> secondLetter = new HashMap<>();
            HashMap<Character, String> thirdLetter = new HashMap<>();
            HashMap<Character, String> fourthLetter = new HashMap<>();
            HashMap<Character, String> fifthLetter = new HashMap<>();

            System.out.println("Put in your guess! ");
            guess = pen.nextLine();
            while (guess.length() != 5) {
                if (guess.equals("Correct word please")) {
                    System.out.print(word);
                    break;
                }
                System.out.print("Guess must be five letters!");
                System.out.println(" Put in your guess! ");
                guess = pen.nextLine();
            }
            char[] guessArr = guess.toCharArray();
            
            if (word.equals(guess)) {
                 System.out.println(GREEN + guess);
                 System.out.println(WHITE);

                 break;
             }
            
            // for (int wordleIdx = 0; wordleIdx < 5; wordleIdx ++) {
            for (int guessIdx = 0; guessIdx < 5; guessIdx++) {
                int numOfLetters = 0;

                int idx = word.indexOf(guessArr[guessIdx]);
                for (int i = 0; i < word.length(); i ++) {
                    for (int j = 0; j < guess.length(); j++) {
                        if (word.substring(i,i+1).equals(guess.substring(j,j+1))) {
                            numOfLetters++;
                        }
                    }
                }

                if (numOfLetters > 1) {
                    if (guessIdx > idx) {
                        idx = word.lastIndexOf(guess.substring(guessIdx, guessIdx+1));
                    }
                }
                 if (idx != -1) {
                    if (wordle[idx] == guessArr[guessIdx]) {

                        if (guessIdx == idx) {
                            switch (guessIdx) {
                                case 0:
                                    firstLetter.put(guessArr[guessIdx], GREEN);
                                    break;
                                case 1:
                                    secondLetter.put(guessArr[guessIdx], GREEN);
                                    break;
                                case 2:
                                    thirdLetter.put(guessArr[guessIdx], GREEN);
                                    break;
                                case 3:
                                    fourthLetter.put(guessArr[guessIdx], GREEN);
                                    break;
                                case 4:
                                    fifthLetter.put(guessArr[guessIdx], GREEN);
                                    break;

                            }
                        } else {
                            switch (guessIdx) {
                                case 0:
                                    firstLetter.put(guessArr[guessIdx], YELLOW);
                                    break;
                                case 1:
                                    secondLetter.put(guessArr[guessIdx], YELLOW);
                                    break;
                                case 2:
                                    thirdLetter.put(guessArr[guessIdx], YELLOW);
                                    break;
                                case 3:
                                    fourthLetter.put(guessArr[guessIdx], YELLOW);
                                    break;
                                case 4:
                                    fifthLetter.put(guessArr[guessIdx], YELLOW);
                                    break;

                            }
                        }
                    }
                } else {
                    switch (guessIdx) {
                        case 0:
                            firstLetter.put(guessArr[guessIdx], WHITE);
                            break;
                        case 1:
                            secondLetter.put(guessArr[guessIdx], WHITE);
                            break;
                        case 2:
                            thirdLetter.put(guessArr[guessIdx], WHITE);
                            break;
                        case 3:
                            fourthLetter.put(guessArr[guessIdx], WHITE);
                            break;
                        case 4:
                            fifthLetter.put(guessArr[guessIdx], WHITE);
                            break;

                    }
                }
            }
            
            System.out.print(firstLetter.get(guessArr[0]) + guess.substring(0, 1));
            System.out.print(secondLetter.get(guessArr[1]) + guess.substring(1, 2));
            System.out.print(thirdLetter.get(guessArr[2]) + guess.substring(2, 3));
            System.out.print(fourthLetter.get(guessArr[3]) + guess.substring(3, 4));
            System.out.print(fifthLetter.get(guessArr[4]) + guess.substring(4, 5));
            System.out.println(WHITE);
        }
        System.out.println("You've got it!");
    }
}