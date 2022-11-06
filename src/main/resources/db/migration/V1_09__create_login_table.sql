/***********************/
/* TABLE: login */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS login_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE login (
  id BIGINT NOT NULL,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255),
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_login PRIMARY KEY (id)
);

ALTER TABLE login ADD CONSTRAINT uc_login_username UNIQUE (username);

ALTER TABLE login ADD CONSTRAINT FK_LOGIN_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

