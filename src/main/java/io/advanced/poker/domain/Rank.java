package io.advanced.poker.domain;

/**
 * Rank enum
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public enum Rank {
    STRAIGHT_FLUSH ("Straight Flush"),
    FOUR_OF_A_KIND ("Four of a Kind"),
    FULL_HOUSE ("Full House"),
    FLUSH ("Flush"),
    STRAIGHT ("Straight"),
    THREE_OF_A_KIND ("Three of a Kind"),
    TWO_PAIR ("Two Pair"),
    ONE_PAIR ("One Pair"),
    HIGH_CARDS ("High Cards");
    
    private String name;
    
    Rank (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
