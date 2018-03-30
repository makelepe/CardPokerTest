package io.advanced.poker.domain;

/**
 * Card blueprint
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class Card {
    private String rank;
    private String suit;
    private Integer order;
    private Integer sequence;
    private PlayerHand hand;
    
    public Boolean isHandedOut() {
        return hand != null;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public PlayerHand getHand() {
        return hand;
    }

    public void setHand(PlayerHand hand) {
        this.hand = hand;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    
    @Override
    public String toString() {
        return this.rank + this.suit;
    }
    
}
