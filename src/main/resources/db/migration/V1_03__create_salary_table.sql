/***********************/
/* TABLE: salary */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS salary_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE salary (
  id BIGINT NOT NULL,
   amount DECIMAL,
   bonus DECIMAL,
   date_time TIMESTAMP WITHOUT TIME ZONE,
   employee_id BIGINT,
   CONSTRAINT pk_salary PRIMARY KEY (id)
);

ALTER TABLE salary ADD CONSTRAINT FK_SALARY_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);
