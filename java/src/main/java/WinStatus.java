
public class WinStatus implements GameStatus {

	//TODO: do you want to know the name of the winner? Change tests!
	private final String player1Name;
	private final String player2Name;
	//
	private final int player1Score;
	private final int player2Score;

	public WinStatus(String player1Name, String player2Name, int player1Score, int player2Score) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		this.player1Score = player1Score;
		this.player2Score = player2Score;
	}

	public GameStatus wonPoint(String playerName) {
		throw new RuntimeException("Game is over");
	}

	public String describe() {
		if (player1Score > player2Score) {
			return "Win for player1";
		} else {
			return "Win for player2";
		}
	}

}
