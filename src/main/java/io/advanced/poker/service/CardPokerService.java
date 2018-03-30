package io.advanced.poker.service;

import io.advanced.poker.domain.Card;
import io.advanced.poker.domain.PlayerHand;
import io.advanced.poker.domain.Rank;
import java.util.List;

/**
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public interface CardPokerService {
    
    public List<Card> getCards ();
    
    public List<Card> shuffleCards (List<Card> cards);
    
    public PlayerHand allocateCards (List<Card> cards, int numberOfCards);
    
    public Rank evaluatePlayerHand (PlayerHand player);
}
