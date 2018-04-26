package Hangman;
import java.util.Scanner;

public class GameDriver {
	public static void main(String[] args) throws Exception
	{

		//set up database here
		DataStorage db = DataStorage.getInstance();
		GameController controller = new GameController(db);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);	
		while (true)
		{
			System.out.println("\n\nPlease enter your command here\n (1)type new for new game\n (2)type {gameId,char} to continue a game\n (3)type exit to terminate program");
			String input = scanner.nextLine(); 
			if (input.toLowerCase().equals("new"))
			{
				controller.createNewGame();
			}
			else if (input.toLowerCase().equals("exit"))
			{
				System.out.println("Terminate program");
				break;
			}
			else
			{
				int indexOfComma = input.indexOf(',');
				if (indexOfComma>0)
				{
					String gameId = input.substring(0, indexOfComma);
					String guess = input.substring(indexOfComma+1,input.length());
					char g = 0 ;
					if (guess.length()==1)
					{
						g = guess.charAt(0);
						System.out.println(controller.guess(gameId, g));
					}
					else
						System.out.println("Invalid Character");
				}
			}
		}

	}
}
