package visao;

import static java.util.Objects.nonNull;

import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controladora.PessoaControladora;
import dto.PessoaDTO;

public class TelaListagemContato extends JFrame {

    private JPanel mainContainer;

    private JList<PessoaDTO> listaContatos;
    private JButton botaoSelecionar;
    private JButton botaoDeletar;
    private JButton botaoVoltar;
    private JPanel cabecalho;
    private JPanel botaoContainer;

    private PessoaDTO pessoaSelecionada;

    public TelaListagemContato(final String nomeAplicacao,
        final PessoaControladora controladora, final JFrame telaAnterior) {

        super(nomeAplicacao);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainContainer);
        this.pack();

        atualizarLista(controladora);

        listaContatos.addListSelectionListener(event -> {
            if (nonNull(listaContatos.getSelectedValue())) {
                pessoaSelecionada = listaContatos.getSelectedValue();
            }
        });

        botaoSelecionar.addActionListener(event -> {
            if (nonNull(pessoaSelecionada)) {
                System.out.println("A pessoa selecionada: " + pessoaSelecionada);
                // TODO: Chamar tela ou controladora aqui
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma pessoa selecionada! =(");
            }
        });

        botaoDeletar.addActionListener(event -> {
            if (nonNull(pessoaSelecionada)) {
                controladora.deletar(pessoaSelecionada);
                atualizarLista(controladora);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma pessoa selecionada! =(");
            }
        });

        botaoVoltar.addActionListener(event -> {
            telaAnterior.setVisible(true);
            this.dispose();
        });
    }


    private void atualizarLista(final PessoaControladora controladora) {
        PessoaDTO[] pessoas = controladora.listar().toArray(new PessoaDTO[0]);
        listaContatos.setListData(pessoas);
    }




}
