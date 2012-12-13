package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.Estante;

@SuppressWarnings("serial")
public class JDevolverClose extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JDevolverClose(JPanel principal, CardLayout cards) {
		super("Fechar");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			cards.show(principal, Estante.PRINCIPAL);
		}

	}
}
