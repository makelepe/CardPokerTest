package io.advanced.poker.console;

import io.advanced.poker.domain.Card;
import io.advanced.poker.domain.PlayerHand;
import io.advanced.poker.domain.Rank;
import io.advanced.poker.service.CardPokerService;
import io.advanced.poker.service.CardPokerServiceImpl;
import java.util.List;
import java.util.Scanner;

/**
 * This is a Card Poker console application class which allocate 5 cards to a single player's hand 
 * 
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public class CardPokerConsole {
    
    public static void main(String[] args) {
        CardPokerService service = new CardPokerServiceImpl();
        
        // request cards
        List<Card> cards = service.getCards();
        System.out.println("original order> " + cards);
        
        while (true) {
            // shuffle as many as main args
            for (String arg : args) {
                if (arg!=null) {
                    if (arg.equalsIgnoreCase("shuffling")) {
                        cards = service.shuffleCards(cards);
                        System.out.println("shuffled order> " + cards);
                    }
                }
            }

            // allocate cards to player's hand
            PlayerHand hand = service.allocateCards(cards, 5);

            // rank cards on player's hand
            Rank rank = service.evaluatePlayerHand(hand);

            // display cards
            display (hand, rank);
            
            System.out.println("Play Again? Y/N : ");
             Scanner inputReader = new Scanner(System.in);
             String input = inputReader.nextLine();
             if (String.valueOf(input).equalsIgnoreCase("N")) {
                 break;
             }
        }
        
    }
    
    /**
     * display Player's cards on hand and ranking
     */
    private static void display(PlayerHand hand, Rank rank) {
        System.out.print("\nYour hand: ");
        for (Card card : hand.getAllocatedCards()) {
            System.out.print(card.getRank() + card.getSuit() +" ");
        }
        System.out.println("\n");
        System.out.println("You have: " + rank.getName());
        
    }
    
}
