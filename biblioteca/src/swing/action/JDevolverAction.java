package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.Estante;
import estante.EstanteDAO;
import estante.User;

@SuppressWarnings("serial")
public class JDevolverAction extends AbstractAction {
	//public static void main(String[] args)
	private JPanel principal;
	private CardLayout cards;

	private JTextField titulo;

	public JDevolverAction(JPanel principal, CardLayout cards,
			JTextField titulo) {
		super("DEVOLVER");
		this.principal = principal;
		this.cards = cards;
		this.titulo = titulo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EstanteDAO estante = new EstanteDAO();
		User c = estante.finduser("1", "a");
		if (c == null) {
			System.out.println("user não encontrada!");
			JOptionPane.showMessageDialog(principal.getRootPane(),
					"user não encontrada!", "Operação cancelada",
					JOptionPane.ERROR_MESSAGE);

		} else {
			String v;
			try {
				v = (titulo.getText());
				estante.depositar(c, v);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(
						(principal == null? null : principal.getRootPane()),
						String.format("titulo inválido [R$ %s]!",
								titulo.getText()), "Operação cancelada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (principal != null) {
			cards.show(principal, Estante.PRINCIPAL);
		}

	}
}
