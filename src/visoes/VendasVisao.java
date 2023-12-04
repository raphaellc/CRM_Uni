package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladoras.VendasControladora;
import controladoras.PessoaControladora;
import controladoras.ProdutoControladora;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.ItemEvent;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dtos.VendasDto;

public class VendasVisao {

	private JFrame Vendas;
	private JTextField descVendedor;
	private JTextField descCliente;
	private JTextField descProduto;
	private JTextField textField_3;
	private VendasControladora vendasControladora;

	private PessoaControladora pessoaControladora;
	private ProdutoControladora produtoControladora;
	String frm_pagamento[] = {"Forma de pagamento", "PIX", "Dinheiro", "Crédito", "Débito"};

	String[] columnNames = {"CÓD", "DESCRIÇÃO", "QTD", "VALOR"};
	static JTable table;
	String from;
	PreparedStatement pst;
	Connection con;
	
	public JFrame getFrame() {
		return Vendas;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VendasVisao window = new VendasVisao();
//					window.Vendas.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public VendasVisao(VendasControladora vendasControladora, PessoaControladora pessoaControladora, ProdutoControladora produtoControladora) {
		this.vendasControladora = vendasControladora;
		this.pessoaControladora = pessoaControladora;
		this.produtoControladora = produtoControladora;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		Vendas = new JFrame();
		Vendas.setBackground(new Color(255, 255, 255));
		Vendas.setBounds(100, 100, 754, 600);
		Vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vendas.getContentPane().setLayout(null);
		

		Vendedor = new JTextField();
		Vendedor.setBounds(233, 103, 363, 19);
		Vendas.getContentPane().add(Vendedor);
		Vendedor.setColumns(10);
		
		//DEPENDE DA INTEGRAÇÃO COM UC1

		JButton buscar_vendedor = new JButton("");
		buscar_vendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemContato buscaVendedor = new TelaListagemContato(pessoaControladora);
				buscaVendedor.getFrame().setVisible(true);
				Vendas.setVisible(false);
			}
		});
		buscar_vendedor.setIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive - Associacao Antonio Vieira\\Área de Trabalho\\UNISINOS\\3° SEMESTRE\\POO\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));

		buscar_vendedor.setBounds(618, 97, 25, 25);
		Vendas.getContentPane().add(buscar_vendedor);
		
		JLabel lblNewLabel = new JLabel("Vendedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(75, 79, 106, 13);
		Vendas.getContentPane().add(lblNewLabel);
		
		descVendedor = new JTextField();
		descVendedor.setBounds(75, 103, 533, 19);
		Vendas.getContentPane().add(descVendedor);
		descVendedor.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setBounds(75, 133, 79, 13);
		Vendas.getContentPane().add(lblCliente);
		
		descCliente = new JTextField();
		descCliente.setColumns(10);
		descCliente.setBounds(75, 156, 533, 19);
		Vendas.getContentPane().add(descCliente);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduto.setBounds(75, 186, 106, 13);
		Vendas.getContentPane().add(lblProduto);
		
		descProduto = new JTextField();
		descProduto.setColumns(10);
		descProduto.setBounds(75, 210, 533, 19);
		Vendas.getContentPane().add(descProduto);
		
		JLabel lblPagamento = new JLabel("Formas de pagamento");
		lblPagamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPagamento.setBounds(75, 483, 183, 25);
		Vendas.getContentPane().add(lblPagamento);
		
//		JLabel lblCd = new JLabel("CÓD");
//		lblCd.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblCd.setBounds(95, 245, 79, 27);
//		Vendas.getContentPane().add(lblCd);
//		
//		JLabel lblDescrioDoProduto = new JLabel("DESCRIÇÃO DO PRODUTO");
//		lblDescrioDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblDescrioDoProduto.setBounds(158, 245, 209, 27);
//		Vendas.getContentPane().add(lblDescrioDoProduto);
//		
//		JLabel lblCd_1 = new JLabel("QTD");
//		lblCd_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblCd_1.setBounds(527, 245, 47, 27);
//		Vendas.getContentPane().add(lblCd_1);
//		
//		JLabel lblCd_2 = new JLabel("VLR");
//		lblCd_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblCd_2.setBounds(587, 245, 79, 27);
//		Vendas.getContentPane().add(lblCd_2);
//		
//		JLabel lblProduto_1 = new JLabel("TOTAL");
//		lblProduto_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblProduto_1.setBounds(527, 444, 63, 13);
//		Vendas.getContentPane().add(lblProduto_1);
		
//////////////////////
		
		DefaultTableModel modelProduto = new DefaultTableModel();
        modelProduto.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table = new JTable();
        table.setBounds(75, 249, 514, 184);
        table.setModel(modelProduto);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        Vendas.getContentPane().add(table);
        
 ///////////////////////
        
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(587, 443, 56, 25);
		Vendas.getContentPane().add(textField_3);
		
		JButton btnNewButton_1_1 = new JButton("Finalizar compra");
		btnNewButton_1_1.setBackground(Color.CYAN);
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(512, 507, 131, 25);
		Vendas.getContentPane().add(btnNewButton_1_1);
		
		List nome_produto = new List();
		nome_produto.setBounds(180, 269, 365, 168);
		nome_produto.add("ProdutoDto.nomeProduto");
		Vendas.getContentPane().add(nome_produto);
		
		List cod_item = new List();
		cod_item.setBounds(117, 269, 59, 168);
		Vendas.getContentPane().add(cod_item);
		
		List qtd_item = new List();
		qtd_item.setBounds(549, 269, 56, 168);
		Vendas.getContentPane().add(qtd_item);
		
		List valor_item = new List();
		valor_item.setBounds(609, 269, 56, 168);
		Vendas.getContentPane().add(valor_item);
		
	    @SuppressWarnings({ "rawtypes" })
		final DefaultComboBoxModel modelPagamento = new DefaultComboBoxModel(frm_pagamento);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecionar ...", "PIX", "Dinheiro", "Crédito", "Débito"}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBounds(75, 509, 131, 24);
		Vendas.getContentPane().add(comboBox);
		
		//DEPENDE DA INTEGRAÇÃO COM UC1
		JButton buscar_cliente = new JButton("");
		buscar_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemContato buscarCliente = new TelaListagemContato(pessoaControladora);
				buscarCliente.getFrame().setVisible(true);
				Vendas.setVisible(false);
			}
		});
		buscar_cliente.setIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive - Associacao Antonio Vieira\\Área de Trabalho\\UNISINOS\\3° SEMESTRE\\POO\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_cliente.setBounds(618, 150, 25, 25);
		Vendas.getContentPane().add(buscar_cliente);
		
		//DEPENDE DA INTEGRAÇÃO COM OS PRODUTOS
		JButton buscar_produto = new JButton("");
		buscar_produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemProduto buscarProduto = new TelaListagemProduto(produtoControladora);
				buscarProduto.getFrame().setVisible(true);
				Vendas.setVisible(false);
			}
		});
		buscar_produto.setIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive - Associacao Antonio Vieira\\Área de Trabalho\\UNISINOS\\3° SEMESTRE\\POO\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_produto.setBounds(618, 204, 25, 25);
		Vendas.getContentPane().add(buscar_produto);
		
		JLabel lblVendas = new JLabel("VENDAS");
		lblVendas.setForeground(Color.CYAN);
		lblVendas.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblVendas.setEnabled(false);
		lblVendas.setBounds(265, 21, 194, 50);
		Vendas.getContentPane().add(lblVendas);
	}
//	private ProdutoDto busca_produto() {
//		ProdutoControladora
//	}
//	private PessoaDTO busca_pessoa() {
//		PessoaControladora.listar();
//	}
}
