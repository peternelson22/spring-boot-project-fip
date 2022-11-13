
CREATE SEQUENCE  IF NOT EXISTS guest_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE guest_logs (
  id BIGINT NOT NULL,
   description VARCHAR(255),
   date date,
   employee_id BIGINT,
   CONSTRAINT pk_guest_logs PRIMARY KEY (id)
);

ALTER TABLE guest_logs ADD CONSTRAINT FK_GUEST_LOGS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);