-- Autoridades
INSERT INTO AUTHORITY (AUTHORITY_ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (AUTHORITY_ID, NAME) VALUES (2, 'ROLE_ADMIN');


-- Usuários
-- admin:admin
INSERT INTO app_user (user_id, cep, education_degree, email, enabled, full_address, lastpasswordresetdate, user_name, user_password, phone_alternative, phone_principal, profession, cpf)
VALUES(1, '123123', 'Ensino Superior', 'admin@admin.com', true, 'Endereco', '2018-08-29 15:45:42.145', 'Icaro', '$2a$10$lXSeX4RaIxA2EroEGmlF5eUlWjFnafClZQnW.LOOVN7p47RcA1I3K', '619808080',
'619808080', 'Eng', 'admin');

--user:user
INSERT INTO app_user (user_id, cep, education_degree, email, enabled, full_address, lastpasswordresetdate, user_name, user_password, phone_alternative, phone_principal, profession, cpf)
VALUES(2, '123123', 'Ensino Superior', 'user@user.com', true, 'Endereco', '2018-08-29 15:45:42.145', 'Icaro', '$2a$10$iKpqAWw.r7OZEUQD5xsFD.XGeHHKJXXJ/5P369a1Yc8OZE9.XSZQ2', '619808080',
'619808080', 'Eng', 'user');


-- Atribuição dos usuários com as roles
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);

-- Status do projeto
INSERT INTO project_status (project_status_id, description) VALUES (1, 'Aceito');
INSERT INTO project_status (project_status_id, description) VALUES (2, 'Negado');
INSERT INTO project_status (project_status_id, description) VALUES (3, 'Em análise');

-- Descrição de áreas do projeto
INSERT INTO project_area (project_area_id, name, description) VALUES (1, 'PSP1', 'Probabilidade e Estatística');
INSERT INTO project_area (project_area_id, name, description) VALUES (2, 'PSP2', 'Sistemas de Informação');
INSERT INTO project_area (project_area_id, name, description) VALUES (4, 'PSP4', 'Planejamento e Controle da Produção');
INSERT INTO project_area (project_area_id, name, description) VALUES (5, 'PSP5', 'Gestão da Qualidade');
INSERT INTO project_area (project_area_id, name, description) VALUES (6, 'PSP6', 'Engenharia do Produto');
INSERT INTO project_area (project_area_id, name, description) VALUES (7, 'PSP7', 'Gestão Estratégica');

-- Categoria do autor do projeto
INSERT INTO project_author_category(project_author_category_id, description) VALUES (1, 'PESSOA_FISICA');
INSERT INTO project_author_category(project_author_category_id, description) VALUES (2, 'PESSOA_JURIDICA');

-- Descrição de áreas dos projetos
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (1, 1, 'Análise de Banco de Dados');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (2, 1, 'Criação de Questionários de Pesquisa');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (3, 1, 'Outras');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (4, 2, 'Projeto de Sistemas de Informação');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (5, 2, 'Outras');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (6, 4, 'Previsão de Demanda');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (7, 4, 'Gestão de Estoques');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (8, 4, 'Criação de Ferramentas de Apoio ao Planejamento e Controle da Produção');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (9, 4, 'Outras');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (10, 5, 'Mapeamento de Processos');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (11, 5, 'Cadeia de Valor');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (12, 5, 'Melhoria Contínua de Processos');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (13, 5, 'Outras');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (14, 6, 'Elaboração de Projeto Conceitual de Produto');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (15, 5, 'Outras');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (16, 5, 'Definição de Objetivos Estratégicos');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (17, 5, 'Viabilidade Econômica');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (18, 5, 'Desdobramento de Metas');
INSERT INTO project_area_description (project_area_description_id, project_area_id, description) VALUES (19, 5, 'Outras');


-- Posts
INSERT INTO post (post_id, body, create_date, title, author_id) VALUES (1, 'Lorem ipsum', '2012-12-12 00:00:00.000', 'Titulo', 1);
INSERT INTO post (post_id, body, create_date, title, author_id) VALUES (2, 'Lorem ipsum', '2012-12-12 00:00:00.000', 'Titulo', 1);
INSERT INTO post (post_id, body, create_date, title, author_id) VALUES (3, 'Lorem ipsum', '2012-12-12 00:00:00.000', 'Titulo', 1);


-- Projetos (tem que adicionar também a descricao da area do projeto)
INSERT INTO project (project_id, answer, body, cnpj, create_date, summary, project_title, author_id, project_area_id, project_area_description_id, project_author_category_id, project_status_id)
VALUES (1, 'Projeto em Análise', 'Projeto bla bla bla', '123123123', '2018-08-29 20:26:03.696', 'resumo do meu projeto', 'Titulo do meu projeto', 1, 1, 2, 1, 3);

INSERT INTO project (project_id, answer, body, cnpj, create_date, summary, project_title, author_id, project_area_id, project_area_description_id, project_author_category_id, project_status_id)
VALUES (2, 'Projeto Aceito', 'Projeto bla bla bla', '123123123', '2018-08-29 20:26:03.696', 'resumo do meu projeto', 'Titulo do meu projeto', 1, 1, 2, 1, 1);

INSERT INTO project (project_id, answer, body, cnpj, create_date, summary, project_title, author_id, project_area_id, project_area_description_id, project_author_category_id, project_status_id)
VALUES (3, 'Projeto Negado', 'Projeto bla bla bla', '123123123', '2018-08-29 20:26:03.696', 'resumo do meu projeto', 'Titulo do meu projeto', 1, 1, 2, 1, 2);
