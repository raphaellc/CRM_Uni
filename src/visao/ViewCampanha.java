package view;

import dao.CampanhaDAO;
import dto.CampanhaDTO;

import javax.swing.*;
import java.util.List;

public class CampanhaView {
    private CampanhaDAO campanhaDAO;

    public CampanhaView(CampanhaDAO campanhaDAO) {
        this.campanhaDAO = campanhaDAO;
    }

    public void exibirTodasCampanhas() {
        List<CampanhaDTO> campanhas = campanhaDAO.buscarTodasCampanhas();

        JFrame frame = new JFrame("Todas as Campanhas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (CampanhaDTO campanha : campanhas) {
            listModel.addElement(campanha.toString());
        }

        JList<String> list = new JList<>(listModel);
        frame.getContentPane().add(new JScrollPane(list));

        frame.setVisible(true);
    }
}
