package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

import swing.action.JAboutMenuAction;
import swing.action.JConsultarLivroMenuAction;
import swing.action.JDevolverMenu;
import swing.action.JSair;

public class Estante {
	public static final String PRINCIPAL = "PRINCIPAL";

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("BIBLIOTECA  DO BATISTA");
		CardLayout cards = new CardLayout();
		//http://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		JPanel principal = new JPanel(cards);

		JPanel consultarLivro = new JConsultarLivroPanel(principal, cards);
		JPanel depositar = new JDevolverPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel("BIBLIOTECA  DO BATISTA");
		vazio.add(label);
		
		principal.add(vazio, PRINCIPAL);
		principal.add(depositar, JDevolverMenu.DEVOLVER1);
		principal.add(consultarLivro, JConsultarLivroMenuAction.CONSULTAR1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("biblioteca.jpg").getImage());
		
		frame.getContentPane().add(principal);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu terminal = new JMenu("Terminal");
		menubar.add(terminal);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);
		
		Action exitAction = new JSair();
		file.add(exitAction);
		
		Action extratoAction = new JConsultarLivroMenuAction(principal,cards);
		terminal.add(extratoAction);
		Action devolverAction = new JDevolverMenu(principal,cards);
		terminal.add(devolverAction);		
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);

		frame.setJMenuBar(menubar);
		
		frame.setMinimumSize(new Dimension(400,200));

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
