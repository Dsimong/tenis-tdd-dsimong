
public class BasicScoreTranslator {

    public String translate(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) { return String.format("%s-All", translateScore(playerOneScore)); }
        return String.format("%s-%s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        switch (score) {
            case 0: return new LoveTranslator().translate();
            case 1: return new FifteenTranslator().translate();
            case 2: return new ThirtyTranslator().translate();
            case 3: return new FortyTranslator().translate();
            default: throw new IllegalArgumentException("Invalid score");
        }
    }
}
