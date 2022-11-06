/***********************/
/* TABLE: dependents */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS dependent_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE dependents (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   phone_mobile VARCHAR(255),
   dob date,
   gender VARCHAR(255),
   relationship VARCHAR(255),
   employee_id BIGINT,
   CONSTRAINT pk_dependents PRIMARY KEY (id)
);

ALTER TABLE dependents ADD CONSTRAINT FK_DEPENDENTS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);
