/***********************/
/* TABLE: users */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE user_role (
  role_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users (
  id BIGINT NOT NULL,
   username VARCHAR(255) NOT NULL,
   email VARCHAR(255),
   password VARCHAR(255),
   created_at date,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_on_employee_user FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES role (id);