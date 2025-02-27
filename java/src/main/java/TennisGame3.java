import static java.lang.Math.*;

public class TennisGame3 implements TennisGame {

    private static final String[] scoreText = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int p2;
    private int p1;
    private final String player1;
    private final String player2;

    public TennisGame3(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (isGameOn()) return getGameOnScore();

        if (p1 == p2) return "Deuce";

        return getScoreWinOrAdv(getPlayerAhead(), getScoreDiff());
    }

    private String getScoreWinOrAdv(final String playerAhead, final int scoreDiff) {
        return abs(scoreDiff) == 1 ? "Advantage " + playerAhead : "Win for " + playerAhead;
    }

    private int getScoreDiff() {
        return p1 - p2;
    }

    private String getPlayerAhead() {
        return p1 > p2 ? player1 : player2;
    }

    private boolean isGameOn() {
        return p1 < 4 && p2 < 4 && p1 + p2 != 6;
    }

    private String getGameOnScore() {
        String gameScore = scoreText[p1] + "-" + scoreText[p2];
        return p1 == p2 ? scoreText[p1] + "-All" : gameScore;
    }


    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
