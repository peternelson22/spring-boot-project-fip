/***********************/
/* TABLE: pay_roll */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS payroll_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE employee_payroll (
  payroll_id BIGINT NOT NULL,
   salary_id BIGINT NOT NULL
);

CREATE TABLE payroll (
  id BIGINT NOT NULL,
   payment_date date,
   amount DECIMAL,
   CONSTRAINT pk_payroll PRIMARY KEY (id)
);

ALTER TABLE employee_payroll ADD CONSTRAINT fk_emppay_on_payroll FOREIGN KEY (salary_id) REFERENCES payroll (id);

ALTER TABLE employee_payroll ADD CONSTRAINT fk_emppay_on_salary FOREIGN KEY (payroll_id) REFERENCES salary (id);

