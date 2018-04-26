package Hangman;
/*
 * Game class contains all the gaming status information necessary 
 * for the current game  
 */
public class Game {
	private STATUS status;
	private int numOfIncorrect;
	//private DataStorage storage;
	private String secretWord;
	private char[] guessedWord;
	private int remainingNumOfCharacter;
	private String gameId;
	private final int MAX_TRY = 7;

	enum STATUS{
		ACTIVE,
		WON,
		LOST
	};

	public Game(String gameId,String secretWord)
	{
		//*********get secret word********* 
		this.secretWord = secretWord;
		guessedWord = new char[secretWord.length()];
		int length = guessedWord.length;
		remainingNumOfCharacter = length;
		for (int i=0;i<length;i++)
			guessedWord[i] = '_';
		//*********get secret word*********
		//********* set up game status********
		status = STATUS.ACTIVE;
		numOfIncorrect = 0;
		this.gameId=gameId;
		//********* set up game status********
		System.out.println("gameId:"+getGameId()+", word: '"+getGuessWord()+"'");
	}


	private int getRemainingNumOfCharacter() {
		return remainingNumOfCharacter;
	}

	private void setRemainingNumOfCharacter(int remainingNumOfCharacter) {
		this.remainingNumOfCharacter = remainingNumOfCharacter;
	}

	private String getSecretWord() {
		return secretWord;
	}

	private int getNumOfIncorrect() {
		return numOfIncorrect;
	}

	private void setNumOfIncorrect(int numOfIncorrect) {
		this.numOfIncorrect = numOfIncorrect;
	}


	private STATUS getStatus() {
		return status;
	}

	private void setStatus(STATUS status) {
		this.status = status;
	}


	private String getGameId() {
		return gameId;
	}

	private String getGuessWord()
	{
		return new String(guessedWord);
	}

	private String outputGameStatus()
	{
		String result = "" , status="";
		if (getStatus() == STATUS.ACTIVE)
			status = "Active";
		else if (getStatus() == STATUS.LOST)
			status = "Lost";
		else if (getStatus() == STATUS.WON)
			status = "Won";
		result = "gameId:"+getGameId()+", word: '"+ getGuessWord() +
				"',incorrect:"+getNumOfIncorrect()+
				",status:'" + status+"'";

		return result;
	}

	private void updateGameStatus()
	{
		if (getRemainingNumOfCharacter()==0 && getNumOfIncorrect()<=MAX_TRY)
			setStatus(Game.STATUS.WON);
		else if (getNumOfIncorrect()>=MAX_TRY)
			setStatus(Game.STATUS.LOST);
	}

	private void updateGueseWord(int index , char c)
	{
		guessedWord[index] = c;
	}

	public String guess (char guessChar)
	{
		boolean hit= false;
		int index = 0; 
		if(getStatus() != Game.STATUS.ACTIVE)
		{
			return "error: 'Game is already complete'";
		}
		for (char c:getSecretWord().toCharArray())
		{
			if (c == guessChar) 
			{
				updateGueseWord(index, c);;
				setRemainingNumOfCharacter(getRemainingNumOfCharacter()-1);
				hit = true;
			}
			index++;
		}
		if (!hit)
			setNumOfIncorrect(getNumOfIncorrect()+1);	
		updateGameStatus();
		return outputGameStatus();
	}
}
