package visoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TelaCadastroAtendimento{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Atendimento de Suporte de Vendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(425, 350);
        frame.setResizable(false);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblIdAtendimento = new JLabel("ID de Atendimento:");
        JTextField txtIdAtendimento = new JTextField(20);

        JLabel lblIdPessoaSolicitante = new JLabel("ID da Pessoa Solicitante:");
        JTextField txtIdPessoaSolicitante = new JTextField(20);

        JLabel lblDataAbertura = new JLabel("Data de Abertura:");
        JTextField txtDataAbertura = new JTextField(20);

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

        JLabel lblIdResponsavelAtendimento = new JLabel("ID da Pessoa Responsável:");
        JTextField txtIdResponsavelAtendimento = new JTextField(20);

        JLabel lblIdProdutoRelacionado = new JLabel("ID do Produto Relacionado:");
        JTextField txtIdProdutoRelacionado = new JTextField(20);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        panel.add(lblIdAtendimento);
        panel.add(txtIdAtendimento);
        panel.add(lblIdPessoaSolicitante);
        panel.add(txtIdPessoaSolicitante);
        panel.add(lblDataAbertura);
        panel.add(txtDataAbertura);
        panel.add(lblDescricaoProblema);
        panel.add(txtDescricaoProblema);
        panel.add(lblPrioridadeCaso);
        panel.add(txtPrioridadeCaso);
        panel.add(lblIdCategoriaProduto);
        panel.add(txtIdCategoriaProduto);
        panel.add(lblIdResponsavelAtendimento);
        panel.add(txtIdResponsavelAtendimento);
        panel.add(lblIdProdutoRelacionado);
        panel.add(txtIdProdutoRelacionado);
        panel.add(btnCadastrar);
        panel.add(btnCancelar);

        frame.add(panel);
        frame.setVisible(true);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicionar logica dos metodos de logica

                //Codigo de Exemplo (retirado do github de referência do sor)
//                ContatoDto contato = new ContatoDto();
//                contato.setNome(textNome.getText());
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                contato.setDt_nasc(LocalDate.parse(form_text_dt_nasc.getText(), formatter));
//                contato.setCelular(textCelular.getText());
//                contato.setEmail(textEmail.getText());
//                contato.setId_setor(2);
//                contato.setOcupacao("Desenvolvedor");
//                contato.setId_origem(3);
//                contato.setDt_hr_origem(LocalDateTime.now()); // Data e hora atuais
//                contato.setId_tipo_pessoa(1); // 1-Militante; 2-Contato;
//                JOptionPane.showMessageDialog(TelaCadastroContato.this,"combo_box" + combobox_setor.getSelectedIndex());
//                if(cto_control.adicionarContato(contato))
//                    JOptionPane.showMessageDialog(TelaCadastroContato.this,"Cadastrado com sucesso");
//                else
//                    JOptionPane.showMessageDialog(TelaCadastroContato.this,"Falhou cadastro");

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
