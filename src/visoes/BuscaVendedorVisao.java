package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controladoras.VendasControladora;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class BuscaVendedorVisao {

	private JFrame BuscaVendedor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private VendasControladora vendasControladora;
	
	public JFrame getFrame() {
		return BuscaVendedor;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuscaVendedorVisao window = new BuscaVendedorVisao();
//					window.BuscaVendedor.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BuscaVendedorVisao(VendasControladora vendasControladora) {
		this.vendasControladora = vendasControladora;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BuscaVendedor = new JFrame();
		BuscaVendedor.setTitle("BUSCAR VENDEDOR");
		BuscaVendedor.setBounds(100, 100, 623, 665);
		BuscaVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BuscaVendedor.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 112, 201, 20);
		BuscaVendedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(61, 115, 46, 14);
		BuscaVendedor.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(61, 146, 46, 14);
		BuscaVendedor.getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(61, 178, 46, 14);
		BuscaVendedor.getContentPane().add(lblEmail);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(61, 209, 46, 14);
		BuscaVendedor.getContentPane().add(lblCidade);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 143, 201, 20);
		BuscaVendedor.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 175, 201, 20);
		BuscaVendedor.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 206, 201, 20);
		BuscaVendedor.getContentPane().add(textField_3);
	}
}
