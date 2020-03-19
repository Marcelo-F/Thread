package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {
	public static void main(String[] args) throws InterruptedException {
		/*Thread processando em paralelo de e-mail*/
		Thread threademail = new Thread(thread1);
		threademail.start();
		
		
		/*Thread processando em paralelo de nota fiscal*/
		Thread threadNFCE = new Thread(thread2);
		threadNFCE.start();

		/* Fluxo do sistema */
		JOptionPane.showInternalMessageDialog(null, "Sistema continua executando para o usuário");

	}
	
	private static Runnable thread2  = new Runnable() {
		
		@Override
		public void run() {
			for (int pos = 0; pos < 10; pos++) {/* Código da rotina que eu quero executar em paralelo */
				System.out.println("Executando algo  rotina, por exemplo envio de nfe");

				try {
					Thread.sleep(1000); /* tempo de intervalo a cada execução */
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	};

	private static Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			for (int pos = 0; pos < 10; pos++) {/* Código da rotina que eu quero executar em paralelo */
				System.out.println("Executando algo  rotina, por exemplo aviso  de e-mail");

				try {
					Thread.sleep(2000); /* tempo de intervalo a cada execução */
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	};

}