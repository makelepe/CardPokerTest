package io.advanced.poker.service;

import io.advanced.poker.domain.Card;
import io.advanced.poker.domain.PlayerHand;
import io.advanced.poker.domain.Rank;
import io.advanced.poker.evaluation.CardPokerEvaluator;
import io.advanced.poker.evaluation.CustomCardPokerEvaluatorImpl;
import io.advanced.poker.shuffling.CardShuffling;
import io.advanced.poker.shuffling.CardShufflingImpl;
import io.advanced.poker.util.CardProvider;
import io.advanced.poker.util.CardProviderImpl;
import java.util.List;

/**
 * This class exposes poker functionality to a client [includes Console | Web | Desktop | Mobile]
 * This class can be converted to REST service
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class CardPokerServiceImpl implements CardPokerService {
    
    private final CardProvider cardProvider;
    private final CardPokerEvaluator cardPokerEvaluator;
    private final CardShuffling cardShuffling;

    /*
    * For simplicity initialization happens in constructor. CDI (@Inject) can be used for cleaner code
    */
    public CardPokerServiceImpl()
    {
        cardProvider = new CardProviderImpl();
        cardPokerEvaluator = new CustomCardPokerEvaluatorImpl();
        cardShuffling = new CardShufflingImpl();
    }
    
    @Override
    public List<Card> getCards () {
        return cardProvider.generateCards();
    }
    
    @Override
    public List<Card> shuffleCards (List<Card> cards) {
        return cardShuffling.shuffle(cards);
    }
    
    @Override
    public PlayerHand allocateCards (List<Card> cards, int numberOfCards) {
        return cardPokerEvaluator.allocateCards(cards, numberOfCards);
    }
    
    @Override
    public Rank evaluatePlayerHand (PlayerHand player) {
        return cardPokerEvaluator.evaluatePlayerHand(player);
    }
}
