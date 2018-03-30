package io.advanced.poker.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({io.advanced.poker.test.CardShufflingImplTest.class, 
                     io.advanced.poker.test.CardProviderTest.class, 
                     io.advanced.poker.test.CustomCardPokerEvaluatorImplTest.class})
public class CardPokerTestSuite {

}
