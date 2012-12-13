package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import swing.action.JDevolverClose;
import estante.EstanteDAO;
import estante.User;
import estante.Operacao;

@SuppressWarnings("serial")
public class JConsultarLivroPanel extends JPanel {
	JTextArea dados;
	public JConsultarLivroPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(40,80); 
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JDevolverClose(principal, cards)));
	}

	public JConsultarLivroPanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JDevolverPanel::setVisible %b\n", aFlag);
		
		EstanteDAO estante = new EstanteDAO();
		User c = estante.finduser("1", "a");
		if (c == null) {
			System.out.println("user não encontrada!");
			//FIXME: comunicar erro ao programa
		} else {
			System.out.println(c);
			List<Operacao> ops = estante.consultarLivro(c);
			String s = "";
			for (Operacao operacao : ops) {
				s += String.format("Livro",operacao.gettitulo());
			}
			dados.setText(s);
		}		
		
	}	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("LIVRARIA DO BATISTA-CONSULTA DE LIVRO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarLivroPanel();
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
