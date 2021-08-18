import static java.lang.Math.abs;

public class TennisGame2 implements TennisGame
{
    private int p1Point;
    private int p2Point;

    final private String player1Name;
    final private String player2Name;
    private static final String[] SCORE = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    public String getScore(){
        if (p1Point == p2Point) {
            return getScoreForEqual(p1Point);
        }
        if(p1Point >= 4 || p2Point >= 4) {
            return getScoreAdvantageOrWin(p1Point, p2Point);
        }
        return SCORE[p1Point] + "-" + SCORE[p2Point];
    }

    private String getScoreAdvantageOrWin(int p1Point, int p2Point) {
        final int pointDiff = p1Point - p2Point;
        String player = pointDiff > 0 ? player1Name : player2Name;
        String text = abs(pointDiff) >= 2 ? "Win for " : "Advantage ";
        return text + player;
    }
    private static String getScoreForEqual(final int point) {
        if (point >= 3) {
            return "Deuce";
        }
        return SCORE[point] + "-All";
    }

    public void wonPoint(String player) {
        if (player == player1Name)
            p1Point++;
        else
            p2Point++;
    }
}
