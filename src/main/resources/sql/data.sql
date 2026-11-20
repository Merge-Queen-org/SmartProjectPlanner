-- Offices (3 USA, 1 Denmark, 1 Norway)
INSERT INTO office (office_id, office_name, office_country)
VALUES (1, 'Copenhagen', 'Denmark'),
       (2, 'Oslo', 'Norway'),
       (3, 'New Jersey', 'USA'),
       (4, 'Los Angeles', 'USA'),
       (5, 'Dallas', 'USA');

-- Employees
INSERT INTO employee (employee_id, employee_name)
VALUES (1, 'Anna Berg'),
       (2, 'Mikkel Kjær'),
       (3, 'Sofie Larsen'),
       (4, 'Jonas Ravn');

-- Projects
INSERT INTO project (project_id, office_id, project_name, project_description, project_start_date, project_deadline)
VALUES (1, 1, 'Website redesign', 'New responsive website for Alpha Solutions with updated branding.', '2027-02-01',
        '2027-03-15'),
       (2, 2, 'Mobile app MVP', 'First version of a booking app for iOS and Android.', '2027-01-15', '2027-03-01'),
       (3, 3, 'CRM integration', 'Connect the sales system to the customer database.', '2027-03-01', '2027-04-30');

-- Subprojects
INSERT INTO subproject (subproject_id, project_id, subproject_name, subproject_description)
VALUES
-- Website redesign
(1, 1, 'Design', 'Wireframes, mockups and style guide.'),
(2, 1, 'Frontend', 'Build the pages in HTML and CSS.'),
(3, 1, 'Testing', 'Test on browsers and devices.'),
-- Mobile app MVP
(4, 2, 'Backend', 'API and database for bookings.'),
(5, 2, 'App', 'Screens and navigation in the app.'),
-- CRM integration
(6, 3, 'Analysis', 'Map data fields between the two systems.'),
(7, 3, 'Integration', 'Build and test the data sync.');

-- Tasks
INSERT INTO task (task_id, subproject_id, employee_id, task_name, task_status, task_priority, task_description,
                  task_estimated_hours, task_start_date, task_due_date)
VALUES
-- Website redesign / Design
(1, 1, 1, 'Wireframes', 'DONE', 'HIGH', 'Low-fi wireframes for all main pages.', 16, '2027-02-01', '2027-02-05'),
(2, 1, 1, 'Style guide', 'IN_PROGRESS', 'MEDIUM', 'Colours, fonts and components.', 12, '2027-02-04', '2027-02-10'),
-- Website redesign / Frontend
(3, 2, 3, 'Homepage', 'TODO', 'HIGH', 'Build the homepage from the mockup.', 20, '2027-02-11', '2027-02-19'),
(4, 2, 3, 'Contact form', 'BACKLOG', 'LOW', NULL, 8, NULL, NULL),
-- Website redesign / Testing
(5, 3, NULL, 'Write E2E tests', 'TESTING', 'MEDIUM', 'Playwright tests for the main flows.', 16, '2027-03-01',
 '2027-03-10'),
-- Mobile app MVP / Backend
(6, 4, 2, 'Booking API', 'REVIEW', 'URGENT', 'Endpoints for create and cancel booking.', 28, '2027-01-15',
 '2027-02-05'),
(7, 4, 2, 'Database setup', 'DONE', 'HIGH', NULL, 10, '2027-01-15', '2027-01-20'),
(8, 4, 2, 'Push notifications', 'CANCELLED', 'LOW', 'Moved to version 2.', 12, NULL, NULL),
-- Mobile app MVP / App
(9, 5, 2, 'Login screen', 'IN_PROGRESS', 'HIGH', NULL, 14, '2027-02-01', '2027-02-12'),
(10, 5, 4, 'Booking screen', 'TODO', 'URGENT', 'Pick date and time, confirm booking.', 24, '2027-02-08', '2027-02-24'),
-- CRM integration / Analysis
(11, 6, 4, 'Map data fields', 'TODO', 'MEDIUM', NULL, 10, '2027-03-01', '2027-03-08'),
-- CRM integration / Integration
(12, 7, NULL, 'Build sync job', 'BACKLOG', 'NONE', NULL, 30, NULL, NULL);

-- Subtasks
INSERT INTO subtask (subtask_id, task_id, subtask_name, subtask_done)
VALUES (1, 1, 'Homepage wireframe', TRUE),
       (2, 1, 'Project page wireframe', TRUE),
       (3, 2, 'Pick colours', TRUE),
       (4, 2, 'Pick fonts', FALSE),
       (5, 3, 'Hero section', FALSE),
       (6, 3, 'Footer', FALSE),
       (7, 6, 'Create booking', TRUE),
       (8, 6, 'Cancel booking', TRUE),
       (9, 6, 'Error handling', FALSE),
       (10, 9, 'Form layout', TRUE),
       (11, 9, 'Validation', FALSE);
