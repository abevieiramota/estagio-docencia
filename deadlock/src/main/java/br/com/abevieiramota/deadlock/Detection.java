package br.com.abevieiramota.deadlock;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Detection {

	private int[] disponivel;
	private int[][] alocacao;
	private int[][] requisicoes;
	private int qtdProcessos;
	private int qtdRecursos;

	public Detection(int[] disponivel, int[][] alocacao, int[][] requisicoes) {
		this.disponivel = disponivel;
		this.alocacao = alocacao;
		this.requisicoes = requisicoes;

		this.qtdProcessos = this.alocacao.length;
		this.qtdRecursos = this.alocacao[0].length;
	}

	public boolean isInDeadlock() {

		// 1.
		int[] work = Arrays.copyOf(this.disponivel, this.disponivel.length);
		// inicializa finish com quem ainda está rodando
		boolean[] finish = new boolean[this.qtdProcessos];
		for (int idProcesso = 0; idProcesso < this.qtdProcessos; idProcesso++) {
			// processo já finalizou
			if (IntStream.of(this.alocacao[idProcesso]).sum() == 0) {
				finish[idProcesso] = true;
			}
		}

		while (true) {
			// 2.
			Integer idProcessoOk = null;
			for (int idProcesso = 0; idProcesso < this.qtdProcessos; idProcesso++) {
				if(finish[idProcesso]) {
					continue;
				}
				// calcula request <= work
				boolean reqLTEWork = true;
				for (int idRecurso = 0; idRecurso < this.qtdRecursos; idRecurso++) {
					if (this.requisicoes[idProcesso][idRecurso] > work[idRecurso]) {
						reqLTEWork = false;
						break;
					}
				}

				if (reqLTEWork) {
					idProcessoOk = idProcesso;
					break;
				}
			}

			// 3.
			if (idProcessoOk != null) {
				// work = work + alocattion
				for (int idRecurso = 0; idRecurso < this.qtdRecursos; idRecurso++) {
					work[idRecurso] += this.alocacao[idProcessoOk][idRecurso];
				}

				finish[idProcessoOk] = true;
			} else {
				// 4.
				for (int idProcesso = 0; idProcesso < this.qtdProcessos; idProcesso++) {
					if (!finish[idProcesso]) {
						return true;
					}
				}

				return false;
			}
		}
	}

}
