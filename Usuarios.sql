CREATE DATABASE enrollments;
USE enrollments;

CREATE TABLE career (
  id INT PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(128)
);

CREATE TABLE subject (
  id INT PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(128),
  career_id INT,
  FOREIGN KEY (career_id) REFERENCES career(id)
);

CREATE TABLE user (
  id INT PRIMARY KEY,
  username VARCHAR(128) UNIQUE,
  password VARCHAR(32),
  type INT NOT NULL,
  career_id INT,
  status INT NOT NULL,
  FOREIGN KEY (career_id) REFERENCES career(id)
);


INSERT INTO career (description) VALUES
  ('Informatica 1'),
  ('Leyes 2'),
  ('Ingenieria 3');


INSERT INTO subject (description, career_id) VALUES
  ('Tecnologia 1', 1),
  ('Programacion 2', 1),
  ('Derecho 3', 2),
  ('Leyes 4', 2),
  ('Sistemas operativos 5', 3);


INSERT INTO user (id, username, password, type, career_id, status) VALUES
  (123456, 'kevs1', '1234', 0, 1, 1),
  (789012, 'david2', '2345', 1, 2, 1),
  (345678, 'vane3', '3456', 2, 3, 0);
