import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvantageTranslatorTest {

    static Stream<TestCase> scoreProvider() {

        return Stream.of(
                new TestCase(3, 3, "Deuce"),
                new TestCase(4, 3, "Advantage Player One"),
                new TestCase(3, 4, "Advantage Player Two")
        );
    }

    @ParameterizedTest
    @MethodSource("scoreProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(BasicScoringTest.TestCase score){
        //Arrange
        BasicScoreTranslator translator = new BasicScoreTranslator();

        //Act
        String result = translator.translate(score.playerOneScore, score.playerTwoScore);

        //Assert
        assertEquals(score.expectedResult, result);
    }

    static class TestCase {
        int playerOneScore;
        int playerTwoScore;
        String expectedResult;

        TestCase(int playerOneScore, int playerTwoScore, String expectedResult) {
            this.playerOneScore = playerOneScore;
            this.playerTwoScore = playerTwoScore;
            this.expectedResult = expectedResult;
        }

        @Override
        public String toString() {
            return String.format("%d should return \"%s-%s\"", playerOneScore, playerTwoScore);
        }
    }
}
