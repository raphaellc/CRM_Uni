package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JSeparator;

public class VendasVisao {

	private JFrame Vendas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendasVisao window = new VendasVisao();
					window.Vendas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendasVisao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Vendas = new JFrame();
		Vendas.setBounds(100, 100, 800, 600);
		Vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vendas.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(211, 103, 363, 19);
		Vendas.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(580, 102, 63, 21);
		Vendas.getContentPane().add(btnNewButton);
		
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
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setBounds(580, 145, 63, 21);
		Vendas.getContentPane().add(btnNewButton_1);
		
		JLabel lblProduto = new JLabel("PRODUTO:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto.setBounds(95, 193, 79, 13);
		Vendas.getContentPane().add(lblProduto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(211, 192, 363, 19);
		Vendas.getContentPane().add(textField_2);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(580, 191, 63, 21);
		Vendas.getContentPane().add(btnNewButton_2);
		
		Choice escolhe_pagamento = new Choice();
		escolhe_pagamento.add("PIX");
		escolhe_pagamento.add("Dinheiro");
		escolhe_pagamento.add("Crédito");
		escolhe_pagamento.add("Débito");
		escolhe_pagamento.setFont(new Font("Arial", Font.PLAIN, 12));
		escolhe_pagamento.setBounds(211, 508, 158, 18);
		Vendas.getContentPane().add(escolhe_pagamento);
		
		
		
		JLabel lblPagamento = new JLabel("PAGAMENTO:");
		lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPagamento.setBounds(95, 513, 111, 13);
		Vendas.getContentPane().add(lblPagamento);
		
		JList desc_item = new JList();
		desc_item.setBounds(158, 269, 365, 168);
		Vendas.getContentPane().add(desc_item);
		
		JList qtd_item = new JList();
		qtd_item.setBounds(527, 269, 56, 168);
		Vendas.getContentPane().add(qtd_item);
		
		JList cod_item = new JList();
		cod_item.setBounds(95, 269, 59, 168);
		Vendas.getContentPane().add(cod_item);
		
		JList valor_total_item = new JList();
		valor_total_item.setBounds(587, 269, 56, 168);
		Vendas.getContentPane().add(valor_total_item);
		
		JLabel lblCd = new JLabel("CÓD");
		lblCd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCd.setBounds(95, 245, 79, 27);
		Vendas.getContentPane().add(lblCd);
		
		JLabel lblDescrioDoProduto = new JLabel("DESCRIÇÃO DO PRODUTO");
		lblDescrioDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrioDoProduto.setBounds(158, 245, 209, 27);
		Vendas.getContentPane().add(lblDescrioDoProduto);
		
		JLabel lblCd_1 = new JLabel("QTD");
		lblCd_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCd_1.setBounds(527, 245, 47, 27);
		Vendas.getContentPane().add(lblCd_1);
		
		JLabel lblCd_2 = new JLabel("VLR");
		lblCd_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCd_2.setBounds(587, 245, 79, 27);
		Vendas.getContentPane().add(lblCd_2);
		
		JLabel lblProduto_1 = new JLabel("TOTAL");
		lblProduto_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto_1.setBounds(527, 444, 63, 13);
		Vendas.getContentPane().add(lblProduto_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(587, 441, 56, 19);
		Vendas.getContentPane().add(textField_3);
		
		JButton btnNewButton_1_1 = new JButton("FINALIZAR COMPRA");
		btnNewButton_1_1.setBounds(520, 508, 123, 21);
		Vendas.getContentPane().add(btnNewButton_1_1);
	}
}
