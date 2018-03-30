package io.advanced.poker.evaluation;

import io.advanced.poker.domain.Card;
import io.advanced.poker.domain.PlayerHand;
import io.advanced.poker.domain.Rank;
import java.util.List;

/**
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public interface CardPokerEvaluator {
    
    public PlayerHand allocateCards (List<Card> cards, int numberOfCards);
    
    public Rank evaluatePlayerHand (PlayerHand hand);
}
