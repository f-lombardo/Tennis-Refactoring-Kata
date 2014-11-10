public class TennisGame1 implements TennisGame {

	private int player1Score = 0;
	private int player2Score = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (player1Name.equals(playerName)) {
			player1Score += 1;
		} else if (player2Name.equals(playerName)) {
			player2Score += 1;
		} else {
			throw new RuntimeException("Wrong player name " + playerName);
		}
	}

	public String getScore() {
		if (sameScore()) {
			return describeTie();
		} else if (advantages()) {
			return describeAdvantages();
		} else if (win()) {
			return describeWin();
		} else {
			return describe(player1Score) + "-" + describe(player2Score);
		}
	}

	private String describeWin() {
		if (player1Score > player2Score) {
			return "Win for player1";
		} else {
			return "Win for player2";
		}
	}

	private String describeAdvantages() {
		if (player1Score > player2Score) {
			return "Advantage player1";
		} else {
			return "Advantage player2";
		}
	}

	private boolean win() {
		return advantagesOrWinPhase() && scoreDifference() >= 2;
	}

	private boolean advantages() {
		return advantagesOrWinPhase() && scoreDifference() < 2;
	}

	private int scoreDifference() {
		return Math.abs(player1Score - player2Score);
	}

	private String describeTie() {
		switch (player1Score) {
		case 0:
			return "Love-All";
		case 1:
			return "Fifteen-All";
		case 2:
			return "Thirty-All";
		default:
			return "Deuce";
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

	private boolean advantagesOrWinPhase() {
		return player1Score >= 4 || player2Score >= 4;
	}

	private boolean sameScore() {
		return player1Score == player2Score;
	}
}
