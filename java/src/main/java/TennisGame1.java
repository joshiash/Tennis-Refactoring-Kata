import java.util.Map;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2)  return getScoreForEqual(m_score1, "-All", "Deuce");
        if (m_score1>=4 || m_score2>=4) return getScoreAdvantage();
        return getScoreDefault();
    }

    private String getScoreDefault() {
        return getScore(m_score1) + "-" + getScore(m_score2);
    }


    private String getScore(int tempScore) {
        return getScoreForEqual(tempScore, "", "Forty");
    }

    private String getScoreAdvantage() {
        int minusResult = m_score1-m_score2;
        String player = (minusResult > 0) ? "player1" : "player2";
        String winOrAdvantage = (Math.abs(minusResult) == 1) ? "Advantage " : "Win for ";

        return winOrAdvantage + player;
    }

    private String getScoreForEqual(final int tempScore, final String postfix, final String defaultScoreText) {
        switch (tempScore) {
            case 0:
                return "Love" + postfix;
            case 1:
                return "Fifteen" + postfix;
            case 2:
                return "Thirty" + postfix;
            default:
                return defaultScoreText;
        }
    }
}
