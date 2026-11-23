DROP TABLE IF EXISTS subproject;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS office;

CREATE TABLE office
(
    office_id      INT AUTO_INCREMENT PRIMARY KEY,
    office_name    VARCHAR(100) NOT NULL,
    office_country VARCHAR(50)  NOT NULL
);

CREATE TABLE project
(
    project_id          INT AUTO_INCREMENT PRIMARY KEY,
    office_id           INT          NOT NULL,
    project_name        VARCHAR(100) NOT NULL,
    project_description VARCHAR(1000),
    project_start_date  DATE         NOT NULL,
    project_deadline    DATE         NOT NULL,
    FOREIGN KEY (office_id) REFERENCES office (office_id)
);

CREATE TABLE subproject
(
    subproject_id          INT AUTO_INCREMENT PRIMARY KEY,
    project_id             INT          NOT NULL,
    subproject_name        VARCHAR(100) NOT NULL,
    subproject_description VARCHAR(1000),
    FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);

INSERT INTO office (office_id, office_name, office_country)
VALUES (1, 'Copenhagen', 'Denmark');

INSERT INTO project (project_id, office_id, project_name, project_description, project_start_date, project_deadline)
VALUES (1, 1, 'Website redesign', 'New website', '2027-02-01', '2027-03-15'),
       (2, 1, 'Mobile app MVP', 'Booking app', '2027-01-15', '2027-03-01');

INSERT INTO subproject (subproject_id, project_id, subproject_name, subproject_description)
VALUES (1, 1, 'Design', 'Wireframes'),
       (2, 1, 'Frontend', 'HTML and CSS');
