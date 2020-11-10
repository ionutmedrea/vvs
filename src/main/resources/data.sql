DROP TABLE IF EXISTS user cascade;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  passwordConfirm VARCHAR(250) NOT NULL,
  role VARCHAR(250) NOT NULL
);

INSERT INTO user(username, password, passwordConfirm, role) VALUES
  ('ion', 'ion', 'ion', 'profesor'),
  ('asd', 'dsa', 'dsa', 'profesor');