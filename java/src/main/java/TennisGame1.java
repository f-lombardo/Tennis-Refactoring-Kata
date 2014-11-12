public class TennisGame1 implements TennisGame {

	private GameStatus status;
	
	public TennisGame1(String player1Name, String player2Name) {
		this.status = FirstGamePhase.startGame(player1Name, player2Name);
	}

	public void wonPoint(String playerName) {
		this.status = this.status.wonPoint(playerName);
	}

	public String getScore() {
		return this.status.describe();
	}

}
