
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by harshita on 3/9/16.
 */
public class SingletonScrabbleGameTest {


    SingletonScrabbleGame s1;
    SingletonScrabbleGame s2;
    SingletonScrabbleGame s3;
    List<Character> myScrabbleList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {


        s3=SingletonScrabbleGame.getInstance(10);        //number of items directly from the instnce

        //s1=SingletonScrabbleGame.getInstance();
        //s2=SingletonScrabbleGame.getInstance();
        //s3=SingletonScrabbleGame.getInstance();
        //s1.getScrabbleLetters(6);
        //s1.getScrabbleLetters(16);          // to check empty list exception
        //s1.getScrabbleLetters(20);         //to check asked items greater than list size
        //System.out.println();
    }

    @Test
    public void itShould_CheckIf_SameSingletonInstance_IsReturned_EachTimeGetInstanceIsCalled() throws Exception {

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        assertEquals(s2, s3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShould_ThrowIllegalArgumentException_Because_ListIsEmpty() throws Exception {
        //s2.getScrabbleLetters(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShould_ThrowIllegalArgumentException_Because_NumberOfItemsAsked_IsGreaterThanListSize() throws Exception {
        //s2.getScrabbleLetters(4);
    }

    @Test
    public void itShould_SuccessfullyReturnLetters() throws Exception {

        s2 = SingletonScrabbleGame.getInstance(10);
        myScrabbleList = SingletonScrabbleGame.getMyScrabbleList();
        System.out.println(myScrabbleList);

    }

}