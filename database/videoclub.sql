drop database if exists videoclub;
create database videoclub;
use videoclub;

create table genero(
id INT auto_increment primary key,
nombre VARCHAR(200)
);

create table pelicula(
id INT auto_increment primary key,
duracion INT not null,
titulo VARCHAR(200) not null,
edadMinima INT not null,
idGenero INT not null,
CONSTRAINT FK_cateoria foreign key (idGenero) REFERENCES genero(id) 
);

INSERT INTO genero(nombre) VALUES ("Acción"), ("Comedia"), ("Drama"), ("Romántica"), ("Suspense"), ("Terror"); 

INSERT INTO pelicula (duracion, titulo, edadMinima, idGenero) VALUES
(120, "Mad Max: Furia en la carretera", 16, 1),         -- Acción
(111, "Superfumados", 16, 2),                           -- Comedia
(142, "Cadena perpetua", 13, 3),                        -- Drama
(123, "El diario de Noa", 12, 4),                       -- Romántica
(149, "Perdida", 14, 5),                                -- Suspense
(112, "El conjuro", 18, 6),                             -- Terror
(101, "John Wick", 16, 1),                              -- Acción
(101, "La máscara", 7, 2),                              -- Comedia
(117, "En busca de la felicidad", 12, 3),               -- Drama
(195, "Titanic", 12, 4),                                -- Romántica
(127, "Seven", 18, 5),                                  -- Suspense
(103, "Insidious", 18, 6),                              -- Terror
(155, "Gladiator", 16, 1),                              -- Acción
(94, "La vida de Brian", 12, 2),                        -- Comedia
(129, "Orgullo y prejuicio", 12, 4);                    -- Romántica
