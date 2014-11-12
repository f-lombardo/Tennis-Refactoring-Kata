
public class FirstGamePhase extends AbstractStatus {

	protected FirstGamePhase(String player1Name, String player2Name, int player1Score, int player2Score) {
		super(player1Name, player2Name, player1Score, player2Score);
		if (player1Score > 3 || player1Score > 3) {
			throw new RuntimeException("Program error: wrong score " + player1Score + " " + player2Score);
		}
	}

	protected GameStatus newStatus(int player1Score, int player2Score) {
		if (win(player1Score, player2Score)) {
			return new WinStatus(player1Name, player2Name, player1Score, player2Score);
		} else if (advantages(player1Score, player2Score)) {
			return new AdvantagesGamePhase(player1Name, player2Name, player1Score, player2Score);
		} else {
			return new FirstGamePhase(player1Name, player2Name, player1Score, player2Score);
		}
	}

	public String describe() {
		if (sameScore()) {
			return describeTie();
		} else {
			return describe(player1ScoreStatus) + "-" + describe(player2ScoreStatus);
		}
	}
	
	private String describeTie() {
		switch (player1ScoreStatus) {
		case 0:
			return "Love-All";
		case 1:
			return "Fifteen-All";
		case 2:
			return "Thirty-All";
		case 3:
			return "Deuce";
		default:
			throw new RuntimeException("Program error: wrong score " + player1ScoreStatus);
		}
	}

	private String describe(int aScore) {
		switch (aScore) {
		case 0:
			return "Love";
		case 1:
			return "Fifteen";
		case 2:
			return "Thirty";
		case 3:
			return "Forty";
		default:
			throw new RuntimeException("Program error: unknown score " + aScore);
		}
	}

}
