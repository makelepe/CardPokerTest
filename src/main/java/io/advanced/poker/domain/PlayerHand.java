package io.advanced.poker.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayerHand blueprint
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class PlayerHand {
    private String playerName;
    private String rank;
    private List<Card> allocatedCards;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public void allocateCard (Card card) {
        if (allocatedCards == null) {
            allocatedCards = new ArrayList<>();
        }
        
        // add card to player allocated list of cards
        allocatedCards.add(card);
    }

    public List<Card> getAllocatedCards() {
        return allocatedCards;
    }

    public void setAllocatedCards(List<Card> allocatedCards) {
        this.allocatedCards = allocatedCards;
    }
    
}
