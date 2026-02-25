public class RegularGameTranslator implements GameScoreTranslator {
    private final ScoreTranslator score;

    public RegularGameTranslator(ScoreTranslator score) {
        this.score = score;
    }

    @Override
    public String translate(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            return String.format("%s-All", score.translateScore(playerOneScore));
        }
        return String.format("%s-%s",
            score.translateScore(playerOneScore),
            score.translateScore(playerTwoScore));
    }
}

