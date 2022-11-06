/***********************/
/* TABLE: employee */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS employee_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE employees (
  id BIGINT NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255),
   email VARCHAR(255) NOT NULL,
   gender VARCHAR(255),
   dob date,
   employed_date date NOT NULL,
   sacked_date date,
   dept_id BIGINT,
   CONSTRAINT pk_employees PRIMARY KEY (id)
);

ALTER TABLE employees ADD CONSTRAINT email_unique UNIQUE (email);