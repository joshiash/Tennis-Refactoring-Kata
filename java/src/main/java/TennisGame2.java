
public class TennisGame2 implements TennisGame
{
    private int p1Point;
    private int p2Point;
    

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

         String P1res = "";
         String P2res = "";

        String score = getScoreEqual();

        if (p1Point == p2Point && p1Point >=3)
            score = "Deuce";
        
        if (p1Point > 0 && p2Point ==0)
        {
            score = getPoint(p1Point) + "-" + "Love";
        } else if (p2Point > 0 && p1Point ==0)
        {
            score = "Love" + "-" + getPoint(p2Point);
        }
        
        else if (p1Point > p2Point && p1Point < 4)
        {
            P1res = getString(p1Point);
            P2res = getString2(p2Point);

            score = P1res + "-" + P2res;
        }
        else if (p2Point > p1Point && p2Point < 4)
        {
            P2res = getString(p2Point);
            P1res = getString2(p1Point);

            score = P1res + "-" + P2res;
        }
        
        else if (p1Point > p2Point && p2Point >= 3)
        {
            score = "Advantage player1";
        }
        
        else if (p2Point > p1Point && p1Point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (p1Point >=4 && p2Point >=0 && (p1Point - p2Point)>=2)
        {
            score = "Win for player1";
        }
        else if (p2Point >=4 && p1Point >=0 && (p2Point - p1Point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getString2(int point) {
        String p2res = "";
        if (point ==1)
            p2res ="Fifteen";
        else if (point ==2)
            p2res ="Thirty";
        return p2res;
    }

    private String getString(int point) {
        String p1PointRes = "";
        if (point ==2)
            p1PointRes ="Thirty";
        else if (point ==3)
            p1PointRes ="Forty";
        return p1PointRes;
    }

    private String getPoint(int p) {
        if (p==1)
            return  "Fifteen";
        if (p==2)
            return  "Thirty";
        if (p==3)
            return  "Forty";
        return "";
    }

    private String getScoreEqual() {
        String score = "";
        if (p1Point == p2Point && p1Point < 4)
        {
            if (p1Point ==0)
                score = "Love";
            if (p1Point ==1)
                score = "Fifteen";
            if (p1Point ==2)
                score = "Thirty";
            score += "-All";
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            p1Point++;
        else
            p2Point++;
    }
}
