import com.sun.org.apache.xpath.internal.operations.Mod;

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
        String score = "";
        if (P1point == P2point) {
            return getScoreForEqual(P1point);
        }
        score = getScore(P1point, P2point);
        if(P1point >= 4 || P2point >= 4) {
            score = getScoreAdvantageOrWin(P1point, P2point);
        }
        return score;
    }

    private static String getScoreAdvantageOrWin(int p1point, int p2point) {
        String score;
        final int pointDiff = p1point - p2point;
        String player = pointDiff > 0 ? "player1" : "player2";
        String text = Math.abs(pointDiff) >= 2 ? "Win for " : "Advantage ";
        score = text + player;
        return score;
    }

    private static String getScoreForEqual(final int point) {
        String score = "";
        if (point < 4) {
            score = getScoreText(point) + "-All";
        }
        if (point >= 3) {
            score = "Deuce";
        }
        return score;
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
        String score = "";
        if (point ==0)
            score = "Love";
        if (point ==1)
            score = "Fifteen";
        if (point ==2)
            score = "Thirty";
        if (point ==3)
            score = "Forty";
        return score;
    }
    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}
