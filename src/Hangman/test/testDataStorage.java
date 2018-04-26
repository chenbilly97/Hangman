package Hangman.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hangman.DataStorage;

class testDataStorage {
	DataStorage db = DataStorage.getInstance();

	@Test
	void testEmpty() {
		int count = 0;
		while (count<1000)
		{
			String word = db.getWord();
			assertTrue(word!="");
			count++;
		}
	}

	@Test
	void testContainOnlyLowerCaseLetter() {
		int count =0;
		while (count<1000)
		{
			String word = db.getWord();
			assertTrue(word.matches("[a-z]+"));
			count++;
		}
	}
}
