package visoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import daos.AtendimentoDao;
import dtos.AtendimentoDto;

public class TelaVisualizarAtendimento extends JFrame {

    private JList<String> listaAtendimentos;
    private JButton btnVisualizar;

    private AtendimentoDao atendimentoDao;

    public TelaVisualizarAtendimento() {
        setTitle("Consulta de Atendimento");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        listaAtendimentos = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaAtendimentos);
        panel.add(scrollPane, BorderLayout.CENTER);

        btnVisualizar = new JButton("Visualizar Atendimento");
        panel.add(btnVisualizar, BorderLayout.SOUTH);

        add(panel);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = listaAtendimentos.getSelectedValue();
                if (selectedId != null) {
                    int idAtendimento = Integer.parseInt(selectedId);
                    mostrarDetalhesAtendimento(idAtendimento);
                } else {
                    JOptionPane.showMessageDialog(TelaVisualizarAtendimento.this, "Selecione um atendimento para visualizar.");
                }
            }
        });
    }

    public void setAtendimentoDao(AtendimentoDao atendimentoDao) {
        this.atendimentoDao = atendimentoDao;
        List<AtendimentoDto> atendimentos = atendimentoDao.listarAtendimento();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (AtendimentoDto atendimentoDto : atendimentos) {
            listModel.addElement(String.valueOf(atendimentoDto.getIdAtendimento()));
        }
        listaAtendimentos.setModel(listModel);
    }

    private void mostrarDetalhesAtendimento(int idAtendimento) {
        AtendimentoDto atendimentoSelecionado = atendimentoDao.buscarAtendimentoPorId(idAtendimento);

        JFrame detailsFrame = new JFrame("Detalhes do Atendimento");
        detailsFrame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("ID de Atendimento: " + atendimentoSelecionado.getIdAtendimento() + "\n");
        textArea.append("ID da Pessoa Solicitante: " + atendimentoSelecionado.getIdPessoa() + "\n");
        textArea.append("Status do Atendimento: " + atendimentoSelecionado.getStatusAtualizacao() + "\n");
        textArea.append("Data de Abertura: " + atendimentoSelecionado.getDtAbertura() + "\n");
        textArea.append("Data de Resolução: " + atendimentoSelecionado.getDtResolucao() + "\n");

        JScrollPane scrollPane = new JScrollPane(textArea);
        detailsFrame.add(scrollPane);

        detailsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaVisualizarAtendimento frame = new TelaVisualizarAtendimento();
                frame.setVisible(true);

                AtendimentoDao atendimentoDao = new AtendimentoDao();
                frame.setAtendimentoDao(atendimentoDao);
            }
        });
    }
}
