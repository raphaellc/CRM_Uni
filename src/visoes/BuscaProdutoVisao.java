package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladoras.VendasControladora;

public class BuscaProdutoVisao {

	private JFrame BuscaProduto;
	private VendasControladora vendasControladora;

	public JFrame getFrame() {
		return BuscaProduto;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuscaProdutoVisao window = new BuscaProdutoVisao();
//					window.BuscaProduto.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BuscaProdutoVisao(VendasControladora vendasControladora) {
		this.vendasControladora = vendasControladora;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BuscaProduto = new JFrame();
		BuscaProduto.setTitle("BUSCAR PRODUTO");
		BuscaProduto.setBounds(100, 100, 450, 300);
		BuscaProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
