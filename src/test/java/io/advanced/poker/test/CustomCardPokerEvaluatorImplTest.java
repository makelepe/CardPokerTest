package io.advanced.poker.test;

import io.advanced.poker.domain.PlayerHand;
import io.advanced.poker.domain.Rank;
import io.advanced.poker.evaluation.CardPokerEvaluator;
import io.advanced.poker.evaluation.CustomCardPokerEvaluatorImpl;
import io.advanced.poker.util.CardProvider;
import io.advanced.poker.util.CardProviderImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomCardPokerEvaluatorImplTest {
    
    private CardPokerEvaluator cardPokerEvaluator;
    private  CardProvider cardProvider;

    @Before
    public void setUp() {
        cardProvider = new CardProviderImpl();
        cardPokerEvaluator = new CustomCardPokerEvaluatorImpl();
    }
    
    @After
    public void tearDown() {
        cardPokerEvaluator = null;
        cardProvider = null;
    }

    /**
     * Test of allocateCards method, of class CustomCardPokerEvaluatorImpl.
     */
    @Test
    public void testAllocateCards() {
        System.out.println("\nstart testing allocateCards...:");
        
        PlayerHand result = cardPokerEvaluator.allocateCards(cardProvider.generateCards(), 5);
        // check for null
        assertTrue("Hand is null", (result != null));
        // check size
        assertTrue("Hand cards are not equal to 5", (result.getAllocatedCards().size() == 5));
        System.out.println("finish testing allocateCards...!\n");
    }

    /**
     * Test of evaluatePlayerHand method, of class CustomCardPokerEvaluatorImpl.
     */
    @Test
    public void testEvaluatePlayerHand() {
        System.out.println("\nstart testing evaluatePlayerHand...:");
        PlayerHand hand = cardPokerEvaluator.allocateCards(cardProvider.generateCards(), 5);
        Rank rank = cardPokerEvaluator.evaluatePlayerHand(hand);
        // check for null
        assertTrue("Rank is null", (rank != null));
        // check length of the chars
        assertTrue("Rank is empty", (!rank.getName().isEmpty()));
        System.out.println("finish testing evaluatePlayerHand...!\n");
    }
    
}
