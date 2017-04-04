CREATE TABLE filme (
  id SERIAL,
  titulo VARCHAR(50) NOT NULL,
  genero VARCHAR(50) NOT NULL,
  duracao INT NOT NULL,
  estado VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE emprestimo (
  id SERIAL,
  id_filme INT NOT NULL,
  data_emprestimo DATE NOT NULL,
  data_devolucao DATE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_filme) REFERENCES filme (id) ON DELETE CASCADE
);