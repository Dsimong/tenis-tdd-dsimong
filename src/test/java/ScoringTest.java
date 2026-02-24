import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ScoringTest {
    
    static Stream<Integer> shouldReturnLoveOnStart() {
        return Stream.of();
    }
    
    @ParameterizedTest
    @MethodSource("shouldReturnLoveOnStart")
    void should_return_love_when_translate_is_called_with_no_points() {
        //Arrange
        BasicScoreTranslator translator = new BasicScoreTranslator();

        //Act
        String result = translator.translate(0,0);

        //Assert
        assertEquals("Love-Love", result);
    }
}
