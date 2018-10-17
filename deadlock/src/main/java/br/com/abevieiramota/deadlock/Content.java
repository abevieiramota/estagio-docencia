package br.com.abevieiramota.deadlock;

public class Content {
	
	/**
	 * Métodos para lidar com deadlocks
	 * 
	 * 1. Garantir que não entra em deadlock
	 * 2. Permitir deadlock, detectar e restaurar
	 * 3. Assumir qu enão vai acontecer
	 */
	
	/**
	 * Prevenção de deadlock
	 * 
	 * ! não entendi o exclusão mútua
	 * ! reter e esperar? só pode alocar todos os recursos de uma vez?
	 * 
	 * sem preempção
	 * 	> se pediu um recurso e não obteve, desaloca tudo e tenta mais tarde
	 * 
	 * ! espera circular?
	 * 
	 * informações a priori
	 * 	> simples cada processo declara o número máximo de cada tipo de recursos que vai utilizar
	 *  > dinâmico o algoritmo verifica o estado de alocação para garantir que não vai inserir um deadlock
	 *  
	 * estado de alocação
	 * 	> número de recursos alocados/disponíveis
	 *  > máximo demanda dos processos
	 * 
	 * estado seguro
	 * 	> há uma ordem entre os processo tal que
	 * 	> Pi terminou de executar, Pi+1 pode executar, sem inserir deadlock
	 * 
	 * sistema em estado seguro > sem deadlock
	 * sistema em estado inseguro > possibilidade de deadlock
	 * evitar -> garantir que o sistema não entre em estado inseguro
	 * 
	 * como evitar
	 * 	> se uma instância por tipo de recurso > grafo de alocação
	 * 	> senão, algoritmo do banqueiro
	 * 
	 * grafo
	 * 	nós
	 * 		recurso
	 * 		processo
	 * 	arestas
	 * 		está utilizando
	 * 		está esperando por
	 * 
	 * 
	 * algoritmo do banqueiro
	 * 	cada tipo de recurso pode ter uma ou mais instâncias
	 * 	cada processo requer a priori quantidades de recursos
	 * 	solicitação pode gerar alocação ou espera
	 * 	o uso de recursos é feito em tempo finito
	 * 		
	 */

}
