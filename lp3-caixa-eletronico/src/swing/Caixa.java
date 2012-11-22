package swing;

import javax.swing.*;

public class Caixa {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Banco Pindorama - Caixa Eletrônico");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("TODO: completar painel");
		frame.getContentPane().add(label);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu terminal = new JMenu("Terminal");
		menubar.add(terminal);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);
		
		JMenuItem exit = new JMenuItem("Sair");
		file.add(exit);
		
		Action extratoAction = new JConsultarExtratoAction();
		terminal.add(extratoAction);
		Action depositarAction = new JDepositarExtratoAction();
		terminal.add(depositarAction);		
		Action aboutAction = new JAboutAction();
		help.add(aboutAction);

		frame.setJMenuBar(menubar);

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
