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
import java.sql.ResultSet;
import java.sql.Statement;

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
import javax.swing.SwingConstants;

public class VendasVisao {

	private JFrame Vendas;
	private JTextField descVendedor;
	private JTextField descCliente;
	private JTextField descProduto;
	private JTextField totalCompra;
	private VendasControladora vendasControladora;
	String[] columnNames = {"CÓD", "DESCRIÇÃO", "QTD", "VALOR"};
	static JTable tabelaVenda;
	String from;
	PreparedStatement pst;
	Connection con;
	private JTextField qtdProduto;
	
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
		Vendas.setTitle("VENDA");
		Vendas.setBackground(new Color(255, 255, 255));
		Vendas.setBounds(100, 100, 800, 600);
		Vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vendas.getContentPane().setLayout(null);
		
		JButton buscar_vendedor = new JButton("");
		buscar_vendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaVendedorVisao buscaVendedor = new BuscaVendedorVisao(vendasControladora);
				buscaVendedor.getFrame().setVisible(true);
				Vendas.setVisible(false);
			}
		});
		buscar_vendedor.setIcon(new ImageIcon("C:\\Users\\jacks\\Desktop\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_vendedor.setBounds(620, 82, 25, 25);
		Vendas.getContentPane().add(buscar_vendedor);
		
		JLabel lblNewLabel = new JLabel("VENDEDOR:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(131, 88, 106, 13);
		Vendas.getContentPane().add(lblNewLabel);
		
		descVendedor = new JTextField();
		descVendedor.setBounds(247, 85, 363, 19);
		Vendas.getContentPane().add(descVendedor);
		descVendedor.setColumns(10);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliente.setBounds(131, 131, 79, 13);
		Vendas.getContentPane().add(lblCliente);
		
		descCliente = new JTextField();
		descCliente.setColumns(10);
		descCliente.setBounds(247, 128, 363, 19);
		Vendas.getContentPane().add(descCliente);
		
		JLabel lblProduto = new JLabel("PRODUTO:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto.setBounds(131, 177, 106, 13);
		Vendas.getContentPane().add(lblProduto);
		
		descProduto = new JTextField();
		descProduto.setColumns(10);
		descProduto.setBounds(247, 174, 363, 19);
		Vendas.getContentPane().add(descProduto);
		
		JLabel lblPagamento = new JLabel("PAGAMENTO:");
		lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPagamento.setBounds(131, 513, 111, 13);
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
        tabelaVenda = new JTable();
        tabelaVenda.setBounds(131, 255, 514, 184);
        tabelaVenda.setModel(modelProduto);
        tabelaVenda.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaVenda.setFillsViewportHeight(true);
        Vendas.getContentPane().add(tabelaVenda);
        
        
 ///////////////////////
        
		totalCompra = new JTextField();
		totalCompra.setColumns(10);
		totalCompra.setBounds(566, 452, 79, 19);
		Vendas.getContentPane().add(totalCompra);
		
		JButton finalizaCompra = new JButton("FINALIZAR COMPRA");
		finalizaCompra.setForeground(Color.BLACK);
		finalizaCompra.setBounds(450, 509, 195, 21);
		Vendas.getContentPane().add(finalizaCompra);
		
//		List nome_produto = new List();
//		nome_produto.setBounds(158, 269, 365, 168);
//		Vendas.getContentPane().add(nome_produto);
//		
//		List cod_item = new List();
//		cod_item.setBounds(95, 269, 59, 168);
//		Vendas.getContentPane().add(cod_item);
//		
//		List qtd_item = new List();
//		qtd_item.setBounds(527, 269, 56, 168);
//		Vendas.getContentPane().add(qtd_item);
//		
//		List valor_item = new List();
//		valor_item.setBounds(587, 269, 56, 168);
//		Vendas.getContentPane().add(valor_item);
		
		String frm_pagamento[] = {"Forma de pagamento", "PIX", "Dinheiro", "Crédito", "Débito"};
	    @SuppressWarnings({ "rawtypes" })
		final DefaultComboBoxModel modelPagamento = new DefaultComboBoxModel(frm_pagamento);
		@SuppressWarnings("rawtypes")
		JComboBox frmPagamento = new JComboBox();
		frmPagamento.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "PIX", "Dinheiro", "Crédito", "Débito"}));
		frmPagamento.setBackground(new Color(255, 255, 255));
		frmPagamento.setForeground(new Color(0, 0, 0));
		frmPagamento.setBounds(241, 508, 131, 22);
		Vendas.getContentPane().add(frmPagamento);
		
		JButton buscar_cliente = new JButton("");
		buscar_cliente.setIcon(new ImageIcon("C:\\Users\\jacks\\Desktop\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_cliente.setBounds(620, 125, 25, 25);
		Vendas.getContentPane().add(buscar_cliente);
		
		JButton buscar_produto = new JButton("");
		buscar_produto.setIcon(new ImageIcon("C:\\Users\\jacks\\Desktop\\JAVA\\CRM_Uni\\imagens\\lupa16.png"));
		buscar_produto.setBounds(620, 171, 25, 25);
		Vendas.getContentPane().add(buscar_produto);
		
		JButton adicionarProduto = new JButton("ADICIONAR PRODUTO");
		adicionarProduto.setBounds(450, 216, 195, 21);
		Vendas.getContentPane().add(adicionarProduto);
		
		JLabel lblQuantidade = new JLabel("QUANTIDADE:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidade.setBounds(131, 220, 111, 13);
		Vendas.getContentPane().add(lblQuantidade);
		
		qtdProduto = new JTextField();
		qtdProduto.setColumns(10);
		qtdProduto.setBounds(247, 217, 79, 19);
		Vendas.getContentPane().add(qtdProduto);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(492, 455, 70, 13);
		Vendas.getContentPane().add(lblTotal);
		
		JLabel lblVenda = new JLabel("VENDA");
		lblVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenda.setForeground(Color.CYAN);
		lblVenda.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblVenda.setEnabled(false);
		lblVenda.setBounds(323, 10, 131, 50);
		Vendas.getContentPane().add(lblVenda);
	}
}
