package visao;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;
import static util.DateUtils.tranformLocalDateToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    private JButton botaoCadastrar;
    private JButton botaoListar;

    private PessoaDTO pessoaSelecionada;

    public TelaCadastroContato(final String nomeAplicacao, final PessoaControladora controladora){
        this(nomeAplicacao, controladora, null);
    }

    public TelaCadastroContato(final String nomeAplicacao,
        final PessoaControladora controladora, final PessoaDTO pessoaSelecionada) {

        super(nomeAplicacao);

        this.pessoaSelecionada = pessoaSelecionada;

        inicializarComponentes();

        this.todosInputs = asList(nomeInput, ocupacaoInput, celularInput, dataNascInput, emailInput, logradouroInput,
            numeroInput, complementoInput, bairroInput, cidadeInput, estadoInput, cepInput, ruaInput);
        this.enderecoInputs = asList(logradouroInput, numeroInput, bairroInput, cidadeInput, cepInput, estadoInput);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainContainer);
        this.pack();
        this.configurarPadding(asList(nomeInput, ocupacaoInput, celularInput, dataNascInput, emailInput));
        this.configurarPaddingContainers(asList(enderecoCabecalho, contatoSection));

        botaoListar.addActionListener(event -> {
            final JFrame telaListagem = new TelaListagemContato(nomeAplicacao, controladora, this);
            telaListagem.setVisible(true);
            this.setVisible(false);
        });

        botaoCadastrar.addActionListener(event -> {

            if(Objects.isNull(pessoaSelecionada)){
                final PessoaDTO novaPessoaDTO = getPessoaDTO(null, null);

                final boolean sucesso = controladora.cadastrar(novaPessoaDTO);

                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Cadastrou!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível realizar o cadastro =(");
                }
            }else {
                final PessoaDTO novaPessoaDTO = getPessoaDTO(pessoaSelecionada.getId_pessoa(), pessoaSelecionada.getEndereco().getId_endereco());

                final boolean alterar = controladora.atualizar(novaPessoaDTO);

                if (alterar) {
                    JOptionPane.showMessageDialog(this, "Alterado!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível realizar a alteracao =(");
                }
            }

             clear(todosInputs);
        });

    }

    private void inicializarComponentes(){
        if(isNull(this.pessoaSelecionada)){
            return;
        }

        this.nomeInput.setText(pessoaSelecionada.getNome());
        this.ocupacaoInput.setText(pessoaSelecionada.getOcupacao());
        this.celularInput.setText(pessoaSelecionada.getCelular());
        this.dataNascInput.setText(tranformLocalDateToString(pessoaSelecionada.getDt_nasc()));
        this.emailInput.setText(pessoaSelecionada.getEmail());
        if(Objects.nonNull(pessoaSelecionada.getEndereco())){
            this.logradouroInput.setText(pessoaSelecionada.getEndereco().getLogradouro());
            this.numeroInput.setText(pessoaSelecionada.getEndereco().getNumero());
            this.complementoInput.setText(pessoaSelecionada.getEndereco().getComplemento());
            this.bairroInput.setText(pessoaSelecionada.getEndereco().getBairro());
            this.cidadeInput.setText(pessoaSelecionada.getEndereco().getCidade());
            this.estadoInput.setText(pessoaSelecionada.getEndereco().getEstado());
            this.cepInput.setText(pessoaSelecionada.getEndereco().getCep());
        }

        this.botaoCadastrar.setText("Atualizar");
    }

    private PessoaDTO getPessoaDTO(Long idPessoa, Long idEndereco){

        final PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId_pessoa(idPessoa);
        pessoaDTO.setNome(nomeInput.getText());
        pessoaDTO.setOcupacao(ocupacaoInput.getText());
        pessoaDTO.setCelular(celularInput.getText());
        pessoaDTO.setDt_nasc(DateUtils.transformToDate(dataNascInput.getText()));
        pessoaDTO.setEmail(emailInput.getText());
        pessoaDTO.setId_origem(1L); // TODO: Usar ID da controller de campanha
        pessoaDTO.setDt_hr_origem(LocalDateTime.now());

        if (algumCampoInformado(enderecoInputs)) {
            final EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setId_endereco(idEndereco);
            enderecoDTO.setLogradouro(logradouroInput.getText());
            enderecoDTO.setNumero(numeroInput.getText());
            enderecoDTO.setComplemento(complementoInput.getText());
            enderecoDTO.setBairro(bairroInput.getText());
            enderecoDTO.setCidade(cidadeInput.getText());
            enderecoDTO.setEstado(estadoInput.getText());
            enderecoDTO.setCep(cepInput.getText());
            pessoaDTO.setEndereco(enderecoDTO);
        }

        return pessoaDTO;
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
