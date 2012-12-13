package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class JSair extends AbstractAction {

	public JSair() {
		super("Sair");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}