package br.com.abevieiramota.deadlock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DetectionTest {

	@Test
	// p.40
	public void testExemploDosSlides1() {

		int[] disponivel = { 0, 0, 0 };
		int[][] alocacao = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 3 }, { 2, 1, 1 }, { 0, 0, 2 } };
		int[][] requisicoes = { { 0, 0, 0 }, { 2, 0, 2 }, { 0, 0, 0 }, { 1, 0, 0 }, { 0, 0, 2 } };

		Detection detection = new Detection(disponivel, alocacao, requisicoes);

		assertFalse(detection.isInDeadlock());
	}

	@Test
	// p.41
	public void testExemploDosSlides2() {

		int[] disponivel = { 0, 0, 0 };
		int[][] alocacao = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 3 }, { 2, 1, 1 }, { 0, 0, 2 } };
		int[][] requisicoes = { { 0, 0, 0 }, { 2, 0, 2 }, { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 2 } };

		Detection detection = new Detection(disponivel, alocacao, requisicoes);

		assertTrue(detection.isInDeadlock());
	}
}
