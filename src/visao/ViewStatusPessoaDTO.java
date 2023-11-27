package view;

import dao.StatusPessoaDAO;
import dto.StatusPessoaDTO;

import javax.swing.*;
import java.util.List;

public class StatusPessoaView {
    private StatusPessoaDAO statusPessoaDAO;

    public StatusPessoaView(StatusPessoaDAO statusPessoaDAO) {
        this.statusPessoaDAO = statusPessoaDAO;
    }

    public void exibirTodosStatusPessoa() {
        List<StatusPessoaDTO> statusPessoas = statusPessoaDAO.getAllStatusPessoa();

        JFrame frame = new JFrame("Todos os Status de Pessoas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (StatusPessoaDTO statusPessoa : statusPessoas) {
            listModel.addElement(statusPessoa.toString());
        }

        JList<String> list = new JList<>(listModel);
        frame.getContentPane().add(new JScrollPane(list));

        frame.setVisible(true);
    }
}
