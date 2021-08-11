public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    private String player1Name;
    private String player2Name;
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    public String getScore(){
        if (P1point == P2point) {
            return getScoreForEqual(P1point);
        }
        if(P1point >= 4 || P2point >= 4) {
            return getScoreAdvantageOrWin(P1point, P2point);
        }
        return getScore(P1point, P2point);
    }

    private static String getScoreAdvantageOrWin(int p1point, int p2point) {
        final int pointDiff = p1point - p2point;
        String player = pointDiff > 0 ? "player1" : "player2";
        String text = Math.abs(pointDiff) >= 2 ? "Win for " : "Advantage ";
        return text + player;
    }
    private static String getScoreForEqual(final int point) {
        if (point >= 3) {
            return "Deuce";
        }
        return getScoreText(point) + "-All";
    }
    private static String getScore(final int p1Point, final int p2Point) {
        String score = "";
        if (p1Point > 0 && p2Point==0)
        {
            score = getScoreText(p1Point) + "-" + getScoreText(p2Point);
        }
        if (p2Point > 0 && p1Point==0)
        {
            score = getScoreText(p1Point) + "-" + getScoreText(p2Point);
        }
        if (p1Point>p2Point && p1Point < 4)
        {
            score = getScoreText(p1Point) + "-" + getScoreText(p2Point);
        }
        if (p2Point>p1Point && p2Point < 4)
        {
            score = getScoreText(p1Point) + "-" + getScoreText(p2Point);
        }
        return score;
    }
    private static String getScoreText(int point) {
        String[] score = {"Love", "Fifteen", "Thirty", "Forty"};
        return score[point];
    }
    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}
