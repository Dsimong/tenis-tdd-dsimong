
public class BasicScoreTranslator {

    public String translate(int playerOneScore, int playerTwoScore) {
        return String.format("%s-%s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        switch (score) {
            case 0: return new LoveTranslator().translate();
            default: throw new IllegalArgumentException("Invalid score");
        }
    }
}
