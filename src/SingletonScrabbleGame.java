
import java.util.*;

/**
 * Created by harshita on 3/9/16.
 */
class SingletonScrabbleGame {

    private static SingletonScrabbleGame instance = null;
    private static List<Character> list;
    private static List<Character>  myScrabbleList = null;

    /**
     * Singleton constructor
     * Creates a new linkedlist
     * calls populatelist() to fiul the list with characters
     */
    private SingletonScrabbleGame() {
        list = new LinkedList();
        instance.populateList();

    }


    public static List<Character> getMyScrabbleList() {
        return myScrabbleList;
    }

    /**
     * Creates singleton instance
     *
     * @return Singleton instance
     */
    public static synchronized SingletonScrabbleGame getInstance(int noOfItems) {
        if (instance == null) {
            synchronized (SingletonScrabbleGame.class) {
                if (instance == null) {
                    instance = new SingletonScrabbleGame();
                }
            }
        }
        myScrabbleList=new ArrayList<>();
        myScrabbleList=instance.getScrabbleLetters(noOfItems);
        return instance;
    }

    /**
     * Populates List with characters initially
     *
     * @return void
     */
    private static void populateList() {
         Character[] letters={'A','B','C','D','E','F','G','H','I','K','J','L','A','B','C','D','E','F','E','F','G','H','I','K','J','L','A'};
         list.addAll(Arrays.asList(letters));

    }

    /**
     * @param noOfItems number of letters user wants
     * @return list of scrabble letters
     */
    private List getLettersFromOriginalList(int noOfItems) {
       // List<Character> myScrabbleList = new ArrayList<>();

        for (int index = 0; index < noOfItems; index++) {
            int itemIndex = new Random().nextInt(list.size());
            char item = (char) list.get(itemIndex);
            myScrabbleList.add(item);
            list.remove(itemIndex);
        }
        return myScrabbleList;
    }

    /**
     * public method to get letters
     * @param noOfItems number of letters user wants
     * @return list of scrabble letters for the user
     */
    private List getScrabbleLetters(int noOfItems) {

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Sorry there are no letters available!!!");

        } else if (noOfItems > list.size()) {
            throw new IllegalArgumentException("Sorry the required number of letters is greater than the number of letters available." +
                    " You may get only " + (list.size()) + " letters");
        }
        return getLettersFromOriginalList(noOfItems);
    }

    /**
     * displays the current scrabble list instance
     *
     * @return void
     */

    public void displayCurrentListInstance() {
        System.out.println();
        System.out.println("The Srabble instance list size is : " + list.size() + " with these letters: " + list);
    }

}
