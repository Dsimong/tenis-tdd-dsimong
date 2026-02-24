
public class BasicScoreTranslator {

    public String translate(int playerOneScore, int playerTwoScore) {
        return String.format("%s-%s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    private String translateScore(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: throw new IllegalArgumentException("Invalid score");
        }
    }
}
