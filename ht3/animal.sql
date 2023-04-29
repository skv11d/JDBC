CREATE DATABASE animals;

USE animals;

CREATE TABLE Animals 
(
	id INT auto_increment primary key,
    age INT NOT NULL,
    name VARCHAR(15) NOT NULL,
    tail boolean NOT NULL
);