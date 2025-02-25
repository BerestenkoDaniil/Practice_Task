INSERT INTO user (username, email, created_on) VALUES ('testuser1', 'test1@example.com', NOW());
INSERT INTO user (username, email, created_on) VALUES ('testuser2', 'test2@example.com', NOW());
INSERT INTO cron_job (expression, created_on) VALUES ('0 0 * * *', NOW());