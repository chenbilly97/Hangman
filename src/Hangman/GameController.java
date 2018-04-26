package Hangman;

import java.util.HashMap;
import java.util.UUID;

public class GameController {
	// game hashmap contains all the game instance accociated with unique gameId
	private HashMap<String,Game> gameMap;
	private DataStorage db;
	public GameController(DataStorage db)
	{
		gameMap = new HashMap<String,Game>();
		this.db = db;
	}

	/*
	 * Create new game instance with unique gameId
	 * Store the reference of game instance to the map with associate gameId
	 */
	public String createNewGame()
	{
		String gameId = UUID.randomUUID().toString();
		Game game = new Game(gameId,db.getWord());
		gameMap.put(gameId, game);
		return gameId;
	}

	public Game getGame(String gameId)
	{
		return gameMap.get(gameId);
	}


	/*
	 * this method will delegate the responsibility to the correct game instance 
	 * with the associate gameId
	 */
	public String guess(String gameId , char character) 
	{
		Game currentGame = this.getGame(gameId);
		if (currentGame == null)
			return "invalid gameId";
		return currentGame.guess(character);
	}
}
