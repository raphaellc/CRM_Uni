package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladoras.VendasControladora;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class BuscaProdutoVisao {

	private JFrame BuscaProduto;
	private VendasControladora vendasControladora;
	private JTextField preco_unitario;
	private JTextField valor_final;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		BuscaProduto.getContentPane().setBackground(SystemColor.controlHighlight);
		BuscaProduto.setTitle("BUSCAR PRODUTO");
		BuscaProduto.setBounds(100, 100, 700, 477);
		BuscaProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BuscaProduto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 106, 97, 25);
		BuscaProduto.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 296, 85, 17);
		BuscaProduto.getContentPane().add(lblNewLabel_1);
		
		JButton adicionarProduto = new JButton("Adicionar Produto");
		adicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adicionarProduto.setBounds(126, 312, 153, 27);
		BuscaProduto.getContentPane().add(adicionarProduto);
		
		JButton terminarCompra = new JButton("Finalizar Compra");
		terminarCompra.setBackground(Color.CYAN);
		terminarCompra.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		terminarCompra.setBounds(466, 373, 168, 25);
		BuscaProduto.getContentPane().add(terminarCompra);
		
		JLabel label_unitario = new JLabel("Preço Uniário");
		label_unitario.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_unitario.setBounds(521, 106, 133, 25);
		BuscaProduto.getContentPane().add(label_unitario);
		
		preco_unitario = new JTextField();
		preco_unitario.setBounds(511, 127, 123, 25);
		BuscaProduto.getContentPane().add(preco_unitario);
		preco_unitario.setColumns(10);
		
		JLabel cifrao = new JLabel("R$");
		cifrao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cifrao.setBounds(490, 131, 45, 13);
		BuscaProduto.getContentPane().add(cifrao);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Final");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(526, 292, 96, 25);
		BuscaProduto.getContentPane().add(lblNewLabel_2);
		
		valor_final = new JTextField();
		valor_final.setBounds(506, 315, 128, 25);
		BuscaProduto.getContentPane().add(valor_final);
		valor_final.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(466, 319, 45, 13);
		BuscaProduto.getContentPane().add(lblNewLabel_3);
		
		JButton buscarProduto = new JButton("Buscar ...");
		buscarProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buscarProduto.setBounds(152, 125, 110, 27);
		BuscaProduto.getContentPane().add(buscarProduto);
		
		textField = new JTextField();
		textField.setBounds(31, 183, 603, 90);
		BuscaProduto.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(31, 167, 97, 13);
		BuscaProduto.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 127, 110, 25);
		BuscaProduto.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(31, 315, 85, 25);
		BuscaProduto.getContentPane().add(textField_2);
		
		JLabel lblProduto = new JLabel("PRODUTO");
		lblProduto.setForeground(Color.CYAN);
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblProduto.setEnabled(false);
		lblProduto.setBounds(228, 40, 194, 50);
		BuscaProduto.getContentPane().add(lblProduto);
	}
}
