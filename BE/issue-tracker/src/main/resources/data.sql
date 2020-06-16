INSERT INTO user (github_id, profile_url)
VALUES ('wooody92', 'www.image1.com'),
       ('henry', 'www.image2.com');

INSERT INTO milestone (title, description, status, due_date)
VALUES ('milestone title 1', 'milestone desc 1', true, '2020-07-10'),
       ('milestone title 2', 'milestone desc 2', true, '2020-07-10'),
       ('milestone title 3', 'milestone desc 3', true, '2020-07-10');

INSERT INTO issue (title, content, user_id, milestone_id, status, create_time)
VALUES ('issue title 1', 'issue content 1', 1, 1, true, '2020-06-10'),
       ('issue title 2', 'issue content 2', 1, 1, true, '2020-06-10'),
       ('issue title 3', 'issue content 3', 1, 1, true, '2020-06-10'),
       ('issue title 4', 'issue content 4', 2, 1, true, '2020-06-10'),
       ('issue title 5', 'issue content 5', 2, 2, true, '2020-06-10'),
       ('issue title 6', 'issue content 6', 2, 2, true, '2020-06-10');

INSERT INTO comment (content, create_time, issue_id, user_id)
VALUES ('comment content 1', '2020-06-10', 1, 1),
       ('comment content 2', '2020-06-10', 1, 2),
       ('comment content 1', '2020-06-10', 1, 1),
       ('comment content 1', '2020-06-10', 2, 1),
       ('comment content 1', '2020-06-10', 3, 1);

INSERT INTO label (name, description, color_code, issue_id)
VALUES ('label BE', 'dev BE', 'red 1', '1'),
       ('label FE', 'dev FE', 'red 2', '1'),
       ('label OS', 'dev OS', 'red 3', '2'),
       ('label KM', 'dev KM', 'red 4', '2'),
       ('label GG', 'dev GG', 'red 5', '3');
