insert into estado (nome, sigla) values( 'Tocantins', 'TO');
insert into estado (nome, sigla) values( 'Goiás', 'GO');
insert into estado (nome, sigla) values( 'São Paulo', 'SP');
insert into estado (nome, sigla) values( 'Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values( 'Pará', 'PA');

insert into cidade (nome, id_estado) values( 'Palmas', 1);
insert into cidade (nome, id_estado) values( 'Paraíso', 1);
insert into cidade (nome, id_estado) values( 'Gurupi', 1);
insert into cidade (nome, id_estado) values( 'Goiânia', 2);
insert into cidade (nome, id_estado) values( 'Anápolis', 2);

-- senha 111
insert into usuario (username, senha) values ('janio', '1BTSU7LatsY6BK9FYiXT9du++eWLisRMBwGyxbRSh0ZpH0p3jIIAWh1+Ta/zBagkeJa/NwPo5XngKb/REUH74g==');
insert into usuario (username, senha) values ('leandra', '222');
insert into usuario (username, senha) values ('carlos', '333');

insert into pessoa (cpf, nome, datanascimento, id_usuario) values ('111.111.111-11', 'Janio Teixeira', '1980-08-26', 1);
insert into pessoa (cpf, nome, datanascimento, id_usuario) values ('222.222.222-22', 'Leandra', '1985-08-12', 2);
insert into pessoa (cpf, nome, datanascimento, id_usuario) values ('333.333.333-33', 'Carlos Henrique', '1982-06-11', 3);
insert into pessoa (cpf, nome, datanascimento, id_usuario) values ('444.444.444-44', 'Fredson', '1982-06-11', null);

insert into paciente (id_pessoa, id_cidade) values (1, 4);
insert into paciente (id_pessoa, id_cidade) values (2, 1);
insert into paciente (id_pessoa, id_cidade) values (4, 2);

insert into psicologo(crp, id_pessoa) values ('444', 3);

insert into consulta (nome, preco, nomeImagem) values ('Avulsa', 200.00, 'pacote1.jpeg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 1', 400.00, 'pacote2.jpeg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 2', 600.00, 'pacote3.jpg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 3', 800.00, 'pacote4.jpg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 4', 1000.00, 'pacote5.jpg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 5', 1200.00, 'pacote6.jpg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 6', 1400.00, 'pacote1.jpeg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 7', 1600.00, 'pacote2.jpeg');
insert into consulta (nome, preco, nomeImagem) values ('Pacote 8', 1800.00, 'pacote3.jpg');

insert into consultaavulsa (id, tipoConsulta) values (1, 1);

