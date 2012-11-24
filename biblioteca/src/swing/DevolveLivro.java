
package swing;

import javax.swing.*;

public class DevolveLivro extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DevolveLivro() {
		add(new JLabel("Código do Livro"));
		JTextField codigo = new JTextField(8);
		add(codigo);
		add(new JButton("Devolver livro"));
		add(new JButton("Cancelar"));
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