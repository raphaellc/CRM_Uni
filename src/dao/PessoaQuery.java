package dao;

public interface PessoaQuery {

    String CONSULTAR_TODAS_PESSOAS = "SELECT P.*, "
        + "S.descricao as 'setor', "
        + "C.descricao as 'cargo', "
        + "E.id_endereco, "
        + "E.logradouro, "
        + "E.numero, "
        + "E.complemento, "
        + "E.bairro, "
        + "E.cidade, "
        + "E.estado, "
        + "E.cep "
        + "FROM pessoa P "
        + "LEFT JOIN setor_pessoa S ON P.id_setor= S.id_setor_pessoa "
        + "LEFT JOIN cargo_pessoa C on P.id_cargo = C.id_cargo_pessoa "
        + "LEFT JOIN endereco E on P.id_pessoa = E.id_pessoa";


    String CRIAR_PESSOA = "INSERT INTO pessoa(nome, data_nascimento, email, ocupacao, data_hora_origem, celular, id_origem) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    String CRIAR_ENDERECO = "INSERT INTO endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, id_pessoa) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    String CONSULTAR_EMAIL = "SELECT * FROM pessoa WHERE email = ?";

    String CONSULTAR_PESSOA_ID = "SELECT P.*, "
            + "S.descricao as 'setor', "
            + "C.descricao as 'cargo', "
            + "E.id_endereco, "
            + "E.logradouro, "
            + "E.numero, "
            + "E.complemento, "
            + "E.bairro, "
            + "E.cidade, "
            + "E.estado, "
            + "E.cep "
            + "FROM pessoa P "
            + "LEFT JOIN setor_pessoa S ON P.id_setor= S.id_setor_pessoa "
            + "LEFT JOIN cargo_pessoa C on P.id_cargo = C.id_cargo_pessoa "
            + "LEFT JOIN endereco E on P.id_pessoa = E.id_pessoa WHERE P.id_pessoa = ?";
    String DELETAR_PESSOA_ID = "DELETE FROM pessoa WHERE id_pessoa = ?";

    String ATUALIZAR_PESSOA = "UPDATE pessoa " +
            "SET nome = ?, data_nascimento = ?, celular = ?, email = ?, ocupacao = ? " +
            "WHERE id_pessoa = ?";

    String ATUALIZAR_ENDERECO = "UPDATE endereco " +
            "SET logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? " +
            "WHERE id_endereco = ?";
}
