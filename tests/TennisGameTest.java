import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		//is the score 0 at the start?
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		//is the score tied when both have 4 points
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}		
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}		

	@Test 
	public void testTennisGame_tie1_ResultsException() throws TennisGameException{
	TennisGame game = new TennisGame();

	game.player1Scored();
	game.player1Scored();

	game.player2Scored();
	game.player2Scored();

	String score = game.getScore();
	assertEquals("Points wrong", "30 - 30",score); //test when game is 30-30
	}
	
	@Test
	public void testTennisGame_tie2_ResultsEsception() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("Points wrong", "15 - 15", score); //test when game is  15-15
		
	}
	
	@Test
	public void testTennisGame_Advantage1_ResultsException() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		game.player2Scored();
		
		game.player1Scored();
		
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("Points wrong", "player1 has advantage", score); //Test when player 1 has advantage
		
	}
	
	@Test
	public void testTennisGame_Advantage2_ResultsException() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		game.player2Scored();
		
		game.player1Scored();
		
		game.player2Scored();
		
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("Points wrong", "player2 has advantage", score); //Test when player 2 has advantage
		
	}
}

