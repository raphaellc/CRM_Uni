package visao;

import static java.util.Arrays.asList;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.PessoaDTO;

public class TelaCadastroContato extends JFrame {

    // Paineis
    private JPanel mainContainer;
    private JPanel cabecalho;
    private JPanel contatoSection;
    private JPanel enderecoSection;
    private JPanel enderecoCabecalho;
    private JPanel footer;
    private JPanel botoesSection;

    // Inputs
    private JTextField nomeInput;
    private JTextField ocupacaoInput;
    private JFormattedTextField celularInput;
    private JFormattedTextField dataNascInput;
    private JFormattedTextField emailInput;
    private JTextField logradouroInput;
    private JTextField numeroInput;
    private JTextField complementoInput;
    private JTextField bairroInput;
    private JTextField cidadeInput;
    private JTextField estadoInput;
    private JTextField cepInput;
    private JTextField ruaInput;
    private final List<JTextField> todosInputs;

    // Botões
    private JButton cadastrarButton;

    public TelaCadastroContato(final String nomeAplicacao) {
        super(nomeAplicacao);
        this.todosInputs = asList(nomeInput, ocupacaoInput, celularInput, dataNascInput, emailInput, logradouroInput,
            numeroInput, complementoInput, bairroInput, cidadeInput, estadoInput, cepInput, ruaInput);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainContainer);
        this.pack();
        this.configurarPadding(asList(nomeInput, ocupacaoInput, celularInput, dataNascInput, emailInput));
        this.configurarPaddingContainers(asList(enderecoCabecalho, contatoSection));

        cadastrarButton.addActionListener(event -> {
            final PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setNome(nomeInput.getText());
            //TODO: Adicionar demais campos

            System.out.println("Clicou no cadastro! " + pessoaDTO);
            clear(todosInputs);
        });

    }


    private void configurarPadding(final List<JTextField> fields) {
        fields.forEach(field -> field.setBorder(BorderFactory.createCompoundBorder(
            field.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 2)
        )));
    }

    private void configurarPaddingContainers(final List<JPanel> panels) {
        panels.forEach(panel -> panel.setBorder(BorderFactory.createCompoundBorder(
            panel.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )));
    }

    private void clear(final List<JTextField> fields) {
        fields.forEach(field -> field.setText(""));
    }
}
