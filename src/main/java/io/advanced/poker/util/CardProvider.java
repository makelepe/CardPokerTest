package io.advanced.poker.util;

import io.advanced.poker.domain.Card;
import java.util.List;

/**
 * @author Samuel Radingwane <makelepe1@gmail.com>
 * @since 2018-03-27
 */
public interface CardProvider {
    
    public List<Card> generateCards ();
}
