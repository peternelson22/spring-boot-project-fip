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

ALTER TABLE projects ADD CONSTRAINT FK_PROJECTS_ON_DEPT FOREIGN KEY (dept_id) REFERENCES departments (id);