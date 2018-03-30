package io.advanced.poker.evaluation;

import io.advanced.poker.domain.Card;
import io.advanced.poker.domain.PlayerHand;
import io.advanced.poker.domain.Rank;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * evaluates and allocate cards to player
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class CustomCardPokerEvaluatorImpl implements CardPokerEvaluator {

    @Override
    public PlayerHand allocateCards(List<Card> cards, int numberOfCards) {
        PlayerHand hand = new PlayerHand();

        Object[] cardsArr = cards.toArray();
        for (int i = 0; i < numberOfCards; i++) {
            // allocate card
            hand.allocateCard((Card)cardsArr[i]);
        }
        sort(hand.getAllocatedCards());
        
        return hand;
    }

    @Override
    public Rank evaluatePlayerHand(PlayerHand hand) {
        Rank rank;
        Set<String> ranks = new HashSet<>();
        Set<String> suits = new HashSet<>();

        for (Card card : hand.getAllocatedCards()) {
            ranks.add(card.getRank());
            suits.add(card.getSuit());
        }
        sort(hand.getAllocatedCards());

        switch (ranks.size()) {
            case 5:
                boolean flush = (suits.size() == 1);
                Card first = hand.getAllocatedCards().get(0);
                Card last = hand.getAllocatedCards().get(4);

                if (last.getOrder() - first.getOrder() == 4) {
                    rank = flush ? Rank.STRAIGHT_FLUSH : Rank.STRAIGHT;
                } else {
                    rank = flush ? Rank.FLUSH : Rank.HIGH_CARDS;
                }
                break;
            case 4:
                rank = Rank.ONE_PAIR;
                break;
            case 3:
                rank = max(hand.getAllocatedCards()) == 2 ? Rank.TWO_PAIR : Rank.THREE_OF_A_KIND;
                break;
            case 2:
                Integer _min = min(hand.getAllocatedCards());
                Integer _max = max(hand.getAllocatedCards());
                rank = ((_max==3||_max==2)&&(_min==2||_min==3)) ? Rank.FULL_HOUSE : Rank.FOUR_OF_A_KIND;
                break;
            default:
                rank = Rank.HIGH_CARDS;
                break;
        }
        return rank;
    }
    
    private Integer min (List<Card> cards) {
        sort(cards);

        Map<String, Integer> pairs = new HashMap<>();
        for (Card card : cards) {
            Integer count = pairs.get(card.getRank());
            count = (count!=null) ? count+1 : 1;
            pairs.put(card.getRank(), count);
        }
        
        int min = 0;
        for (String rank : pairs.keySet()) {
            if (pairs.get(rank) < min) {
                min = pairs.get(rank);
            }
        }
        
        return min;
    }

    private Integer max(List<Card> cards) {
        sort(cards);

        Map<String, Integer> pairs = new HashMap<>();
        for (Card card : cards) {
            Integer count = pairs.get(card.getRank());
            count = (count!=null) ? count+1 : 1;
            pairs.put(card.getRank(), count);
        }
        
        int max = 0;
        for (String rank : pairs.keySet()) {
            if (pairs.get(rank) > max) {
                max = pairs.get(rank);
            }
        }
        
        return max;
    }

    private void sort(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getOrder().compareTo(c2.getOrder());
            }
        });
    }
}
