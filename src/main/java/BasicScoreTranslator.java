
public class BasicScoreTranslator {
    private final GameScoreTranslator deuceGameTranslator;
    private final GameScoreTranslator regularGameTranslator;

    public BasicScoreTranslator() {
        ScoreTranslator score = new ScoreTranslator();
        this.deuceGameTranslator = new DeuceGameTranslator();
        this.regularGameTranslator = new RegularGameTranslator(score);
    }

    public String translate(int playerOneScore, int playerTwoScore) {
        if (isDeuceGame(playerOneScore, playerTwoScore)) {
            return deuceGameTranslator.translate(playerOneScore, playerTwoScore);
        }
        return regularGameTranslator.translate(playerOneScore, playerTwoScore);
    }

    private boolean isDeuceGame(int playerOneScore, int playerTwoScore) {
        return playerOneScore >= 3 && playerTwoScore >= 3;
    }
}
