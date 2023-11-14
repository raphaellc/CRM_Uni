package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladoras.VendasControladora;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VendasVisao {

	private JFrame Vendas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField descProduto;
	private JTextField textField_3;
	private VendasControladora vendasControladora;
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
	public VendasVisao(VendasControladora vendasControladora) {
		this.vendasControladora = vendasControladora;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		Vendas = new JFrame();
		Vendas.setBackground(new Color(255, 255, 255));
		Vendas.setBounds(100, 100, 800, 600);
		Vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vendas.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(211, 103, 363, 19);
		Vendas.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton buscar_vendedor = new JButton("");
		buscar_vendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaVendedorVisao buscaVendedor = new BuscaVendedorVisao(vendasControladora);
				buscaVendedor.getFrame().setVisible(true);
				Vendas.setVisible(false);
			}
		});
		buscar_vendedor.setIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive - Associacao Antonio Vieira\\Área de Trabalho\\UNISINOS\\3° SEMESTRE\\POO\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_vendedor.setBounds(584, 100, 25, 25);
		Vendas.getContentPane().add(buscar_vendedor);
		
		JLabel lblNewLabel = new JLabel("VENDEDOR:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(95, 104, 106, 13);
		Vendas.getContentPane().add(lblNewLabel);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliente.setBounds(95, 147, 79, 13);
		Vendas.getContentPane().add(lblCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(211, 146, 363, 19);
		Vendas.getContentPane().add(textField_1);
		
		JLabel lblProduto = new JLabel("PRODUTO:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto.setBounds(95, 193, 106, 13);
		Vendas.getContentPane().add(lblProduto);
		
		descProduto = new JTextField();
		descProduto.setColumns(10);
		descProduto.setBounds(211, 192, 363, 19);
		Vendas.getContentPane().add(descProduto);
		
		JLabel lblPagamento = new JLabel("PAGAMENTO:");
		lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPagamento.setBounds(95, 513, 111, 13);
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
		
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table = new JTable();
        table.setBounds(95, 245, 514, 184);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        Vendas.getContentPane().add(table);
        
 ///////////////////////
        
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(553, 442, 56, 19);
		Vendas.getContentPane().add(textField_3);
		
		JButton btnNewButton_1_1 = new JButton("FINALIZAR COMPRA");
		btnNewButton_1_1.setBounds(512, 508, 131, 21);
		Vendas.getContentPane().add(btnNewButton_1_1);
		
		List nome_produto = new List();
		nome_produto.setBounds(158, 269, 365, 168);
		Vendas.getContentPane().add(nome_produto);
		
		List cod_item = new List();
		cod_item.setBounds(95, 269, 59, 168);
		Vendas.getContentPane().add(cod_item);
		
		List qtd_item = new List();
		qtd_item.setBounds(527, 269, 56, 168);
		Vendas.getContentPane().add(qtd_item);
		
		List valor_item = new List();
		valor_item.setBounds(587, 269, 56, 168);
		Vendas.getContentPane().add(valor_item);
		
		String frm_pagamento[] = {"Forma de pagamento", "PIX", "Dinheiro", "Crédito", "Débito"};
	    @SuppressWarnings({ "rawtypes" })
		final DefaultComboBoxModel model = new DefaultComboBoxModel(frm_pagamento);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(model);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBounds(205, 508, 131, 22);
		Vendas.getContentPane().add(comboBox);
		
		JButton buscar_cliente = new JButton("");
		buscar_cliente.setIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive - Associacao Antonio Vieira\\Área de Trabalho\\UNISINOS\\3° SEMESTRE\\POO\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_cliente.setBounds(584, 143, 25, 25);
		Vendas.getContentPane().add(buscar_cliente);
		
		JButton buscar_produto = new JButton("");
		buscar_produto.setIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive - Associacao Antonio Vieira\\Área de Trabalho\\UNISINOS\\3° SEMESTRE\\POO\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_produto.setBounds(584, 189, 25, 25);
		Vendas.getContentPane().add(buscar_produto);
	}
}