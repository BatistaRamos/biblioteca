package swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class JConsultarExtratoAction  extends AbstractAction {

	public JConsultarExtratoAction() {
		super("Consultar Extrato");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Extrato...");
	}
}
