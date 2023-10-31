# CRM_Uni
Aplicação desenvolvida para a Atividade Acadêmica de Implementação de Software - 2023/2
# Gerência de Configuração de Software
## Equipes
### UC1 - Administração de Contatos
- Gustavo (líder técnico)
- Gregory
- Nícolas
### UC2 Gestão de Casos de Atendimento ao cliente
- Arthur (Líder)
- Felipe
- José

### UC3 Gestão de Campanhas de Marketing
- Guilherme Augusto
- Guilherme
- Filipe

### UC4 Geração de Relatórios de Desempenho de Vendas
- Luiz Gabriel (líder)
- Bernardo
- Mateus
### UC5 Gestão de Vendas 
- Julia
- Jackson
- Eduardo
- Maurício

## Documentação do Projeto
### Modelos
https://drive.google.com/file/d/1Mj9ORK-28S2fFJ-rjff1-8mJHN2TSv2Y/view
### Requisitos
https://www.moodle.unisinos.br/mod/resource/view.php?id=1694905
### Repositório de Referência
https://github.com/raphaellc/CRM_EM.git

## Ferramentas
- Oracle Java OpenJDK version 20.0.2
- MySQL 8.0.34
- MySQL Server 8.0 2


## Ambientes e Infraestrutura
- MySQL 8.0
```
  CREATE SCHEMA `crmuni` DEFAULT CHARACTER SET utf8 ;
```
- Tabela pessoas
```
  CREATE TABLE `pessoa` (
  `id_pessoa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci NOT NULL,
  `data_nascimento` date NOT NULL,
  `celular` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci DEFAULT NULL,
  `id_setor` int DEFAULT NULL,
  `id_cargo` int DEFAULT NULL,
  `ocupacao` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci DEFAULT NULL,
  `id_origem` int DEFAULT NULL,
  `data_hora_origem` datetime DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_la_0900_ai_ci;

```
- Tabela atendimento
```
CREATE TABLE `atendimento` (
  `id_atendimento` int NOT NULL AUTO_INCREMENT,
  `id_pessoa` int NOT NULL,
  `id_pessoa_responsavel` int NOT NULL,
  `dt_abertura` date NOT NULL,
  `dt_resolucao` date DEFAULT NULL,
  `desc_problema` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_categoria` int NOT NULL,
  `id_prioridade` int DEFAULT NULL,
  PRIMARY KEY (`id_atendimento`),
  KEY `id_pessoa_idx` (`id_pessoa`),
  KEY `id_pessoa_responsavel_idx` (`id_pessoa_responsavel`),
  CONSTRAINT `id_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoas` (`id_pessoas`),
  CONSTRAINT `id_pessoa_responsavel` FOREIGN KEY (`id_pessoa_responsavel`) REFERENCES `pessoas` (`id_pessoas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

```
- Tabela campanha

```
  CREATE TABLE `campanha` (
  `id_campanha` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dt_inicio` date NOT NULL,
  `dt_fim` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_campanha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```
- Tabela endereco

```
  CREATE TABLE `endereco` (
  `id_endereco` int NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numero` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `complemento` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bairro` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cidade` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estado` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cep` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_pessoa` int NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```
- Tabela pessoa_campanha_status
```
  CREATE TABLE `pessoa_campanha_status` (
  `id_pessoa_campanha_status` int NOT NULL AUTO_INCREMENT,
  `id_pessoa` int NOT NULL,
  `id_campanha` int NOT NULL,
  `dt_criacao` date NOT NULL,
  `id_status_pessoa` int NOT NULL,
  PRIMARY KEY (`id_pessoa_campanha_status`),
  KEY `id_pessoas_idx` (`id_pessoa`),
  KEY `id_campanha_idx` (`id_campanha`),
  KEY `id_status_pessoa_idx` (`id_status_pessoa`),
  CONSTRAINT `id_campanha` FOREIGN KEY (`id_campanha`) REFERENCES `campanha` (`id_campanha`),
  CONSTRAINT `id_pessoas` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoas` (`id_pessoas`),
  CONSTRAINT `id_status_pessoa` FOREIGN KEY (`id_status_pessoa`) REFERENCES `status_pessoa` (`id_status_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```

- Tabela progresso_atendimento
```
  CREATE TABLE `progresso_atendimento` (
  `id_progresso_atendimento` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dt_atualizacao` date DEFAULT NULL,
  `id_atendimento` int NOT NULL,
  `id_status_atendimento` int NOT NULL,
  PRIMARY KEY (`id_progresso_atendimento`),
  KEY `id_atendimento_idx` (`id_atendimento`),
  KEY `id_status_atendimento_idx` (`id_status_atendimento`),
  CONSTRAINT `id_atendimento` FOREIGN KEY (`id_atendimento`) REFERENCES `atendimento` (`id_atendimento`),
  CONSTRAINT `id_status_atendimento` FOREIGN KEY (`id_status_atendimento`) REFERENCES `status_atendimento` (`id_status_atendimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```

- Tabela cargo_pessoa
```
 CREATE TABLE `cargo_pessoa` (
  `id_cargo_pessoa` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_cargo_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

- Tabela setor_pessoa
```
  CREATE TABLE `setor_pessoa` (
  `id_setor_pessoa` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_setor_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```

- Tabela status_atendimento
```
  CREATE TABLE `status_atendimento` (
  `id_status_atendimento` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_status_atendimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3
```
- Tabela status_pessoa
```
  CREATE TABLE `status_pessoa` (
  `id_status_pessoa` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_status_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```

# Identificação da configuração
## Métodos de Identificação 
## Baselines do Projeto
## Estrutura do Repositório
- \CRM_Uni
  - \src
      - \controladora
      - \dao
      - \dto
      - \modelo
      - \visao
## Modelo de Colaboração

https://www.loom.com/share/51447929d822491fa729884052303f3c?sid=b8d4f1de-522e-409b-9b8e-1fd8ef2206ff