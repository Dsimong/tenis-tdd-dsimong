import java.util.HashMap;
import java.util.Map;

public class ScoreTranslator {
    private final Map<Integer, String> translators;

    public ScoreTranslator() {
        this.translators = new HashMap<>();
        translators.put(0, "Love");
        translators.put(1, "Fifteen");
        translators.put(2, "Thirty");
        translators.put(3, "Forty");
    }

    public String translateScore(int score) {
        String translator = translators.get(score);
        if (translator == null) {
            throw new IllegalArgumentException("Invalid score: " + score);
        }
        return translator;
    }
}

