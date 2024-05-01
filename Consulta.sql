CREATE DATABASE IF NOT EXISTS colegio;

-- Usar el esquema "colegio"
USE colegio;

-- Crear la tabla "estudiantes"
CREATE TABLE IF NOT EXISTS estudiantes (
    idestudiante INT AUTO_INCREMENT PRIMARY KEY,
    primernombre VARCHAR(50) NOT NULL,
    segundonombre VARCHAR(50),
    otronombre VARCHAR(50),
    primerapellido VARCHAR(50) NOT NULL,
    segundoapellido VARCHAR(50),
    otroapellido VARCHAR(50),
    genero ENUM('Masculino', 'Femenino', 'Otro') NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(15),
    dpi VARCHAR(20),
    colegiatura DECIMAL(10,2),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50)
);
SELECT * FROM estudiantes;
DElETE FROM estudiantes;
TRUNCATE TABLE  estudiantes;;
