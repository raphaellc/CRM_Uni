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
import javax.swing.JLabel;

public class BuscaClientesVisao {

	private JFrame BuscaCliente;
	private VendasControladora vendasControladora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblCliente;

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
		BuscaCliente.setBounds(100, 100, 592, 387);
		BuscaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BuscaCliente.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setForeground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(404, 288, 126, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BuscaCliente.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(35, 105, 495, 23);
		BuscaCliente.getContentPane().add(textField);
		textField.setColumns(10);
		
		Label label_1 = new Label("Email");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(35, 146, 62, 15);
		BuscaCliente.getContentPane().add(label_1);
		
		Label label_1_1 = new Label("Telefone");
		label_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1_1.setBounds(330, 209, 76, 15);
		BuscaCliente.getContentPane().add(label_1_1);
		
		Label label_1_2 = new Label("Nome");
		label_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1_2.setBounds(35, 84, 62, 15);
		BuscaCliente.getContentPane().add(label_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(35, 167, 495, 23);
		BuscaCliente.getContentPane().add(textField_1);
		
		Label label_1_1_1 = new Label("CPF");
		label_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1_1_1.setBounds(38, 209, 62, 15);
		BuscaCliente.getContentPane().add(label_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(35, 230, 197, 25);
		BuscaCliente.getContentPane().add(textField_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(UIManager.getColor("ToolBar.foreground"));
		btnCancelar.setForeground(UIManager.getColor("ToolBar.foreground"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(35, 289, 126, 26);
		BuscaCliente.getContentPane().add(btnCancelar);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(333, 230, 197, 25);
		BuscaCliente.getContentPane().add(textField_4);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setForeground(Color.CYAN);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblCliente.setEnabled(false);
		lblCliente.setBounds(198, 22, 194, 50);
		BuscaCliente.getContentPane().add(lblCliente);
	}
}