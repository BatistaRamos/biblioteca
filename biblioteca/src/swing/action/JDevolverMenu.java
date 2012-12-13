package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JDevolverMenu  extends AbstractAction {
	public static final String DEVOLVER1 = "DEVOLVER1";

	private JPanel principal;
	private CardLayout cards;
	
	public JDevolverMenu(JPanel principal, CardLayout cards) {
		super("DEVOLVER");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, DEVOLVER1);
	}
}