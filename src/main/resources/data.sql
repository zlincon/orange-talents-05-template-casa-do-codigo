INSERT INTO autores(nome, email, descricao, timestamp) VALUES ('Jose de Alencar', 'juse@email.com', 'Autor nascido em Fortaleza - Ceará', CURRENT_TIMESTAMP);
INSERT INTO autores(nome, email, descricao, timestamp) VALUES ('Machado de Assis', 'machado@email.com', 'Autor nascido na Chácara do Livramento- Rio de Janeiro', CURRENT_TIMESTAMP);
INSERT INTO autores(nome, email, descricao, timestamp) VALUES ('Franz Kafka', 'franz@email.com', 'Autor nascido em Praga', CURRENT_TIMESTAMP);
INSERT INTO autores(nome, email, descricao, timestamp) VALUES ('Clarice Lispector', 'clarice@email.com', 'Autor nascido em Tchetchelnik - Ucrânia', CURRENT_TIMESTAMP);
INSERT INTO autores(nome, email, descricao, timestamp) VALUES ('Fernando Pessoa', 'fer@email.com', 'Autor nascido em Lisboa - Portugual', CURRENT_TIMESTAMP);

INSERT INTO categorias(nome) VALUES ('Romantismo');
INSERT INTO categorias(nome) VALUES ('Realismo');
INSERT INTO categorias(nome) VALUES ('Modernismo');
INSERT INTO categorias(nome) VALUES ('Neoclassicismo');

INSERT INTO livros(titulo, resumo, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Iracema', 'A narrativa de Iracema estrutura-se em torno da história do amor de Martim por Iracema.', 30, 235, 'dsa2', '1865-05-21', 1, 1);
INSERT INTO livros(titulo, resumo, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Livro do Desassossego', 'Na obra, o narrador principal é o “semi-heteronômio” Bernardo Soares. O ajudante de guarda-livros escreve sua “autobiografia sem fatos”, sem noção de tempo definida e encadeamento narrativo claro.', 35.5, 200, 'dsa2asd', '1982-05-21', 1, 5);