package src;

import src.dao.AnaliseCampanhaDao;
import src.dto.AnaliseCampanhaDto;
import java.util.List;
/** Teste Matheus
public class MainTesteCampanha {

    public static void main(String[] args) {

        AnaliseCampanhaDao analise_campanha_dao = new AnaliseCampanhaDao();

        List<AnaliseCampanhaDto> campanha = analise_campanha_dao.selecionarCampanha("Campanha3");

        // Exibindo os valores da tabela
        if (campanha.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
        } else {
            for (AnaliseCampanhaDto valor : campanha) {
                System.out.println("ID: " + valor.getId_campanha());
                System.out.println("Nome: " + valor.getNome_campanha());
                System.out.println("Data Início: " + valor.getDt_inicio_campanha());
                System.out.println("Data Fim: " + valor.getDt_fim_campanha());
            }
        }
    }
}**/


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Teste Luga
public class MainTesteCampanha extends JFrame {
    private JButton gerar_relatorio;
    private JLabel lblTexto;
    private JTextArea txtAreaLista;
    AnaliseCampanhaDao analise_campanha_dao = new AnaliseCampanhaDao();
    List<AnaliseCampanhaDto> campanha = analise_campanha_dao.selecionarCampanha("Campanha3");
    public MainTesteCampanha() {
        super("Geração de relatórios de campanha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Criar a JLabel inicial com um texto
        txtAreaLista = new JTextArea();
        txtAreaLista.setBounds(150,200,100,50);

        gerar_relatorio = new JButton("Gerar Relatório");
        gerar_relatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCampanha();
            }
        });

        JPanel panel = new JPanel();
        add(gerar_relatorio);
        panel.add(txtAreaLista);

        // Configurar o tamanho do JFrame e torná-lo visível
        setVisible(true);
        gerar_relatorio.setBounds(325,200,200,100);


        // Adiciona o painel ao frame
        add(panel);

        // Torna o frame visível
        setVisible(true);
    }

    private void listarCampanha() {
        // Limpe a JTextArea antes de listar os dados
        txtAreaLista.setText("");

        for (AnaliseCampanhaDto valor : campanha) {
            System.out.println("ID: " + valor.getId_campanha());
            System.out.println("Nome: " + valor.getNome_campanha());
            System.out.println("Data Início: " + valor.getDt_inicio_campanha());
            System.out.println("Data Fim: " + valor.getDt_fim_campanha());
        }
        //campanha.forEach(dado -> txtAreaLista.append(dado + "\n"));
    }

    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainTesteCampanha();
            }
        });
    }
}
