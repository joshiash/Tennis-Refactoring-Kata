
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
        if (m_score1==m_score2)  return getScoreForEqual();
        if (m_score1>=4 || m_score2>=4) return getScoreAdvantage();
        return getScoreDefault();
    }

    private String getScoreDefault() {
        String score = "";
        score += getScore(m_score1);
        score += "-";
        score += getScore(m_score2);
        return score;
    }

    private String getScore(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return  "Fifteen";
            case 2:
               return  "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String getScoreAdvantage() {
        String score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getScoreForEqual() {
        String score;
        switch (m_score1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }
}
