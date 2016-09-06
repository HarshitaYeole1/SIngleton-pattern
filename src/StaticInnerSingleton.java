import sun.security.jca.GetInstance;

import java.util.*;

/**
 * Created by harshita on 6/9/16.
 */
class StaticInnerSingleton {
    private static SingletonScrabbleGame instance = null;
    private static List<Character> list;
    private  List<Character> myScrabbleList = null;

    private StaticInnerSingleton() {
        list = new LinkedList();
        populateList();
    }

    public List<Character> getMyScrabbleList() {
        return myScrabbleList;
    }

    private static class SingletonHelper {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();

    }

    public static StaticInnerSingleton getInstance(int noOfItems) {
        SingletonHelper.INSTANCE.myScrabbleList = new ArrayList<>();
        SingletonHelper.INSTANCE.myScrabbleList = SingletonHelper.INSTANCE.getScrabbleLetters(noOfItems);
        return SingletonHelper.INSTANCE;
    }


    /**
     * Populates List with characters initially
     *
     * @return void
     */
    private static void populateList() {
        Character[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'J', 'L', 'A', 'B', 'C', 'D', 'E', 'F', 'E', 'F', 'G', 'H', 'I', 'K', 'J', 'L', 'A'};
        list.addAll(Arrays.asList(letters));

    }

    /**
     * @param noOfItems number of letters user wants
     * @return list of scrabble letters
     */
    private List<Character> getLettersFromOriginalList(int noOfItems) {

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
     *
     * @param noOfItems number of letters user wants
     * @return list of scrabble letters for the user
     */
    private List<Character> getScrabbleLetters(int noOfItems) {

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Sorry there are no letters available!!!");

        } else if (noOfItems > list.size()) {
            throw new IllegalArgumentException("Sorry the required number of letters is greater than the number of letters available." +
                    " You may get only " + (list.size()) + " letters");
        }
        return getLettersFromOriginalList(noOfItems);
    }

}

