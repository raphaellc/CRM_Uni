package visoes;

import daos.AtendimentoDao;
import dtos.AtendimentoDto;
import dtos.ProgressoAtendimentoDto;
import dtos.StatusAtendimentoDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class TelaCadastroAtendimento{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Atendimento de Suporte de Vendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(425, 350);
        frame.setResizable(false);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        JLabel lblIdResponsavelAtendimento = new JLabel("ID da Pessoa Responsável:");
        JTextField txtIdResponsavelAtendimento = new JTextField(20);

        JLabel lblIdPessoaSolicitante = new JLabel("ID da Pessoa Solicitante:");
        JTextField txtIdPessoaSolicitante = new JTextField(20);

        JLabel lblDescricaoProblema = new JLabel("Descrição do Problema:");
        JTextArea txtDescricaoProblema = new JTextArea(4, 30);
        txtDescricaoProblema.setWrapStyleWord(true);
        txtDescricaoProblema.setLineWrap(true);
        txtDescricaoProblema.setCaretPosition(0);
        txtDescricaoProblema.setEditable(true);


        JLabel lblPrioridadeCaso = new JLabel("Prioridade do Caso:");
        JTextField txtPrioridadeCaso = new JTextField(20);

        JLabel lblIdCategoriaProduto = new JLabel("ID da Categoria do Produto:");
        JTextField txtIdCategoriaProduto = new JTextField(20);


        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        panel.add(lblIdResponsavelAtendimento);
        panel.add(txtIdResponsavelAtendimento);
        panel.add(lblIdPessoaSolicitante);
        panel.add(txtIdPessoaSolicitante);
        panel.add(lblPrioridadeCaso);
        panel.add(txtPrioridadeCaso);
        panel.add(lblIdCategoriaProduto);
        panel.add(txtIdCategoriaProduto);
        panel.add(lblDescricaoProblema);
        panel.add(txtDescricaoProblema);

        panel.add(btnCadastrar);
        panel.add(btnCancelar);

        frame.add(panel);
        frame.setVisible(true);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AtendimentoDto atendimentoDto = new AtendimentoDto();
                atendimentoDto.setIdPessoa(Integer.parseInt(txtIdPessoaSolicitante.getText()));
                atendimentoDto.setDtAbertura(LocalDate.now());
                atendimentoDto.setDescProblema(txtDescricaoProblema.getText());
                atendimentoDto.setPrioridadeCaso(Integer.parseInt(txtPrioridadeCaso.getText()));
                atendimentoDto.setIdCategoria(Integer.parseInt(txtIdCategoriaProduto.getText()));
                atendimentoDto.setIdResponsavel(Integer.parseInt(txtIdResponsavelAtendimento.getText()));

                AtendimentoDao atendimentoDao = new AtendimentoDao();
                atendimentoDao.adicionarAtendimento(atendimentoDto);


                JOptionPane.showMessageDialog(null, "Atendimento cadastrado com sucesso!");
            }


        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Opção para caso o usuário queira cancelar a ação
                frame.dispose(); // Fecha a janela
            }

        });
    }
}
