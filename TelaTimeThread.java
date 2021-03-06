package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TelaTimeThread extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout());/* Painel de controle */

	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricaoHora2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jButton = new JButton("Add lista");
	private JButton jButton2 = new JButton("Stop");
	private JButton jButton3 = new JButton("Continuar");


	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaTimeThread() {/* Executar dentro no momento da abertura ou execu��o */
		setTitle("Minha tela de time com thread");

		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		//setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints(); /* Controlador de posicionamento */
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		/*------Time thread1------*/

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);

		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;

		jPanel.add(mostraTempo, gridBagConstraints);

		/*------Time thread2------*/

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;

		jPanel.add(mostraTempo2, gridBagConstraints);
		
		
		
		

		/*----Bot�o-----*/

		gridBagConstraints.gridwidth = 1;
		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(jButton, gridBagConstraints);

		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jButton2, gridBagConstraints);

		
		jButton3.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jButton3, gridBagConstraints);

		
		/* A��ES PARA OS BUT�ES */

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				
				for(int qtd=0; qtd < 5; qtd ++) { /*simulando 100 envios em massa*/ 
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(mostraTempo.getText());
				filaThread.setEmail(mostraTempo2.getText() + "-"+ qtd);
				
				fila.add(filaThread);
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fila.stop();
				fila = null; 
			
				
			}
		});
		
		
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			

				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
					
					
				}
					
			
		});

		fila.start();
		add(jPanel, BorderLayout.WEST);
		setVisible(true); /* Torna a tela visivel para o usu�rio */

	}

}
