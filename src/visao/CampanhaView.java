package src.visao;

import src.controladora.AnaliseCampanhaC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampanhaView {

    public static void main(String[] args) {
        // Cria um controller
        AnaliseCampanhaC controller = new AnaliseCampanhaC();

        // Cria o botão
        JButton button = new JButton("Campanha3");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama a controller quando o botão é pressionado
                controller.selecionarCampanha(button.getText());
            }
        });

        // Cria a janela
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
