import static java.lang.Math.*;

public class TennisGame3 implements TennisGame {

    private static final String[] scoreText = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (isGameOn()) {
            return (p1 == p2) ? scoreText[p1] + "-All" : scoreText[p1] + "-" + scoreText[p2];
        } else {
            if (p1 == p2) return "Deuce";
            return getScoreWinOrAdv();
        }
    }

    private String getScoreWinOrAdv() {
        String playerAhead = p1 > p2 ? p1N : p2N;
        int scoreDiff = p1 - p2;
        return abs(scoreDiff) == 1 ? "Advantage " + playerAhead : "Win for " + playerAhead;
    }

    private boolean isGameOn() {
        return p1 < 4 && p2 < 4 && !(p1 + p2 == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
