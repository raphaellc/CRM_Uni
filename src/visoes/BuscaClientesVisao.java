package visoes;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladoras.VendasControladora;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class BuscaClientesVisao {

	private JFrame BuscaCliente;
	private VendasControladora vendasControladora;
	private JTextField txtBuscarCliente;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;

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
		BuscaCliente.getContentPane().setBackground(UIManager.getColor("TabbedPane.light"));
		BuscaCliente.setTitle("BUSCA CLIENTE");
		BuscaCliente.setBounds(100, 100, 450, 300);
		BuscaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BuscaCliente.getContentPane().setLayout(null);
		
		txtBuscarCliente = new JTextField();
		txtBuscarCliente.setBounds(0, 0, 434, 23);
		txtBuscarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarCliente.setBackground(Color.WHITE);
		txtBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtBuscarCliente.setText("Buscar Cliente");
		BuscaCliente.getContentPane().add(txtBuscarCliente);
		txtBuscarCliente.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setForeground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton.setBackground(UIManager.getColor("ToolBar.foreground"));
		btnNewButton.setBounds(286, 211, 126, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BuscaCliente.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(24, 64, 168, 23);
		BuscaCliente.getContentPane().add(textField);
		textField.setColumns(10);
		
		Label label_1 = new Label("Email");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(238, 43, 62, 15);
		BuscaCliente.getContentPane().add(label_1);
		
		Label label_1_1 = new Label("Telefone");
		label_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1_1.setBounds(24, 102, 62, 15);
		BuscaCliente.getContentPane().add(label_1_1);
		
		Label label_1_2 = new Label("Nome");
		label_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1_2.setBounds(24, 43, 62, 15);
		BuscaCliente.getContentPane().add(label_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(238, 64, 168, 23);
		BuscaCliente.getContentPane().add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(24, 120, 168, 23);
		BuscaCliente.getContentPane().add(textField_1);
		
		Label label_1_1_1 = new Label("CPF");
		label_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1_1_1.setBounds(238, 102, 62, 15);
		BuscaCliente.getContentPane().add(label_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 118, 168, 25);
		BuscaCliente.getContentPane().add(textField_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(UIManager.getColor("ToolBar.foreground"));
		btnCancelar.setForeground(UIManager.getColor("ToolBar.foreground"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(24, 211, 126, 23);
		BuscaCliente.getContentPane().add(btnCancelar);
	}
}
