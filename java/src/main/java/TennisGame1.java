
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
        if (player1Name.equals(playerName)) {
            m_score1 += 1;
        } else if (player2Name.equals(playerName)) {
            m_score2 += 1;
        } else {
        	throw new RuntimeException("Wrong player name " + playerName);
        }
    }

    public String getScore() {
        String score = "";
        if (sameScore())
        {
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
        }
        else if (advantagesOrWinPhase())
        {
            int scoreDifference = m_score1-m_score2;
            if (scoreDifference==1) score ="Advantage player1";
            else if (scoreDifference ==-1) score ="Advantage player2";
            else if (scoreDifference>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
           score = describe(m_score1) + "-" + describe(m_score2);
        }
        return score;
    }

	private String describe(int aScore) {
		switch(aScore)
		{
		    case 0:
		        return "Love";
		    case 1:
		        return "Fifteen";
		    case 2:
		    	return "Thirty";
		    case 3:
		    	return "Forty";
		    default:
		    	throw new RuntimeException("Program error: unknown score" + aScore);
		}
	}

	private boolean advantagesOrWinPhase() {
		return m_score1>=4 || m_score2>=4;
	}

	private boolean sameScore() {
		return m_score1==m_score2;
	}
}
