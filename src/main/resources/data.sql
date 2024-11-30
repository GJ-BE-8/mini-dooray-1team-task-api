-- 프로젝트 데이터
INSERT INTO project (name, status) VALUES ('Project A', 'ACTIVE');
INSERT INTO project (name, status) VALUES ('Project B', 'DORMANT');

-- 프로젝트 멤버 데이터
INSERT INTO project_member (project_id, email, name, role) VALUES (1, 'john.doe@example.com', 'John Doe', 0);
INSERT INTO project_member (project_id, email, name, role) VALUES (1, 'jane.doe@example.com', 'Jane Doe', 1);
INSERT INTO project_member (project_id, email, name, role) VALUES (2, 'mike.smith@example.com', 'Mike Smith', 0);

-- 마일스톤 데이터
INSERT INTO mile_stone (project_id, start_time, end_time, name) VALUES (1, '2024-01-01 00:00:00', '2024-02-01 00:00:00', 'Milestone 1');
INSERT INTO mile_stone (project_id, start_time, end_time, name) VALUES (1, '2024-03-01 00:00:00', '2024-04-01 00:00:00', 'Milestone 2');
INSERT INTO mile_stone (project_id, start_time, end_time, name) VALUES (2, '2024-01-15 00:00:00', '2024-02-15 00:00:00', 'Milestone 3');

-- 태그 데이터
INSERT INTO tag (project_id, name) VALUES (1, 'Backend');
INSERT INTO tag (project_id, name) VALUES (1, 'Frontend');
INSERT INTO tag (project_id, name) VALUES (2, 'Design');

-- 업무 데이터
INSERT INTO task (mile_stone_id, status, tag, title) VALUES (1, 'IN_PROGRESS', 'Backend', 'Setup Backend Server');
INSERT INTO task (mile_stone_id, status, tag, title) VALUES (1, 'TODO', 'Frontend', 'Create Login Page');
INSERT INTO task (mile_stone_id, status, tag, title) VALUES (2, 'TODO', 'Frontend', 'Design Dashboard UI');
INSERT INTO task (mile_stone_id, status, tag, title) VALUES (3, 'IN_PROGRESS', 'Design', 'Create Wireframes');

-- 업무 멤버 데이터
INSERT INTO task_members (task_id, project_member_id, role) VALUES (1, 1, 'Developer');
INSERT INTO task_members (task_id, project_member_id, role) VALUES (1, 2, 'Reviewer');
INSERT INTO task_members (task_id, project_member_id, role) VALUES (2, 2, 'Developer');
INSERT INTO task_members (task_id, project_member_id, role) VALUES (3, 1, 'Designer');
INSERT INTO task_members (task_id, project_member_id, role) VALUES (4, 3, 'Designer');

-- 댓글 데이터
INSERT INTO comment (task_id, project_member_id, author, content, date) VALUES (1, 1, 'John Doe', 'Backend server setup is almost done.', '2024-01-10');
INSERT INTO comment (task_id, project_member_id, author, content, date) VALUES (1, 2, 'Jane Doe', 'Review is complete.', '2024-01-12');
INSERT INTO comment (task_id, project_member_id, author, content, date) VALUES (2, 2, 'Jane Doe', 'Working on the login page design.', '2024-01-15');
INSERT INTO comment (task_id, project_member_id, author, content, date) VALUES (4, 3, 'Mike Smith', 'Wireframe is under review.', '2024-01-20');

