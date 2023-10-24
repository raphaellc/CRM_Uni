package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import dao.conexao.ConexaoStrategy;
import util.interfaces.ThrowingConsumer;
import util.interfaces.ThrowingFunction;

public abstract class BaseDAO {

    protected ConexaoStrategy conexao;
    protected ResultSet resultado;

    public BaseDAO(final ConexaoStrategy conexao) {
        this.conexao = conexao;
    }

    protected <R> R execute(final ThrowingFunction<Connection, R> task) {
        try {
            final Connection connection = conexao.abrir();
            return task.apply(connection);
        } catch (final Exception exception) {
            System.out.println("[ERRO] Problema para executar tarefa de banco: " + exception.getMessage());
            exception.printStackTrace();
        } finally {
            this.conexao.fechar(this.resultado);
            this.conexao.fechar();
            this.resultado = null;
        }
        return null;
    }

    protected void execute(final ThrowingConsumer<Connection> task) {
        try {
            final Connection connection = conexao.abrir();
            task.accept(connection);
        } catch (final Exception exception) {
            System.out.println("[ERRO] Problema para executar tarefa de banco: " + exception.getMessage());
            exception.printStackTrace();
        } finally {
            this.conexao.fechar(this.resultado);
            this.resultado = null;
        }
    }

}
