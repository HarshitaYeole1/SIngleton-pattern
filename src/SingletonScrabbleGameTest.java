
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by harshita on 3/9/16.
 */
public class SingletonScrabbleGameTest {


    SingletonScrabbleGame s1;
    SingletonScrabbleGame s2;
    SingletonScrabbleGame s3;

    @Before
    public void setUp() throws Exception {

        s1=SingletonScrabbleGame.getInstance();
        s2=SingletonScrabbleGame.getInstance();
        s3=SingletonScrabbleGame.getInstance();
        //s1.getScrabbleLetters(6);
        //s1.getScrabbleLetters(26);          // to check empty list exception
        s1.getScrabbleLetters(20);         //to check asked items greater than list size
        System.out.println();
    }

    @Test
    public void itShould_CheckIf_SameSingletonInstance_IsReturned_EachTimeGetInstanceIsCalled() throws Exception {

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        assertEquals(s2,s3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShould_ThrowIllegalArgumentException_Because_ListIsEmpty() throws Exception {
        s2.getScrabbleLetters(2);
    }

    @Test
    public void itShould_Reduce_GiveCorrectNumberOfItems_IfNumberOfItemsAsked_IsGreaterThanListSize() throws Exception{
        s3.getScrabbleLetters(8);
    }

    @Test
    public void itShould_SuccessfullyReturnLetters() throws Exception{
        s3.getScrabbleLetters(8);
    }

}