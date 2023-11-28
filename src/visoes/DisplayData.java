package visoes;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayData extends JFrame implements ActionListener {
    JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table;
    String[] columnNames = {"User name", "Email", "Password", "Country"};
    String from;
    DisplayData() {
        l0 = new JLabel("Fatching Employee Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        l1 = new JLabel("Select name");
        b1 = new JButton("submit");
        l0.setBounds(100, 50, 350, 40);
        l1.setBounds(75, 110, 75, 20);
        b1.setBounds(150, 150, 150, 20);
        b1.addActionListener(this);
        setTitle("Fetching Student Info From DataBase");
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(l0);
        add(l1);;
        add(b1);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");
            st = con.createStatement();
            rs = st.executeQuery("select uname from emp");
            Vector v = new Vector();
            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }
            c1 = new JComboBox(v);
            c1.setBounds(150, 110, 150, 20);
            add(c1);
            st.close();
            rs.close();
        } catch (Exception e) {
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            showTableData();
        }
    }
    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        //TableModel tm = new TableModel();
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
        from = (String) c1.getSelectedItem();
        //String textvalue = textbox.getText();
        String uname = "";
        String email = "";
        String pass = "";
        String cou = "";
        try {
            pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            if (rs.next()) {
                uname = rs.getString("uname");
                email = rs.getString("umail");
                pass = rs.getString("upass");
                cou = rs.getString("ucountry");
                model.addRow(new Object[]{uname, email, pass, cou});
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
        new DisplayData();
    }
}