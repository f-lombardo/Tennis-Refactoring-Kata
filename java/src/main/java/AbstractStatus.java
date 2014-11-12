
public abstract class AbstractStatus implements GameStatus {

	protected final String player1Name;
	protected final String player2Name;
	protected int player1ScoreStatus;
	protected int player2ScoreStatus;

	public AbstractStatus(String player1Name, String player2Name, int player1Score, int player2Score) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		this.player1ScoreStatus = player1Score;
		this.player2ScoreStatus = player2Score;
	}
	
	public GameStatus wonPoint(String playerName) {
		if (player1Name.equals(playerName)) {
			return newStatus(player1ScoreStatus + 1, player2ScoreStatus);
		} else if (player2Name.equals(playerName)) {
			return newStatus(player1ScoreStatus, player2ScoreStatus + 1);
		} else {
			throw new RuntimeException("Wrong player name " + playerName);
		}
	}

	protected abstract GameStatus newStatus(int player1Score, int player2Score);
	
	protected boolean advantagesOrWinPhase(int player1Score, int player2Score) {
		return player1Score >= 4 || player2Score >= 4;
	}
	
	protected boolean win(int player1Score, int player2Score) {
		return advantagesOrWinPhase(player1Score, player2Score) && scoreDifference(player1Score, player2Score) >= 2;
	}

	protected boolean advantages(int player1Score, int player2Score) {
		return advantagesOrWinPhase(player1Score, player2Score) && scoreDifference(player1Score, player2Score) < 2;
	}

	protected int scoreDifference(int player1Score, int player2Score) {
		return Math.abs(player1Score - player2Score);
	}
	
	public final static GameStatus startGame(String player1Name, String player2Name) {
		return new FirstGamePhase(player1Name, player2Name, 0, 0);
	}
	
	protected boolean sameScore() {
		return player1ScoreStatus == player2ScoreStatus;
	}
}
