import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.ArrayList;
import java.util.Scanner;

public class WordleMain {

    public static String getRandomWord(ArrayList<String> list) {
        
        String randoWord  = list.get(((int)(Math.random() * (list.size()))));
        return randoWord;
    }
    
    public static void main(String[] args)
    {
        //this part of code will take all the words from the list and store it all in allWords
        ArrayList<String> allWords = new ArrayList<String>();
        String fileName = "";
        Scanner pen = new Scanner(System.in);
        System.out.println("Type in the name of your word list! The file must be located in the same folder as WordleMain.java and WordleObject.java! Ex. words.pdf");
        fileName = pen.nextLine();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                String[] splitData = data.split(" ");
                for (String i : splitData) {
                    allWords.add(i);
                }

/*                   __________
 *                  /          \
 *                 |       O    |________   "quack"
 *     __          |            |_______/
 *    /  \__________\          /
 *   |                         \
 *   |     (                    |
 *   \                          /
 *    \________________________/
 */

            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File was not recognized. Rerun program");
            e.printStackTrace();
        }

        
        
        WordleObject.startGame(allWords);

            
    }


}
