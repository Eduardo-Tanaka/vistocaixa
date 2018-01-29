DROP TABLE dbo.TB_TAREFA;
DROP TABLE dbo.TB_USER;

CREATE TABLE dbo.TB_USER(
	id_user int primary key identity,
	nm_user varchar(250) not null,
	ds_email varchar(100) not null unique,
	ds_password varchar(100) not null,
	ds_role varchar(20) not null
);

CREATE TABLE dbo.TB_TAREFA(
	id_tarefa int primary key identity,
	ds_title varchar(50) not null,
	ds_tarefa varchar(200) not null,
	dt_tarefa smalldatetime not null,
	id_user int not null,
    FOREIGN KEY (id_user) REFERENCES dbo.TB_USER(id_user)
);