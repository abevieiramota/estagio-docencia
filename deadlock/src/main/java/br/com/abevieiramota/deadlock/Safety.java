package br.com.abevieiramota.deadlock;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Safety {

	// resources identificados pelo index
	private int[] disponivel;
	// resources e processes identificados pelo index
	// processo x recurso
	private int[][] max;
	// resources e processes identificados pelo index
	// processo x recurso
	private int[][] alocacao;
	// need = max - allocation
	// private int[][] need;
	private int qtdProcessos;
	private int qtdRecursos;

	public Safety(int[] disponivel, int[][] max, int[][] alocacao) {
		this.disponivel = disponivel;
		this.max = max;
		this.alocacao = alocacao;

		this.qtdProcessos = this.max.length;
		this.qtdRecursos = this.max[0].length;
	}

	// https://pt.wikipedia.org/wiki/Algoritmo_do_banqueiro
	public boolean isSafe() {

		Set<Integer> naoFinalizados = IntStream.range(0, this.qtdProcessos).boxed().collect(Collectors.toSet());

		int[] disponivel = Arrays.copyOf(this.disponivel, this.disponivel.length);

		while (!naoFinalizados.isEmpty()) {
			boolean achou = false;

			Iterator<Integer> iterNaoFinalizados = naoFinalizados.iterator();
			while (iterNaoFinalizados.hasNext()) {

				Integer idProcesso = iterNaoFinalizados.next();

				// calcula o necessário para concluir o processo
				int[] need = new int[this.qtdRecursos];

				for (int i = 0; i < this.qtdRecursos; i++) {
					need[i] = this.max[idProcesso][i] - this.alocacao[idProcesso][i];
				}

				// verifica se há disponível
				boolean haRecursos = true;
				for (int i = 0; i < this.qtdRecursos; i++) {
					if (disponivel[i] < need[i]) {
						haRecursos = false;
						break;
					}
				}

				if (haRecursos) {

					// simulando que alocamos recursos para o processo e ele liberou o que estava
					// utilizando
					for (int i = 0; i < this.qtdRecursos; i++) {
						// desaloco os recursos do processo
						disponivel[i] += this.alocacao[idProcesso][i];
					}

					// removo da lista dos não finalizados
					iterNaoFinalizados.remove();
					// indico que encontrei um processo para executar
					achou = true;
				}

			}

			if (!achou) {
				// se percorri os processos e não consegui executar pelo menos um, o estado não
				// é seguro
				return false;
			}
		}

		return true;
	}

}
