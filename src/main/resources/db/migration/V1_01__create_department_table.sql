/***********************/
/* TABLE: department */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS dept_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE department (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_department PRIMARY KEY (id)
);

ALTER TABLE employees ADD CONSTRAINT FK_EMPLOYEES_ON_DEPT FOREIGN KEY (dept_id) REFERENCES department (id);