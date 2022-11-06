
/***********************/
/* TABLE: contacts */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS contact_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE contacts (
  id BIGINT NOT NULL,
   phone_mobile VARCHAR(255) NOT NULL,
   phone_home VARCHAR(255),
   next_of_kin_mobile VARCHAR(255),
   address VARCHAR(255) NOT NULL,
   employee_id BIGINT,
   CONSTRAINT pk_contacts PRIMARY KEY (id)
);

ALTER TABLE contacts ADD CONSTRAINT FK_CONTACTS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);