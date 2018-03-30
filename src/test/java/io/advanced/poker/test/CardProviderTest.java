package io.advanced.poker.test;

import io.advanced.poker.domain.Card;
import io.advanced.poker.util.CardProvider;
import io.advanced.poker.util.CardProviderImpl;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardProviderTest {
    
    private  CardProvider cardProvider;
    
    @Before
    public void setUp() {
        cardProvider = new CardProviderImpl();
    }
    
    @After
    public void tearDown() {
        cardProvider = null;
    }

    @Test
    public void testGenerateCards() {
        System.out.println("\nstart testing generateCards method ....:");
        List<Card> cards = cardProvider.generateCards();
        
        // test null or empty
        assertTrue("List of Cards is null or empty",(cards != null && !cards.isEmpty()));
    
        // test size
        assertTrue("Card Generator is generating cards <> 52",cards.size() == 52);
        
        // test first card
        assertTrue("First Card is not AC",(cards.get(0).getRank()+cards.get(0).getSuit()).equalsIgnoreCase("AC"));

        // test first card
        assertTrue("Last Card is not KS",(cards.get(51).getRank()+cards.get(51).getSuit()).equalsIgnoreCase("KS"));
        System.out.println("finish testing generateCards method ....!\n");
    }
}
