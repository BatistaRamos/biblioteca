package swing;

import javax.swing.*;

public class JDepositarPanel extends JPanel {
	
	
	public JDepositarPanel() {
		add(new JLabel("Valor R$"));
		JTextField valor = new JTextField(8);
		add(valor);
		add(new JButton("Depositar"));
		add(new JButton("Cancelar"));
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Banco Pindorama - Teste do Painel Depositar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JDepositarPanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
