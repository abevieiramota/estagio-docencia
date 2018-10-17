package br.com.abevieiramota.deadlock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SafetyTest {

	@Test
	// https://pt.wikipedia.org/wiki/Algoritmo_do_banqueiro
	public void testSafeCaseWikipedia1() {
		int[] available = { 3, 1, 1, 2 };
		int[][] max = { { 3, 3, 2, 2 }, { 1, 2, 3, 4 }, { 1, 1, 5, 0 } };
		int[][] allocation = { { 1, 2, 2, 1 }, { 1, 0, 3, 3 }, { 1, 1, 1, 0 } };

		Safety safety = new Safety(available, max, allocation);

		assertTrue(safety.isSafe());
	}

	@Test
	// https://pt.wikipedia.org/wiki/Algoritmo_do_banqueiro
	public void testSafeCaseWikipedia2() {
		int[] available = { 3, 1, 0, 2 };
		int[][] max = { { 3, 3, 2, 2 }, { 1, 2, 3, 4 }, { 1, 1, 5, 0 } };
		int[][] allocation = { { 1, 2, 2, 1 }, { 1, 0, 3, 3 }, { 1, 1, 2, 0 } };

		Safety safety = new Safety(available, max, allocation);

		assertTrue(safety.isSafe());
	}

	@Test
	// https://pt.wikipedia.org/wiki/Algoritmo_do_banqueiro
	public void testSafeCaseWikipedia3() {
		int[] available = { 3, 0, 1, 2 };
		int[][] max = { { 3, 3, 2, 2 }, { 1, 2, 3, 4 }, { 1, 1, 5, 0 } };
		int[][] allocation = { { 1, 2, 2, 1 }, { 1, 1, 3, 3 }, { 1, 1, 1, 0 } };

		Safety safety = new Safety(available, max, allocation);

		assertFalse(safety.isSafe());
	}

	@Test
	public void testExemploDosSlides() {
		int[] available = { 10, 5, 7 };
		int[][] max = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 }, { 4, 3, 3 } };
		int[][] allocation = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 }, { 0, 0, 2 } };

		Safety safety = new Safety(available, max, allocation);

		assertTrue(safety.isSafe());
	}

}
