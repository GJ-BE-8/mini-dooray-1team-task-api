INSERT INTO project (name, status) VALUES
                                       ('Project Management App', 'ACTIVE'),
                                       ('E-commerce Platform', 'IN_PROGRESS');

INSERT INTO project_member (project_id, email, name, role) VALUES
                                                               (1, 'john.doe@example.com', 'John Doe', 0),
                                                               (1, 'jane.smith@example.com', 'Jane Smith', 1),
                                                               (2, 'mike.brown@example.com', 'Mike Brown', 0);

INSERT INTO mile_stone (project_id, name, start_time, end_time) VALUES
                                                                    (1, 'Design Phase', '2024-01-01 00:00:00', '2024-02-15 00:00:00'),
                                                                    (1, 'Development Phase', '2024-02-16 00:00:00', '2024-04-30 00:00:00'),
                                                                    (2, 'Initial Setup', '2024-03-01 00:00:00', '2024-03-31 00:00:00');

INSERT INTO tag (project_id, name) VALUES
                                       (1, 'Backend'),
                                       (1, 'Frontend'),
                                       (2, 'Infrastructure');

INSERT INTO task (mile_stone_id, title, status, tag) VALUES
                                                         (1, 'Create Database Schema', 'IN_PROGRESS', 'Backend'),
                                                         (1, 'Design User Interface', 'TODO', 'Frontend'),
                                                         (2, 'Implement Authentication', 'COMPLETED', 'Backend'),
                                                         (3, 'Set Up Cloud Infrastructure', 'IN_PROGRESS', 'Infrastructure');

INSERT INTO task_members (task_id, project_member_id, role) VALUES
                                                                (1, 1, 'OWNER'),
                                                                (1, 2, 'CONTRIBUTOR'),
                                                                (2, 2, 'OWNER'),
                                                                (3, 1, 'OWNER'),
                                                                (4, 3, 'OWNER');

INSERT INTO comment (task_id, project_member_id, author, content, date) VALUES
                                                                            (1, 1, 'John Doe', 'Need to finalize the schema', '2024-01-15'),
                                                                            (2, 2, 'Jane Smith', 'Initial mockups are ready for review', '2024-01-20'),
                                                                            (3, 1, 'John Doe', 'Authentication module completed', '2024-02-10');