package Hangman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hangman.Game;

class testGame {

	@Test
	void testLost() {
		Game game = new Game("gameId","test");
		String output = "";
		for (int i=0;i<7;i++)
		{
			output = game.guess('a');
			System.out.println(output);
		}
		assertTrue(output.contains("Lost"));
	}

	@Test
	void testActive() {
		Game game = new Game("gameId","test");
		String output = "";
		for (int i=0;i<6;i++)
		{
			output = game.guess('a');
			System.out.println(output);
		}
		assertTrue(output.contains("Active"));
	}

	@Test
	void testWin() {
		Game game = new Game("gameId","test");
		String output = "";
		output = game.guess('t');
		System.out.println(output);
		output = game.guess('e');
		System.out.println(output);
		output = game.guess('s');
		System.out.println(output);
		assertTrue(output.contains("Won"));
	}
	
	@Test
	void testGuessAfterWin() {
		Game game = new Game("gameId","test");
		String output = "";
		output = game.guess('t');
		System.out.println(output);
		output = game.guess('e');
		System.out.println(output);
		output = game.guess('s');
		System.out.println(output);
		assertTrue(output.contains("Won"));
		output = game.guess('s');
		System.out.println(output);
		assertTrue(output.equals("error: 'Game is already complete'"));
	}
	
	@Test
	void testNumOfIncorrect() {
		Game game = new Game("gameId","test");
		String output = "";
		for (int i=0;i<7;i++)
		{
			output = game.guess('a');
			System.out.println(output);
			int index = output.indexOf(':', output.indexOf(':') + 1);
			index = output.indexOf(':', index + 1);
			int num = Character.getNumericValue(output.charAt(index+1));
			assertTrue(num==(i+1));
		}
	}
	
	@Test
	void testCorrectGuessAgainstIncorrectNumber() {
		Game game = new Game("gameId","test");
		String output = "";
		for (int i=0;i<6;i++)
		{
			output = game.guess('a');
			System.out.println(output);
		}
		output = game.guess('t');
		System.out.println(output);
		int index = output.indexOf(':', output.indexOf(':') + 1);
		index = output.indexOf(':', index + 1);
		int num = Character.getNumericValue(output.charAt(index+1));
		assertTrue(num==6);
	}
	
}
