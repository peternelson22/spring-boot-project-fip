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

/***********************/
/* TABLE: users */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
  id BIGINT NOT NULL,
   username VARCHAR(255) NOT NULL,
   email VARCHAR(255),
   password VARCHAR(255),
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   employee_id BIGINT,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);

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

/***********************/
/* TABLE: login */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS login_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE login (
  id BIGINT NOT NULL,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255),
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_login PRIMARY KEY (id)
);

ALTER TABLE login ADD CONSTRAINT uc_login_username UNIQUE (username);

ALTER TABLE login ADD CONSTRAINT FK_LOGIN_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

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

/***********************/
/* TABLE: pay_roll */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS payroll_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE employee_payroll (
  payroll_id BIGINT NOT NULL,
   salary_id BIGINT NOT NULL
);

CREATE TABLE pay_roll (
  id BIGINT NOT NULL,
   payment_date date,
   amount DECIMAL,
   CONSTRAINT pk_payroll PRIMARY KEY (id)
);

ALTER TABLE employee_payroll ADD CONSTRAINT fk_emppay_on_pay_roll FOREIGN KEY (salary_id) REFERENCES pay_roll (id);

ALTER TABLE employee_payroll ADD CONSTRAINT fk_emppay_on_salary FOREIGN KEY (payroll_id) REFERENCES salary (id);

/***********************/
/* TABLE: projects */
/***********************/
CREATE SEQUENCE  IF NOT EXISTS project_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE projects (
  id BIGINT NOT NULL,
   project_name VARCHAR(255),
   description VARCHAR(255),
   start_date date,
   end_date date,
   project_status VARCHAR(255),
   dept_id BIGINT,
   CONSTRAINT pk_projects PRIMARY KEY (id)
);

ALTER TABLE projects ADD CONSTRAINT FK_PROJECTS_ON_DEPT FOREIGN KEY (dept_id) REFERENCES department (id);

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
