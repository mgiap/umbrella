package PlayerImplementation;

import java.util.List;

public class TestCalculateScore {
	public static void main(String[] args) {
		Player player = new Player("Giap", 1);
		
		List<List<String>> scoreBoard = player.getScoreBoard().getScoreBoard();
		
		player.getScoreBoard().printScoreBoard();
		
		scoreBoard.get(0).set(0, "T"); // 1
		scoreBoard.get(0).set(1, "T"); // 1
		// 3
		
		scoreBoard.get(1).set(0, "T"); // 1
		
		scoreBoard.get(2).set(0, "T"); // 1
		scoreBoard.get(2).set(1, "T"); // 1
		scoreBoard.get(2).set(2, "T"); // 1
		// 5
		
		scoreBoard.get(3).set(0, "T"); // 1
		scoreBoard.get(3).set(1, "T"); // 1
		// 3
		
		player.calculateScores();
		
		System.out.println(player.getScores());
	}
}
