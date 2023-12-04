package src.modelo;

import java.text.SimpleDateFormat;
        import java.util.Date;

public class AnaliseAtendimentoModelo {

    private String observacoes;
    private double valorAtendimento;
    private String status;
    private Date dataPrimeiroContato;
    private String responsavel;
    private int duracaoAtendimento; // em minutos

    // Construtor
    public AnaliseAtendimentoModelo(String observacoes, double valorAtendimento, String status,
                                Date dataPrimeiroContato, String responsavel, int duracaoAtendimento) {
        this.observacoes = observacoes;
        this.valorAtendimento = valorAtendimento;
        this.status = status;
        this.dataPrimeiroContato = dataPrimeiroContato;
        this.responsavel = responsavel;
        this.duracaoAtendimento = duracaoAtendimento;
    }

    // Métodos getters e setters

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public double getValorAtendimento() {
        return valorAtendimento;
    }

    public void setValorAtendimento(double valorAtendimento) {
        this.valorAtendimento = valorAtendimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataPrimeiroContato() {
        return dataPrimeiroContato;
    }

    public void setDataPrimeiroContato(Date dataPrimeiroContato) {
        this.dataPrimeiroContato = dataPrimeiroContato;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getDuracaoAtendimento() {
        return duracaoAtendimento;
    }

    public void setDuracaoAtendimento(int duracaoAtendimento) {
        this.duracaoAtendimento = duracaoAtendimento;
    }

    // Método para gerar relatório
    public String gerarRelatorio() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        return String.format("Relatório de Atendimento\n" +
                        "Observações: %s\n" +
                        "Valor do Atendimento: %.2f\n" +
                        "Status: %s\n" +
                        "Data do Primeiro Contato: %s\n" +
                        "Responsável: %s\n" +
                        "Duração do Atendimento: %d minutos",
                observacoes, valorAtendimento, status,
                formatoData.format(dataPrimeiroContato), responsavel, duracaoAtendimento);
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe
        Date dataContato = new Date();
        RelatorioAtendimento relatorio = new RelatorioAtendimento("Cliente satisfeito", 150.0, "Concluído",
                dataContato, "Atendente1", 30);

        // Gerar e exibir o relatório
        String relatorioFinal = relatorio.gerarRelatorio();
        System.out.println(relatorioFinal);
    }
}