	package visoes;
	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
	import java.util.Vector;
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	
	public class DisplayEmpData extends JFrame implements ActionListener {
		
		String[] columnNames = {"CÓD", "DESCRIÇÃO", "QTD", "VALOR"};
		static JTable table;
		String from;
		PreparedStatement pst;
		Connection con;
		
		public void showTableData() {
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //from = (String) c1.getSelectedItem();
        //String textvalue = textbox.getText();
        String cod = "";
        String descricao = "";
        String qtd = "";
        String valor = "";
        try {
            pst = con.prepareStatement("select * from produto where COD='" + from + "'");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            if (rs.next()) {
                cod = rs.getString("cod");
                descricao = rs.getString("descricao");
                qtd = rs.getString("qtd");
                valor = rs.getString("valor");
                model.addRow(new Object[]{cod, descricao, qtd, valor});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }
	
    public static void main(String args[]) {
        new DisplayEmpData();
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	}