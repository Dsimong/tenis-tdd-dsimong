public class DeuceGameTranslator implements GameScoreTranslator {

    @Override
    public String translate(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            return "Deuce";
        }

        int scoreDifference = Math.abs(playerOneScore - playerTwoScore);

        if (scoreDifference == 1) {
            return String.format("Advantage %s",
                playerOneScore > playerTwoScore ? "Player One" : "Player Two");
        }

        return String.format("%s Wins",
            playerOneScore > playerTwoScore ? "Player One" : "Player Two");
    }
}

