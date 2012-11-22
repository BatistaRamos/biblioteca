package swing;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class JDepositarExtratoAction  extends AbstractAction {

	public JDepositarExtratoAction() {
		super("Depositar");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Depositar...");
	}
}