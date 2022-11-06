/***********************/
/* TABLE: users */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
  id BIGINT NOT NULL,
   username VARCHAR(255) NOT NULL,
   email VARCHAR(255),
   password VARCHAR(255),
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   employee_id BIGINT,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);