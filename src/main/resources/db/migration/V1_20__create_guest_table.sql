CREATE SEQUENCE  IF NOT EXISTS guest_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE employee_guests (
  employee_id BIGINT NOT NULL,
   guest_id BIGINT NOT NULL
);

CREATE TABLE guest_logs (
  id BIGINT NOT NULL,
   description VARCHAR(255),
   visitor_name VARCHAR(255),
   date date,
   CONSTRAINT pk_guest_logs PRIMARY KEY (id)
);

ALTER TABLE employee_guests ADD CONSTRAINT fk_empgue_on_employee FOREIGN KEY (guest_id) REFERENCES employees (id);

ALTER TABLE employee_guests ADD CONSTRAINT fk_empgue_on_guest_log FOREIGN KEY (employee_id) REFERENCES guest_logs (id);