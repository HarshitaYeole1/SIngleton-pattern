
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by harshita on 3/9/16.
 */
class SingletonScrabbleGame {


    private static SingletonScrabbleGame instance = null;
    private static List<Character> list;

    /**
     * Singleton constructor
     */
    private SingletonScrabbleGame() {
        list = new LinkedList();
        instance.populateList();
    }

    /**
     * Creates singleton instance
     * @return Singleton instance
     */
    public static synchronized SingletonScrabbleGame getInstance() {
        if (instance == null) {
            synchronized (SingletonScrabbleGame.class) {
                if (instance == null) {
                    instance = new SingletonScrabbleGame();
                }
            }
        }

        return instance;
    }

    /**
     *  Populates List with characters initially
     *  @return void
     */
    private static void populateList() {
        for (char c = 'A'; c <= 'Z'; c++) {
            list.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            list.add(c);
        }

    }

    /**
     *
     * @param noOfItems number of letters user wants
     * @return list of scrabble letters
     */
    private List getLettersFromOriginalList(int noOfItems) {
        List myScrabbleList = new ArrayList();
        for (int index = 0; index < noOfItems; index++) {
            int itemIndex = new Random().nextInt(list.size());
            char item = (char) list.get(itemIndex);
            myScrabbleList.add(item);
            list.remove(itemIndex);
        }
        System.out.println();
        System.out.println("Congratulations!!! You got these letters to play scrabble: ");
        System.out.println(myScrabbleList);
        return myScrabbleList;
    }

    /**
     *
     * @param noOfItems number of letters user wants
     * @return list of scrabble letters for the user
     */
    public List getScrabbleLetters(int noOfItems) {
        List myScrabbleList = new ArrayList();
        try {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Sorry the list is empty!!!");

            } else if (noOfItems > list.size()) {
                System.out.println("Sorry the required number of items is greater than the number of items available in the list." +
                        " You may get only " + (list.size()) + " items");

                myScrabbleList = getLettersFromOriginalList(list.size());
            } else {
                myScrabbleList = getLettersFromOriginalList(noOfItems);

            }
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
        return myScrabbleList;
    }

    /**
     * displays the current scrabble list instance
     * @return void
     */
    public void displayCurrentListInstance() {
        System.out.println();
        System.out.println("The Srabble instance list size is : " + list.size() + " with these letters: "+list);
    }

}
