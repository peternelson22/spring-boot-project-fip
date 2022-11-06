/***********************/
/* TABLE: qualification */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS qualification_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE qualification (
  id BIGINT NOT NULL,
   qual_type VARCHAR(255) NOT NULL,
   date_in date,
   employee_id BIGINT,
   CONSTRAINT pk_qualification PRIMARY KEY (id)
);

ALTER TABLE qualification ADD CONSTRAINT FK_QUALIFICATION_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);
