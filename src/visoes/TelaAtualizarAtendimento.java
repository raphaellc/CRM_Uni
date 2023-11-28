package visoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TelaAtualizarAtendimento extends JFrame {
    private JTextField txtStatusAtualizacao;
    private JTextField txtDataAtualizacao;
    private JTextArea txtDescricaoAtualizacao;
    private JTextField txtIdAtendimento;
    private JTextField txtIdPessoaSolicitante;
    private JTextField txtStatusAtendimento;
    private JTextField txtDataAbertura;
    private JTextArea txtDescricaoProblema;

    private JTextField txtPessoaResponsavel;

    private JTextArea txtDescricaoStatus;

    public TelaAtualizarAtendimento() {
        setTitle("Detalhes do Atendimento");
        setSize(450, 650);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblIdAtendimento = new JLabel("ID de Atendimento:");
        txtIdAtendimento = new JTextField(30);

        JButton btnCarregarAtendimento = new JButton("Carregar Atendimento");


        JLabel lblIdPessoaSolicitante = new JLabel("ID da Pessoa Solicitante:");
        txtIdPessoaSolicitante = new JTextField(30);
        txtIdPessoaSolicitante.setEditable(false);

        JLabel lblPessoaResponsavel = new JLabel("ID da Pessoa Responsavel:");
        txtPessoaResponsavel = new JTextField(30);
        txtPessoaResponsavel.setEditable(false);

        JLabel lblDataAbertura = new JLabel("Data de Abertura:");
        txtDataAbertura = new JTextField(30);
        txtDataAbertura.setEditable(false);

        JLabel lblDescricaoProblema = new JLabel("Descrição do Problema:");
        txtDescricaoProblema = new JTextArea(4, 30);
        txtDescricaoProblema.setWrapStyleWord(true);
        txtDescricaoProblema.setLineWrap(true);
        txtDescricaoProblema.setCaretPosition(0);
        txtDescricaoProblema.setEditable(false);
        txtDescricaoProblema.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(txtDescricaoProblema);

        JLabel lblStatusAtendimento = new JLabel("Status Atual:");
        txtStatusAtendimento = new JTextField(30);
        txtStatusAtendimento.setEditable(false);

        JLabel lblDescricaoStatus = new JLabel("Descrição do Status Atual:");
        txtDescricaoStatus = new JTextArea(4, 30);
        txtDescricaoStatus.setWrapStyleWord(true);
        txtDescricaoStatus.setLineWrap(true);
        txtDescricaoStatus.setCaretPosition(0);
        txtDescricaoStatus.setEditable(false);
        txtDescricaoStatus.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane1 = new JScrollPane(txtDescricaoStatus);

        JLabel lblStatusAtualizacao = new JLabel("Novo Status:");
        txtStatusAtualizacao = new JTextField(30);

        JLabel lblDescricaoAtualizacao = new JLabel("Descrição do novo Status:");
        txtDescricaoAtualizacao = new JTextArea(4, 30);
        txtDescricaoAtualizacao.setWrapStyleWord(true);
        txtDescricaoAtualizacao.setLineWrap(true);
        txtDescricaoProblema.setCaretPosition(0);
        txtDescricaoAtualizacao.setBorder(BorderFactory.createEtchedBorder());

        JButton btnAtualizar = new JButton("Atualizar Atendimento");
        JButton btnFechar = new JButton("Fechar Atendimento");
        JButton btnCancelar = new JButton("Cancelar");

        // Componentes da tela
        panel.add(lblIdAtendimento);
        panel.add(txtIdAtendimento);
        panel.add(btnCarregarAtendimento);
        panel.add(lblIdPessoaSolicitante);
        panel.add(txtIdPessoaSolicitante);
        panel.add(lblPessoaResponsavel);
        panel.add(txtPessoaResponsavel);
        panel.add(lblStatusAtendimento);
        panel.add(txtStatusAtendimento);
        panel.add(lblDescricaoStatus);
        panel.add(txtDescricaoStatus);
        panel.add(lblDataAbertura);
        panel.add(txtDataAbertura);
        panel.add(lblDescricaoProblema);
        panel.add(scrollPane);
        panel.add(lblStatusAtualizacao);
        panel.add(txtStatusAtualizacao);
        panel.add(lblDescricaoAtualizacao);
        panel.add(txtDescricaoAtualizacao);
        panel.add(btnAtualizar);
        panel.add(btnFechar);
        panel.add(btnCancelar);

        add(panel);

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String novoStatus = txtStatusAtualizacao.getText();
                    String descricaoNovoStatus = txtDescricaoAtualizacao.getText();


                    if (novoStatus.isEmpty() || descricaoNovoStatus.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de atualizar o atendimento.");
                        return;
                    }


                    dtos.AtendimentoDto atendimentoAtualizado = new dtos.AtendimentoDto();
                    atendimentoAtualizado.setIdAtendimento(Integer.parseInt(txtIdAtendimento.getText())); // ou obtenha de onde quiser
                    atendimentoAtualizado.setStatusAtualizacao(novoStatus);
                    atendimentoAtualizado.setDtAtualizacao(LocalDate.now());
                    atendimentoAtualizado.setDescAtualizacao(descricaoNovoStatus);

                    daos.AtendimentoDao atendimentoDao = new daos.AtendimentoDao();


                    boolean atualizacaoAtendimento = atendimentoDao.atualizarAtendimento(atendimentoAtualizado);

                    if (atualizacaoAtendimento) {
                        JOptionPane.showMessageDialog(null, "Atendimento atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar o atendimento.");
                    }

                JOptionPane.showMessageDialog(null, "Atendimento Atualizado!");
            }
        });

        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idAtendimento = txtIdAtendimento.getText();

                try {
                    // Convertendo o ID fornecido para um número inteiro
                    int id = Integer.parseInt(idAtendimento);

                    // Chamando o método fecharAtendimento
                    boolean fechamentoAtendimento = new daos.AtendimentoDao().fecharAtendimento(id);

                    if (fechamentoAtendimento) {
                        JOptionPane.showMessageDialog(null, "Atendimento Encerrado!");
                        dispose(); // Fecha a janela
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao fechar o atendimento.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de Atendimento inválido. Insira um número válido.");
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opção para caso o usuário queira cancelar a ação
                dispose(); // Fecha a janela
            }
        });
        btnCarregarAtendimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idAtendimento = txtIdAtendimento.getText();
                //Método para carregar as informações do atendimento com base no ID
                //Adicionar aqui o codigo necessario para carregar o atendimento e mostrar suas informacoes na tela,
                //Resgatar e mostrar: id da pessoa solicitante, status do atendimento, data de abertura e descrição do problema
                try {
                    // Convertendo o ID fornecido para um número inteiro
                    int id = Integer.parseInt(idAtendimento);


                    dtos.AtendimentoDto atendimentoDto = new daos.AtendimentoDao().buscarAtendimentoPorId(id);

                    if (atendimentoDto != null) {

                        txtIdPessoaSolicitante.setText(String.valueOf(atendimentoDto.getIdAtendimento()));
                        txtPessoaResponsavel.setText(String.valueOf(atendimentoDto.getIdResponsavel()));
                        txtDataAbertura.setText(atendimentoDto.getDtAbertura().toString());
                        txtDescricaoProblema.setText(atendimentoDto.getDescProblema());
                        txtStatusAtendimento.setText(String.valueOf(atendimentoDto.getStatusAtualizacao()));
                        txtDescricaoStatus.setText(atendimentoDto.getDescAtualizacao());


                        JOptionPane.showMessageDialog(null, "Atendimento carregado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Atendimento não encontrado para o ID: " + idAtendimento);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de Atendimento inválido. Insira um número válido.");
                }

            }
        });
    }


    private void carregarAtendimento(String idAtendimento) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaAtualizarAtendimento frame = new TelaAtualizarAtendimento();
                frame.setVisible(true);
            }
        });
    }
}