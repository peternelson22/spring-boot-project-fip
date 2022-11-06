/***********************/
/* TABLE: leave */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS leave_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE leave (
  id BIGINT NOT NULL,
   date_of_leave date,
   end_date date,
   weeks_spent INTEGER,
   employee_id BIGINT,
   CONSTRAINT pk_leave PRIMARY KEY (id)
);

ALTER TABLE leave ADD CONSTRAINT FK_LEAVE_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);

