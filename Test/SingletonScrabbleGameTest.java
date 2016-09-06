
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


        //s3=SingletonScrabbleGame.getInstance(26);        //number of items directly from the instnce

        s1=SingletonScrabbleGame.getInstance(3);
        s2=SingletonScrabbleGame.getInstance(4);
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
        assertEquals(System.identityHashCode(s2), System.identityHashCode(s1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShould_ThrowIllegalArgumentException_Because_ListIsEmpty() throws Exception {
        //s2.getScrabbleLetters(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShould_ThrowIllegalArgumentException_Because_NumberOfItemsAsked_IsGreaterThanListSize() throws Exception {
        //s2.getScrabbleLetters(4);
        s2 = SingletonScrabbleGame.getInstance(10);
    }

    @Test
    public void itShould_SuccessfullyReturnLetters() throws Exception {

        s2 = SingletonScrabbleGame.getInstance(1);
        myScrabbleList=s2.getMyScrabbleList();
        System.out.println(myScrabbleList);

    }

    @Test
    public void itShouldCheckStaticInnerSingletonClass() throws Exception
    {
        StaticInnerSingleton s1=StaticInnerSingleton.getInstance(5);
        System.out.println(s1);
        StaticInnerSingleton s2=StaticInnerSingleton.getInstance(5);
        System.out.println(s2);
        myScrabbleList=s2.getMyScrabbleList();
        System.out.println(myScrabbleList);
    }

}