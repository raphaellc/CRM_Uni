package visoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVisualizarAtendimento extends JFrame {
    //Tela para que o usuário visualize os dados de um atendimento criado, podemos colocar mais campos de visualização
    //Como por exemplo a prioridade do caso e o id da pessoa responsável, mas isso teremos que ver com o sor.
    private JTextField txtIdAtendimento;
    private JTextField txtIdPessoaSolicitante;
    private JTextField txtStatusAtendimento;
    private JTextField txtDataAbertura;
    private JTextArea txtDescricaoProblema;

    public TelaVisualizarAtendimento() {
        setTitle("Consulta de Atendimento");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        JLabel lblIdAtendimento = new JLabel("ID de Atendimento:");
        txtIdAtendimento = new JTextField(30);

        JButton btnConsultar = new JButton("Consultar Atendimento");
        JButton btnCancelar = new JButton("Cancelar");

        panel.add(lblIdAtendimento);
        panel.add(txtIdAtendimento);
        panel.add(btnConsultar);


        //
        panel.add(new JLabel("Informações do Atendimento:"));

        panel.add(new JLabel("ID de Atendimento:"));
        txtIdAtendimento = new JTextField(30);
        txtIdAtendimento.setEditable(false);
        panel.add(txtIdAtendimento);

        panel.add(new JLabel("ID da Pessoa Solicitante:"));
        txtIdPessoaSolicitante = new JTextField(30);
        txtIdPessoaSolicitante.setEditable(false);
        panel.add(txtIdPessoaSolicitante);

        panel.add(new JLabel("Status do Atendimento:"));
        txtStatusAtendimento = new JTextField(30);
        txtStatusAtendimento.setEditable(false);
        panel.add(txtStatusAtendimento);

        panel.add(new JLabel("Data de Abertura:"));
        txtDataAbertura = new JTextField(30);
        txtDataAbertura.setEditable(false);
        panel.add(txtDataAbertura);

        panel.add(new JLabel("Descrição do Problema:"));
        txtDescricaoProblema = new JTextArea(4, 30);
        txtDescricaoProblema.setWrapStyleWord(true);
        txtDescricaoProblema.setLineWrap(true);
        txtDescricaoProblema.setCaretPosition(0);
        txtDescricaoProblema.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtDescricaoProblema);
        panel.add(scrollPane);

        panel.add(btnCancelar);
        add(panel);

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui é necessário inserir os métodos para resgatar os dados do atendimento com o ID informado abaixo

                //Comentei essa linha de codigo para testar a interface, já que ao inserir qualquer numero esta dando
                //um erro que ainda nao consegui arrumar.
                //int idAtendimento = Integer.parseInt(txtIdAtendimento.getText());

                //Todos os dados resgatados a partir dos métodos das dtos deverão ser passados como parâmetro abaixo
                txtIdPessoaSolicitante.setText("");
                txtStatusAtendimento.setText("");
                txtDataAbertura.setText("");
                txtDescricaoProblema.setText("");
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaVisualizarAtendimento frame = new TelaVisualizarAtendimento();
                frame.setVisible(true);
            }
        });
    }
}
