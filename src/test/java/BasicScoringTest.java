import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BasicScoringTest {

    static Stream<TestCase> scoreProvider() {

        return Stream.of(
                new TestCase(0, 0, "Love-All"),
                new TestCase(15, 0, "Fifteen-Love"),
                new TestCase(30, 0, "Thirty-Love"),
                new TestCase(0, 15, "Love-Fifteen"),
                new TestCase(0, 30, "Love-Thirty"),
                new TestCase(15, 15, "Fifteen-All"),
                new TestCase(30, 30, "Thirty-All")
        );
    }

    @ParameterizedTest
    @MethodSource("scoreProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(TestCase score){
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
