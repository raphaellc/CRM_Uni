package visao;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladora.PessoaControladora;
import dto.EnderecoDTO;
import dto.PessoaDTO;
import util.DateUtils;
import util.ValorUtil;

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
    private final List<JTextField> enderecoInputs;

    // Botões
    private JButton cadastrarButton;

    public TelaCadastroContato(final String nomeAplicacao,
        final PessoaControladora controladora) {

        super(nomeAplicacao);
        this.todosInputs = asList(nomeInput, ocupacaoInput, celularInput, dataNascInput, emailInput, logradouroInput,
            numeroInput, complementoInput, bairroInput, cidadeInput, estadoInput, cepInput, ruaInput);
        this.enderecoInputs = asList(logradouroInput, numeroInput, bairroInput, cidadeInput, cepInput, estadoInput);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainContainer);
        this.pack();
        this.configurarPadding(asList(nomeInput, ocupacaoInput, celularInput, dataNascInput, emailInput));
        this.configurarPaddingContainers(asList(enderecoCabecalho, contatoSection));

        cadastrarButton.addActionListener(event -> {
            final PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setNome(nomeInput.getText());
            pessoaDTO.setOcupacao(ocupacaoInput.getText());
            pessoaDTO.setCelular(celularInput.getText());
            pessoaDTO.setDt_nasc(DateUtils.transformToDate(dataNascInput.getText()));
            pessoaDTO.setEmail(emailInput.getText());
            pessoaDTO.setId_origem(1L); // TODO: Usar ID da controller de campanha
            pessoaDTO.setDt_hr_origem(LocalDateTime.now());

            if (algumCampoInformado(enderecoInputs)) {
                final EnderecoDTO enderecoDTO = new EnderecoDTO();
                enderecoDTO.setLogradouro(logradouroInput.getText());
                enderecoDTO.setNumero(numeroInput.getText());
                enderecoDTO.setComplemento(complementoInput.getText());
                enderecoDTO.setBairro(bairroInput.getText());
                enderecoDTO.setCidade(cidadeInput.getText());
                enderecoDTO.setEstado(estadoInput.getText());
                enderecoDTO.setCep(cepInput.getText());
                pessoaDTO.setEndereco(enderecoDTO);
            }

            final boolean sucesso = controladora.cadastrar(pessoaDTO);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Cadastrou!!");
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível realizar o cadastro =(");
            }

            // clear(todosInputs);
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

    private boolean algumCampoInformado(final List<JTextField> fields) {
        return fields.stream()
            .map(JTextField::getText)
            .anyMatch(ValorUtil::isNotEmptyString);
    }

    private void clear(final List<JTextField> fields) {
        fields.forEach(field -> field.setText(""));
    }
}
