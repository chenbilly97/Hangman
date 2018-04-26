package Hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class DataStorage {
	private static final DataStorage db = new DataStorage();
	private List<String> wordList; 

	public DataStorage()
	{
		wordList = new ArrayList<String>();
		readFile("words.txt");
	}

	public static DataStorage getInstance()
	{
		return db;
	}

	@SuppressWarnings("resource")
	private void readFile(String fileName)
	{	
		if (wordList.size()!=0)
			return ;
		Scanner scanner=null;
		try 
		{
			scanner = new Scanner(getClass().getResourceAsStream(fileName));
		} catch (NullPointerException e)
		{
			System.out.println("File not exist, please select a valid file next time");
			return;
		}
		while (scanner!=null && scanner.hasNext())
			wordList.add(scanner.next());
	}

	/*
	 * return the size of the wordList storage
	 */
	private int size()
	{
		return wordList.size();
	}

	/*
	 * get the random string from the storage
	 * remove all the special character 
	 * only return the loercase string 
	 */
	public String getWord()
	{
		if (size()!=0)
		{
			int selectedIndex = (int) (Math.random()*size());
			String selectedWord = wordList.get(selectedIndex);
			StringBuilder sb = new StringBuilder();
			for (char c:selectedWord.toCharArray())
				if (((int)c >=65 && (int)c<=90) || ((int)c >=97 && (int)c<=122))
					sb.append(c);
			return sb.toString().toLowerCase();
		}
		return "";
	}
}
