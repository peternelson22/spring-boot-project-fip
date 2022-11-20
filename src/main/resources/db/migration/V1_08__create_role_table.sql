/***********************/
/* TABLE: roles */
/***********************/

CREATE SEQUENCE  IF NOT EXISTS role_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE roles (
  id BIGINT NOT NULL,
   role_name VARCHAR(255),
   CONSTRAINT pk_role PRIMARY KEY (id)
);