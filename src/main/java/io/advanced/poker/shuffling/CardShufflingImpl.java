package io.advanced.poker.shuffling;

import io.advanced.poker.domain.Card;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * shuffle cards
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class CardShufflingImpl implements  CardShuffling {
  
    @Override
    public List<Card> shuffle (List<Card> cards) {
        // creating an object for Random Class
        Random r = new Random();
        
        Card[] cardsArr = cards.toArray(new Card[0]);
        for (int i = cards.size()-1; i > 0; i--) {
            // pick a random card index
            int j = r.nextInt(i);
            
            // swap cards
            Card temp = cardsArr[i];
            cardsArr[i] = cardsArr[j];
            cardsArr[j] = temp;
        }
        
        return Arrays.asList(cardsArr);
    }
    
}
