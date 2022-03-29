# springbatch-database-to-file
POC para transcrever dados do banco de dados para arquivo

### Preparação de banco de dados
``` json
CREATE TABLE public.example
(
    name text COLLATE pg_catalog."default",
    id integer NOT NULL,
    description text COLLATE pg_catalog."default",
    CONSTRAINT example_pkey PRIMARY KEY (id)
)
```

``` json
INSERT INTO example(
	id, name, description)
	VALUES (1, 'Erison', 'Presente');

INSERT INTO example(
	id, name, description)
	VALUES (2, 'Carlos', 'Faltou');

INSERT INTO example(
	id, name, description)
	VALUES (3, 'Kenji', 'Presente');
```