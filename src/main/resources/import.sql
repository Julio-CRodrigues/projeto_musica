insert into artista (nome_artista, qtd_albuns, pais_origem, data_fundacao) values ('Skank',10,'Brasil','1980-01-01');
insert into artista (nome_artista, qtd_albuns, pais_origem, data_fundacao) values ('Iron Maiden',20,'Reino Unido','1970-01-01');
insert into artista (nome_artista, qtd_albuns, pais_origem, data_fundacao) values ('Linkin Park',15,'Estados Unidados','1994-01-01');
insert into artista (nome_artista, qtd_albuns, pais_origem, data_fundacao) values ('Metallica',50,'Estados Unidados','1981-01-01');
insert into artista (nome_artista, qtd_albuns, pais_origem, data_fundacao) values ('Oasis',15,'Reino Unido','1991-01-01');

insert into integrante (id_artista,nome,funcao,data_nascimento) values (1,'Samuel Rosa','Vocalista','1965-01-01');
insert into integrante (id_artista,nome,funcao,data_nascimento) values (2,'Dave Murray','Guitarrista','1956-01-01');
insert into integrante (id_artista,nome,funcao,data_nascimento) values (3,'Mike Shinoda','Guitarrista','1977-01-01');
insert into integrante (id_artista,nome,funcao,data_nascimento) values (4,'James Hetfield','Vocalista','1956-01-01');
insert into integrante (id_artista,nome,funcao,data_nascimento) values (5,'Noel Gallagher','Baixista','1977-01-01');

insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(1,'Segundo Sol',3.0,'Rock','2011-01-01',false);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(1,'Vamos Fugir',5.5,'Rock','2007-01-01',false);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(2,'Fear of the Dark',7.5, 'Metal','1982-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(2,'Run To Hills',5.5, 'Metal','1982-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(3,'Numb',4.7,'Rock','2003-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(3,'Give It Up',6.3,'Rock','2003-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(4,'Enter The Sandman',4.3,'Metal','1995-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(4,'Nothing Else Matters',6.3,'Metal','1987-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(5,'Wonderwall',9.3,'Rock','1995-01-01',true);
insert into musica (id_artista, titulo, duracao, genero, data_lancamento, internacional) values(5,'Live Forever',6.3,'Rock','1987-01-01',true);