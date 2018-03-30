package io.advanced.poker.util;

import io.advanced.poker.domain.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Card provider - to generate all 52 pair of cards
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class CardProviderImpl implements CardProvider {
    
    @Override
    public List<Card> generateCards () {
        List<Card> cards = new ArrayList<>();
        
        String[] cardNumbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int order = 1, sequence = 1;
         for (String cardNumber : cardNumbers) {
             List<Card> cardsPair = generate(cardNumber, order, sequence); 
             cards.addAll(cardsPair);
             sequence+=4;
             order++;
         }
         
        return cards;
    }
    
    private List<Card> generate (String rank, Integer order, Integer sequence) {
        List<Card> cards = new ArrayList<>();

        String[] suits = {"Clubs","Diamond","Hearts","Spade"};
        for (String suit : suits) {
            Card card = new Card();
            card.setRank(rank);
            card.setOrder(order);
            card.setSequence(sequence);
            card.setSuit(String.valueOf(suit.charAt(0)));
            cards.add(card);
            sequence++;
        }
        
        return cards;
    } 
    
}
