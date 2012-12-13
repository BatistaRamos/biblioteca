package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.action.JDevolverAction;
import swing.action.JDevolverClose;

@SuppressWarnings("serial")
public class JDevolverPanel extends JPanel {

	JTextField titulo;
	public JDevolverPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("TITULO DO LIVRO"));
		titulo = new JTextField(8);
		add(titulo);
		add(new JButton(new JDevolverAction(principal, cards, titulo)));
		add(new JButton(new JDevolverClose(principal, cards)));
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JDevolverPanel::setVisible %b\n", aFlag);
		titulo.setText("");
	}

	public JDevolverPanel() {
		this(null, null);
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("BIBLIOTECA DO BATISTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JDevolverPanel();
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
