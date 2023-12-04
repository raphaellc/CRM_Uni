package src.visao;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainCampanha extends JFrame {
    private JButton gerar_relatorio;
    private JCheckBox idCheckBox;
    private JCheckBox nomeDaCamapanhaCheckBox;
    private JCheckBox dataInicioCheckBox;
    private JCheckBox dataFinalCheckBox;
    private JTextArea txtAreaLista;
    public MainCampanha() {
        JCheckBox idCheckBox = new JCheckBox();
        idCheckBox.addActionListener(this::action);
    }

    private void action(ActionEvent actionEvent){
        System.out.println(idCheckBox.isSelected());
    }
        public static void main (String[]args){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainCampanha();
                }
            });
        }
    }
