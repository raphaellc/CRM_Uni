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

public class BuscaProdutoVisao {

	private JFrame BuscaProduto;
	private VendasControladora vendasControladora;
	private JTextField id_produto;
	private JTextField qntd_produto;
	private JTextField preco_unitario;
	private JTextField valor_final;
	private JTextField textField;

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
		BuscaProduto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 10, 97, 25);
		BuscaProduto.getContentPane().add(lblNewLabel);
		
		id_produto = new JTextField();
		id_produto.setBounds(31, 45, 184, 19);
		BuscaProduto.getContentPane().add(id_produto);
		id_produto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 129, 85, 17);
		BuscaProduto.getContentPane().add(lblNewLabel_1);
		
		qntd_produto = new JTextField();
		qntd_produto.setBounds(31, 148, 183, 19);
		BuscaProduto.getContentPane().add(qntd_produto);
		qntd_produto.setColumns(10);
		
		JButton adicionarProduto = new JButton("Adicionar Produto");
		adicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adicionarProduto.setBounds(31, 196, 153, 25);
		BuscaProduto.getContentPane().add(adicionarProduto);
		
		JButton terminarCompra = new JButton("Terminar Compra");
		terminarCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		terminarCompra.setBounds(254, 196, 143, 25);
		BuscaProduto.getContentPane().add(terminarCompra);
		
		JLabel label_unitario = new JLabel("Preço Uniário");
		label_unitario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_unitario.setBounds(287, 10, 85, 25);
		BuscaProduto.getContentPane().add(label_unitario);
		
		preco_unitario = new JTextField();
		preco_unitario.setBounds(287, 45, 110, 19);
		BuscaProduto.getContentPane().add(preco_unitario);
		preco_unitario.setColumns(10);
		
		JLabel cifrao = new JLabel("R$");
		cifrao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cifrao.setBounds(265, 46, 45, 13);
		BuscaProduto.getContentPane().add(cifrao);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Final");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(252, 125, 96, 25);
		BuscaProduto.getContentPane().add(lblNewLabel_2);
		
		valor_final = new JTextField();
		valor_final.setBounds(252, 148, 145, 19);
		BuscaProduto.getContentPane().add(valor_final);
		valor_final.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(225, 149, 45, 13);
		BuscaProduto.getContentPane().add(lblNewLabel_3);
		
		JButton buscarProduto = new JButton("Busca Produto");
		buscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buscarProduto.setBounds(104, 14, 111, 21);
		BuscaProduto.getContentPane().add(buscarProduto);
		
		textField = new JTextField();
		textField.setBounds(31, 91, 366, 31);
		BuscaProduto.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(31, 68, 97, 13);
		BuscaProduto.getContentPane().add(lblNewLabel_4);
	}
}
