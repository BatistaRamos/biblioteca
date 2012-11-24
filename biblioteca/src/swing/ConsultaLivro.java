package swing;

import javax.swing.*;

@SuppressWarnings("serial")
public class ConsultaLivro extends JPanel {
	
	
	public ConsultaLivro() {
		add(new JLabel("Consultar Livro"));
		JTextField codigo = new JTextField(8);
		add(codigo);
		add(new JButton("Conulta Disponibilidade"));
		add(new JButton("Cancela"));
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Livraria do Batista");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new DevolveLivro();
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