# Gerenciador de Finanças Pessoais

Aplicação de linha de comando em Java com persistência de dados em MySQL.

## Funcionalidades

- Adicionar ganhos e despesas por categoria
- Relatório com total de ganhos, despesas e balanço
- Editar e apagar entradas
- Dados salvos no banco — nada se perde ao fechar o programa

## Tecnologias

- Java
- MySQL
- JDBC
- Padrão DAO

## Estrutura do Projeto

```
src/
├── Main.java                → interface de linha de comando
├── Entry.java               → modelo de dados
├── EntryManager.java        → lógica do programa
├── DatabaseConnection.java  → conexão com o banco
└── EntryDAO.java            → operações CRUD no banco
```

## Como configurar

### Pré-requisitos
- Java JDK instalado
- MySQL instalado e rodando
- MySQL Connector/J (.jar) adicionado ao projeto

### 1. Criar o banco de dados

Execute no MySQL Workbench ou terminal:

```sql
CREATE DATABASE entry_managerDB;

USE entry_managerDB;

CREATE TABLE entries (
    id    INT          AUTO_INCREMENT PRIMARY KEY,
    valor INT          NOT NULL,
    fonte VARCHAR(100) NOT NULL,
    dol   BOOLEAN      NOT NULL
);
```

### 2. Configurar credenciais

Crie um arquivo `config.properties` na raiz do projeto:

```
db.url=jdbc:mysql://127.0.0.1:3306/entry_managerDB
db.usuario=seu_usuario
db.senha=sua_senha
```

> O arquivo `config.properties` não é versionado — cada um usa suas próprias credenciais.

### 3. Rodar

Execute a classe `Main.java` pela IDE.

## Comandos

| Comando | O que faz |
|---|---|
| `adicionar ganho` | Registra uma entrada |
| `adicionar dispesa` | Registra uma saída |
| `relatorio` | Mostra ganhos, despesas e balanço |
| `editar` | Edita uma entrada pelo id |
| `apagar` | Apaga uma entrada pelo id |
| `parar` | Encerra o programa |
