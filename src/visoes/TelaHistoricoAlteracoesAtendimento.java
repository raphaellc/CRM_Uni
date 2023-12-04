package visoes;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import daos.AtendimentoDao;
import dtos.AtendimentoDto;

public class TelaHistoricoAlteracoesAtendimento extends JFrame {

    private JList<String> listaAtendimentos;
    private JButton btnVisualizar;

    private AtendimentoDao atendimentoDao;

    public TelaHistoricoAlteracoesAtendimento() {
        setTitle("Lista de Atendimentos");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        listaAtendimentos = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaAtendimentos);
        panel.add(scrollPane, BorderLayout.CENTER);

        btnVisualizar = new JButton("Visualizar Histórico");
        panel.add(btnVisualizar, BorderLayout.SOUTH);

        add(panel);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = listaAtendimentos.getSelectedValue();
                if (selectedId != null) {
                    int idAtendimento = Integer.parseInt(selectedId);
                    mostrarHistoricoAtendimento(idAtendimento);
                } else {
                    JOptionPane.showMessageDialog(TelaHistoricoAlteracoesAtendimento.this, "Selecione um atendimento para visualizar o histórico de alterações.");
                }
            }
        });
    }

    public void setAtendimentoDao(AtendimentoDao atendimentoDao) {
        this.atendimentoDao = atendimentoDao;
        List<AtendimentoDto> atendimentos = atendimentoDao.listarAtendimentos();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (AtendimentoDto atendimentoDto : atendimentos) {
            listModel.addElement(String.valueOf(atendimentoDto.getIdAtendimento()));
        }
        listaAtendimentos.setModel(listModel);
    }

    private void mostrarHistoricoAtendimento(int idAtendimento) {
        AtendimentoDto atendimentoSelecionado = atendimentoDao.buscarAtendimentoPorId(idAtendimento);

        JFrame detailsFrame = new JFrame("Histórico do Atendimento");
        detailsFrame.setSize(400, 300);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        String historicoProgressoAtendimento = atendimentoDao.listarProgressoPorId(idAtendimento);

        int[] listaIdsStatus = atendimentoDao.listarIdStatusPorIdAtendimento(idAtendimento);
        String[] historicoStatusAtendimento = atendimentoDao.listarDescricaoStatusPorIds(listaIdsStatus);
        textArea.append("Histórico de Status do Atendimento"+"\n");
        textArea.append(Arrays.toString(historicoStatusAtendimento) + "\n");

        textArea.append("Descrições dos Status"+"\n");
        textArea.append(historicoProgressoAtendimento);
        textArea.append("Status Atual do Atendimento: " + atendimentoSelecionado.getStatusAtualizacao() + "\n");
        textArea.append("Descrição do Status Atual: " + atendimentoSelecionado.getDescAtualizacao() + "\n");

        if (atendimentoSelecionado.getDtAtualizacao() == null) {
            textArea.append("Data da ultima atualização: Atendimento sem atualização\n");

        } else {
            textArea.append("Data da ultima atualização: " + atendimentoSelecionado.getDtAtualizacao() + "\n");
        }


        if (atendimentoSelecionado.getDtResolucao() == null) {
            textArea.append("Data de Resolução: Atendimento sem resolução\n");

        } else {
            textArea.append("Data de Resolução: " + atendimentoSelecionado.getDtResolucao() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        detailsFrame.add(scrollPane);

        detailsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaHistoricoAlteracoesAtendimento frame = new TelaHistoricoAlteracoesAtendimento();
                frame.setVisible(true);

                AtendimentoDao atendimentoDao = new AtendimentoDao();
                frame.setAtendimentoDao(atendimentoDao);
            }
        });
    }
}
