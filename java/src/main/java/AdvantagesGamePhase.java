
public class AdvantagesGamePhase extends AbstractStatus implements GameStatus {

	public AdvantagesGamePhase(String player1Name, String player2Name, int player1Score, int player2Score) {
		super(player1Name, player2Name, player1Score, player2Score);
	}


	protected GameStatus newStatus(int player1Score, int player2Score) {
		if (win(player1Score, player2Score)) {
			return new WinStatus(player1Name, player2Name, player1Score, player2Score);
		} else {
			return new AdvantagesGamePhase(player1Name, player2Name, player1Score, player2Score);
		}
	}

	
	public String describe() {
		if (sameScore()) {
			return "Deuce";
		} else if (player1ScoreStatus > player2ScoreStatus) {
			return "Advantage player1";
		} else {
			return "Advantage player2";
		}
	}
}
