CREATE TABLE situacao_cadastro(
    id INT PRIMARY KEY,
    descricao VARCHAR(30) NOT NULL
);


CREATE TABLE usuario(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    emailVARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(40) NOT NULL,
    id_situacaocadastro INT NOT NULL,
    FOREIGN KEY (id_situacaocadastro) REFERENCES situacao_cadastro(id)
);


CREATE TABLE permissao(
    id INT PRIMARY KEY,
    descricao VARCHAR(30) NOT NULL
);


CREATE TABLE usuariopermissao(
    id SERIAL PRIMARY KEY,
    id_usuario   INT NOT NULL,
    id_permissao INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_permissao) REFERENCES permissao(id)
);


CREATE TABLE status_mesa(
    id INT PRIMARY KEY,
    descricao VARCHAR(30) NOT NULL
);


CREATE TABLE mesa(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(40) NOT NULL,
    id_statusmesa INT NOT NULL,
    FOREIGN KEY (id_statusmesa) REFERENCES status_mesa(id)
);


CREATE TABLE status(
    id INT PRIMARY KEY,
    descricao VARCHAR(30) NOT NULL
);


CREATE TABLE ficha(
    id SERIAL PRIMARY KEY,
    id_mesa INT NOT NULL,
    id_statusficha INT NOT NULL,
    FOREIGN KEY (id_mesa) REFERENCES mesa(id),
    FOREIGN KEY (id_statusficha) REFERENCES status(id)
);


CREATE TABLE produto(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(40) NOT NULL,
    preco NUMERIC(11, 2) NOT NULL,
    categoria VARCHAR(40) NOT NULL
);


CREATE TABLE pedido(
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    id_status INT NOT NULL,
    FOREIGN KEY (id_status) REFERENCES status id)
);


CREATE TABLE pedidoproduto(
    id SERIAL PRIMARY KEY,
    id_produto INT NOT NULL,
    id_pedido  INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES produto(id),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id)
);


--INSERTS DE DADOS
INSERT INTO situacao_cadastro(id, descricao)
VALUES (0, 'EXCLUIDO'),
       (1, 'ATIVO');


INSERT INTO usuario(nome, email, senha, id_situacaocadastro)
VALUES ('Ana Beatriz da Silva', 'ana.silva@example.com', 'senhaAna123', 1),
       ('Carlos Eduardo Almeida', 'carlos.almeida@example.com', 'senhaCarlos456', 1),
       ('Fernanda Oliveira Costa', 'fernanda.costa@example.com', 'senhaFernanda789', 1),
       ('Lucas Vinícius Santos', 'lucas.santos@example.com', 'senhaLucas321', 1),
       ('Juliana Pereira Lima', 'juliana.lima@example.com', 'senhaJuliana654', 0);


INSERT INTO permissao(id, descricao)
VALUES (0, 'Acesso Total ao Sistema'),
       (1, 'Gerenciamento de Usuários');


INSERT INTO usuariopermissao(id_usuario, id_permissao)
VALUES (1, 0),
       (1, 0),
       (2, 1),
       (3, 1),
       (4, 1);


INSERT INTO status_mesa(id, descricao)
VALUES (0, 'OCUPADO'),
       (1, 'LIVRE');


INSERT INTO mesa(descricao, id_statusmesa)
VALUES ('Mesa VIP - Eventos Especiais', 0),
       ('Mesa Familiar - Para Grupos', 1),
       ('Mesa de Reunião - Executiva', 1),
       ('Mesa do Café - Reuniões Informais', 1),
       ('Mesa ao Ar Livre - Ambiente Externo', 1);


INSERT INTO status(id, descricao)
VALUES (0, 'FINALIZADA'),
       (1, 'EM ABERTO');


INSERT INTO ficha(id_mesa, id_statusficha)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 0);


INSERT INTO produto(descricao, preco, categoria)
VALUES ('Cerveja Artesanal - 500ml', 15.00, 'Bebidas'),
       ('Pizza Margherita - 8 Fatias', 30.00, 'Alimentação'),
       ('Refrigerante Lata - 350ml', 5.00, 'Bebidas'),
       ('Sanduíche Natural - Frango', 12.50, 'Alimentação'),
       ('Salada Caesar - Individual', 20.00, 'Alimentação');


INSERT INTO pedido(data, id_status)
VALUES ('2024-10-01', 1),
       ('2024-10-05', 1),
       ('2024-10-10', 1),
       ('2024-10-15', 1),
       ('2024-10-20', 0);


INSERT INTO pedidoproduto(id_produto, id_pedido, quantidade)
VALUES (1, 1, 2),
       (2, 1, 1),
       (3, 2, 3),
       (4, 3, 5),
       (5, 4, 2);