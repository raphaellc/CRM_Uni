package visoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAtualizarAtendimento extends JFrame {
    private JTextField txtStatusAtualizacao;
    private JTextField txtDataAtualizacao;
    private JTextArea txtDescricaoAtualizacao;
    private JTextField txtIdAtendimento;
    private JTextField txtIdPessoaSolicitante;
    private JTextField txtStatusAtendimento;
    private JTextField txtDataAbertura;
    private JTextArea txtDescricaoProblema;

    public TelaAtualizarAtendimento() {
        setTitle("Detalhes do Atendimento");
        setSize(400, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblIdAtendimento = new JLabel("ID de Atendimento:");
        txtIdAtendimento = new JTextField(30);

        JButton btnCarregarAtendimento = new JButton("Carregar Atendimento");


        JLabel lblIdPessoaSolicitante = new JLabel("ID da Pessoa Solicitante:");
        txtIdPessoaSolicitante = new JTextField(30);
        txtIdPessoaSolicitante.setEditable(false);

        JLabel lblStatusAtendimento = new JLabel("Status do Atendimento:");
        txtStatusAtendimento = new JTextField(30);
        txtStatusAtendimento.setEditable(false);

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

        JLabel lblStatusAtualizacao = new JLabel("Status da Atualização:");
        txtStatusAtualizacao = new JTextField(30);

        JLabel lblDataAtualizacao = new JLabel("Data da Atualização:");
        txtDataAtualizacao = new JTextField(30);

        JLabel lblDescricaoAtualizacao = new JLabel("Descrição da Atualização:");
        txtDescricaoAtualizacao = new JTextArea(4, 30);
        txtDescricaoAtualizacao.setWrapStyleWord(true);
        txtDescricaoAtualizacao.setLineWrap(true);
        txtDescricaoProblema.setCaretPosition(0);
        txtDescricaoAtualizacao.setBorder(BorderFactory.createEtchedBorder());

        JButton btnAtualizar = new JButton("Atualizar Atendimento");
        JButton btnFechar = new JButton("Fechar Atendimento");
        JButton btnCancelar = new JButton("Cancelar");

        // Componentes do painel
        panel.add(lblIdAtendimento);
        panel.add(txtIdAtendimento);
        panel.add(btnCarregarAtendimento);
        panel.add(lblIdPessoaSolicitante);
        panel.add(txtIdPessoaSolicitante);
        panel.add(lblStatusAtendimento);
        panel.add(txtStatusAtendimento);
        panel.add(lblDataAbertura);
        panel.add(txtDataAbertura);
        panel.add(lblDescricaoProblema);
        panel.add(scrollPane);
        panel.add(lblStatusAtualizacao);
        panel.add(txtStatusAtualizacao);
        panel.add(lblDataAtualizacao);
        panel.add(txtDataAtualizacao);
        panel.add(lblDescricaoAtualizacao);
        panel.add(txtDescricaoAtualizacao);
        panel.add(btnAtualizar);
        panel.add(btnFechar);
        panel.add(btnCancelar);

        add(panel);

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui tudo que for inserido pelo usuário na tela, será armazenado abaixo, para que seu status seja
                // atualizado ou criado caso não tenha nenhum status.
                String statusAtualizacao = txtStatusAtualizacao.getText();
                String dataAtualizacao = txtDataAtualizacao.getText();
                String descricaoAtualizacao = txtDescricaoAtualizacao.getText();

                // Inserir métodos para atualizar o status do atendimento, deve adicionar Status da atualização
                // Data da atualização e descrição da atualização

                JOptionPane.showMessageDialog(null, "Atendimento Atualizado!");
            }
        });

        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Inserir métodos para dar o atendimento como fechado, esse metodo deve setar seu status como
                // Fechado ou Concluido
                JOptionPane.showMessageDialog(null, "Atendimento Encerrado!");
                dispose(); // Fecha a janela
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
                carregarAtendimento(idAtendimento);
            }
        });
    }


    private void carregarAtendimento(String idAtendimento) {
        //Método para carregar as informações do atendimento com base no ID
        //Adicionar aqui o codigo necessario para carregar o atendimento e mostrar suas informacoes na tela,
        //Resgatar e mostrar: id da pessoa solicitante, status do atendimento, data de abertura e descrição do problema
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