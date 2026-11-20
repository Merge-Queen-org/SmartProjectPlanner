DROP
DATABASE IF EXISTS smartplanner;
CREATE
DATABASE smartplanner;
USE
smartplanner;

CREATE TABLE office
(
    office_id      INT AUTO_INCREMENT PRIMARY KEY,
    office_name    VARCHAR(100) NOT NULL,
    office_country VARCHAR(50)  NOT NULL
);

CREATE TABLE employee
(
    employee_id   INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL
);

CREATE TABLE project
(
    project_id          INT AUTO_INCREMENT PRIMARY KEY,
    office_id           INT          NOT NULL,
    project_name        VARCHAR(100) NOT NULL,
    project_description VARCHAR(1000),
    project_start_date  DATE         NOT NULL,
    project_deadline    DATE         NOT NULL,
    FOREIGN KEY (office_id) REFERENCES office (office_id),
    CONSTRAINT chk_project_dates CHECK (project_deadline >= project_start_date)
);

CREATE TABLE subproject
(
    subproject_id          INT AUTO_INCREMENT PRIMARY KEY,
    project_id             INT          NOT NULL,
    subproject_name        VARCHAR(100) NOT NULL,
    subproject_description VARCHAR(1000),
    FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);

CREATE TABLE task
(
    task_id              INT AUTO_INCREMENT PRIMARY KEY,
    subproject_id        INT          NOT NULL,
    employee_id          INT,
    task_name            VARCHAR(100) NOT NULL,
    task_status          ENUM('TODO', 'IN_PROGRESS','TESTING', 'REVIEW','DONE','BACKLOG','CANCELLED') NOT NULL DEFAULT 'TODO',
    task_priority        ENUM('LOW', 'MEDIUM', 'HIGH', 'URGENT', 'NONE') NOT NULL DEFAULT 'MEDIUM',
    task_description     VARCHAR(1000),
    task_estimated_hours INT          NOT NULL DEFAULT 0,
    task_start_date      DATE,
    task_due_date        DATE,
    FOREIGN KEY (subproject_id) REFERENCES subproject (subproject_id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employee (employee_id) ON DELETE SET NULL,
    CONSTRAINT chk_task_hours CHECK (task_estimated_hours >= 0),
    CONSTRAINT chk_task_dates CHECK (task_due_date >= task_start_date)
);

CREATE TABLE subtask
(
    subtask_id   INT AUTO_INCREMENT PRIMARY KEY,
    task_id      INT          NOT NULL,
    subtask_name VARCHAR(100) NOT NULL,
    subtask_done BOOLEAN      NOT NULL DEFAULT FALSE,
    FOREIGN KEY (task_id) REFERENCES task (task_id) ON DELETE CASCADE
);
