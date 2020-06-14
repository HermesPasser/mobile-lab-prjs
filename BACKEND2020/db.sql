create database sourcecodeplataform;

create table sourcecodeplataform.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  type VARCHAR(20) DEFAULT "normal",
  primary key (id));

create table sourcecodeplataform.projetos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  filepath VARCHAR(255) UNIQUE,
  scmType VARCHAR(20) DEFAULT "git",
  primary key (id));

create table sourcecodeplataform.usuarios_projetos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idUsuario BIGINT NOT NULL, 
  idProjeto BIGINT NOT NULL,
  isOwner BOOL DEFAULT false,
  primary key (id));
  
ALTER TABLE sourcecodeplataform.usuarios_projetos 
    ADD CONSTRAINT FK_USUARIO_PROJETO FOREIGN KEY (idUsuario) REFERENCES sourcecodeplataform.usuarios (id);

ALTER TABLE sourcecodeplataform.usuarios_projetos 
    ADD CONSTRAINT FK_PROJETO_USUARIO FOREIGN KEY (idProjeto) REFERENCES sourcecodeplataform.projetos (id);  


INSERT INTO `sourcecodeplataform`.`usuarios` (`id`, `name`,  `email`, `password`) 
    VALUES ('1', 'Bil Gates', 'bgates@mail.com', '1234');

INSERT INTO `sourcecodeplataform`.`usuarios` (`id`, `name`,  `email`, `password`) 
    VALUES ('2', 'Ken Thompson', 'thompson@mail.com', '3331');
    
INSERT INTO `sourcecodeplataform`.`usuarios` ( `name`,  `email`, `password`, `type`) 
    VALUES ('douglas', 'douglas@gmail.com', '11', "ADM");


INSERT INTO `sourcecodeplataform`.`projetos` (`id`, `name`,  `description`, `filepath`) 
    VALUES ('1', 'grep', 'search tool', 'chrome.zip');

INSERT INTO `sourcecodeplataform`.`projetos` (`id`, `name`,  `description`, `filepath`) 
    VALUES ('2', 'dos', 'operating system', '\files\ken\dos.zip');



INSERT INTO `sourcecodeplataform`.`usuarios_projetos` (`idUsuario`,  `idProjeto`) 
    VALUES ( '1', '2');

INSERT INTO `sourcecodeplataform`.`usuarios_projetos` (`idUsuario`,  `idProjeto`) 
    VALUES ('2', '1');
    

SELECT up.id 'ID', pr.name 'PROJETO', pr.description 'DESCRIPTION', us.name 'AUTHOR', pr.filepath 'PATH'
	FROM sourcecodeplataform.usuarios us, sourcecodeplataform.projetos pr, sourcecodeplataform.usuarios_projetos up
    WHERE up.idUsuario = us.id and up.idProjeto = pr.id;