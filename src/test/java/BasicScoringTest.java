import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BasicScoringTest {

    static Stream<Map.Entry<Integer, Integer>> scoreProvider() {
        Map<Integer,Integer> scoreMap = new HashMap<>();
        // Ambos jugadores anotan (15 puntos por anotación)
        scoreMap.put(0, 0);    // Love-Love
        scoreMap.put(1, 0);    // Fifteen-Love
        scoreMap.put(0, 1);    // Love-Fifteen
        scoreMap.put(1, 1);    // Fifteen-All
        scoreMap.put(2, 0);    // Thirty-Love
        scoreMap.put(0, 2);    // Love-Thirty
        scoreMap.put(2, 1);    // Thirty-Fifteen
        scoreMap.put(1, 2);    // Fifteen-Thirty
        scoreMap.put(2, 2);    // Thirty-Thirty

        return scoreMap.entrySet().stream();
    }

    @ParameterizedTest
    @MethodSource("scoreProvider")
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(Map.Entry<Integer, Integer> entry){
        //Arrange
        BasicScoreTranslator translator = new BasicScoreTranslator();

        //Act
        String result = translator.translate(entry.getKey(), entry.getValue());

        //Assert
        assertEquals("Fifteen-Love", result);
    }
}
