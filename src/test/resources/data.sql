CREATE SCHEMA IF NOT EXISTS solicitante;

CREATE TABLE solicitante.identificacion_solicitante (
    identificador UUID PRIMARY KEY,
    identificacion_categoria_id VARCHAR(50),
    nombre VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS solicitante.solicitante (
    identificador UUID NOT NULL,
    contrasena VARCHAR(16) NOT NULL,
    nombre VARCHAR(30),
    numero_identificacion VARCHAR(12),
    numero_telefonico BIGINT,
    usuario VARCHAR(15) NOT NULL,
    identificacion_id UUID,
    CONSTRAINT solicitante_pkey PRIMARY KEY (identificador),
    CONSTRAINT fkt7tvbeqftadeuungq77y2w80p FOREIGN KEY (identificacion_id) REFERENCES solicitante.identificacion_solicitante (identificador)
);

INSERT INTO solicitante.identificacion_solicitante(identificador, identificacion_categoria_id, nombre)
VALUES ('a1ee5b2b-f29d-4aa8-aa3a-61610177fa2b', 'C.C', 'Cedula de Ciudadania');
