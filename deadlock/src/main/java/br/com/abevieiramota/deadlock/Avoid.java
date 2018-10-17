package br.com.abevieiramota.deadlock;

import java.util.Arrays;

public class Avoid {
	
	public static enum Resultado {
		EXCEDEU_LIMITE_DE_REQUISICOES, ESPERA_POR_RECURSOS, RECURSOS_ALOCADOS, UNSAFE
	}

	// resources identificados pelo index
	private int[] disponivel;
	// resources e processes identificados pelo index
	// processo x recurso
	private int[][] max;
	// resources e processes identificados pelo index
	// processo x recurso
	private int[][] alocaco;
	// need = max - allocation
	// private int[][] need;
	private int qtdRecursos;

	public Avoid(int[] disponivel, int[][] max, int[][] alocacao) {
		this.disponivel = disponivel;
		this.max = max;
		this.alocaco = alocacao;

		this.qtdRecursos = this.max[0].length;
	}

	public Resultado isVaiPraUnsafe(int[] requisicao, int idProcesso) {
		
		// verifica se não extrapolou need (o quanto ainda pode alocar, em relação ao que foi declarado)
		boolean extrapolouNeed = false;
		for (int i = 0; i < this.qtdRecursos; i++) {
			int iNeed = this.max[idProcesso][i] - this.alocaco[idProcesso][i];
			if (requisicao[i] > iNeed) {
				extrapolouNeed = true;
				break;
			}
		}
		
		if (extrapolouNeed) {
			return Resultado.EXCEDEU_LIMITE_DE_REQUISICOES;
		}
		
		
		// verifica se não extrapolou disponível
		boolean extrapolouDisponivel = false;
		for (int i = 0; i < this.qtdRecursos; i++) {
			if (this.disponivel[i] < requisicao[i]) {
				extrapolouDisponivel = true;
				break;
			}
		}
		
		if (extrapolouDisponivel) {
			return Resultado.ESPERA_POR_RECURSOS;
		}
		
		// calcula 
		//    available - request
		//    alocation + request
		int[] testDisponivel = Arrays.copyOf(this.disponivel, this.disponivel.length);
		int[][] testMax = Arrays.copyOf(this.max, this.max.length);
		int[][] testAlocacao = Arrays.copyOf(this.alocaco, this.alocaco.length);
		
		for(int i = 0; i < this.qtdRecursos; i++) {
			testDisponivel[i] -= requisicao[i];
			testAlocacao[idProcesso][i] += requisicao[i];
		}
		
		Safety safety = new Safety(testDisponivel, testMax, testAlocacao);
		
		return safety.isSafe() ? Resultado.RECURSOS_ALOCADOS: Resultado.UNSAFE;
	}

}
