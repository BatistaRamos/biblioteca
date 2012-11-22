package swing;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class JConsultarExtratoAction  extends AbstractAction {

	public JConsultarExtratoAction() {
		super("Consultar Extrato");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Extrato...");
	}
}
