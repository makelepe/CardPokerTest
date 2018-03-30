package io.advanced.poker.test;

import io.advanced.poker.domain.Card;
import io.advanced.poker.shuffling.CardShuffling;
import io.advanced.poker.shuffling.CardShufflingImpl;
import io.advanced.poker.util.CardProvider;
import io.advanced.poker.util.CardProviderImpl;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardShufflingImplTest {
    
    private  CardProvider cardProvider;
    private  CardShuffling cardShuffling;
    
    @Before
    public void setUp() {
        cardProvider = new CardProviderImpl();
        cardShuffling = new CardShufflingImpl();
    }
    
    @After
    public void tearDown() {
        cardProvider = null;
        cardShuffling = null;
    }

    /**
     * Test of shuffle method, of class CardShufflingImpl.
     */
    @Test
    public void testShuffle() {
        System.out.println("\nstart testing shuffle method ....:");
        List<Card> cards = cardProvider.generateCards();
        List<Card> shuffleCards = cardShuffling.shuffle(cards);
        
        // test null or empty
        assertTrue("List of Cards is null or empty",(shuffleCards != null && !shuffleCards.isEmpty()));
    
        // test size
        assertTrue("Card Generator is generating cards <> 52",shuffleCards.size() == 52);
        
        // test first card
        assertTrue("First Card is still AC",!(shuffleCards.get(0).getRank()+shuffleCards.get(0).getSuit()).equalsIgnoreCase("AC"));

        // test first card
        assertTrue("Last Card is still KS",!(shuffleCards.get(51).getRank()+shuffleCards.get(51).getSuit()).equalsIgnoreCase("KS"));
        System.out.println("finish testing shuffle method ....!\n");
    }
    
}
