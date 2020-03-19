package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	public void run() {
		System.out.println("Fila  rodando");
		
		
		while(true) {
		synchronized (pilha_fila) { /*Bloquear acesso a esta lista por outros processos*/
			Iterator iteracao = pilha_fila.iterator();

			while (iteracao.hasNext()) { /* Enquanto conter dados na lista ir� processar */

				ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();/* pega o objeto atual */

				/* Aqui vir� o c�digo para processar a fila em massa */
				System.out.println(processar.getNome());
				System.out.println(processar.getEmail());
				System.out.println("------------------------");

				iteracao.remove(); /* remove o item que foi processado */

				try {
					Thread.sleep(1000); /*
										 * tempo entre um processo e outro (1000 = 1 seg), serve para descarga a mem�ria
										 * do S.O
										 */
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(1000); /* Ap�s o processo da lista ser� dado um tempo para limpesa de mem�ria */
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
			}
			}

		}
		
	}


}


