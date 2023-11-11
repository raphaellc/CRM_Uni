package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladoras.VendasControladora;

public class BuscaClientesVisao {

	private JFrame BuscaCliente;
	private VendasControladora vendasControladora;

	public JFrame getFrame() {
		return BuscaCliente;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuscaClientesVisao window = new BuscaClientesVisao();
//					window.BuscaCliente.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BuscaClientesVisao(VendasControladora vendasControladora) {
		this.vendasControladora = vendasControladora;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BuscaCliente = new JFrame();
		BuscaCliente.setTitle("BUSCA CLIENTE");
		BuscaCliente.setBounds(100, 100, 450, 300);
		BuscaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
