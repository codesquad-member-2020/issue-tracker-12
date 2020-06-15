INSERT INTO user (github_id, profile_url)
VALUES ('wooody92', 'www.image1.com'),
       ('henry', 'www.image2.com');

INSERT INTO milestone (title, description, status, due_date)
VALUES ('milestone title 1', 'milestone desc 1', 'OPEN', '2020-07-10'),
       ('milestone title 2', 'milestone desc 2', 'OPEN', '2020-07-10'),
       ('milestone title 3', 'milestone desc 3', 'CLOSE', '2020-07-10');

INSERT INTO issue (title, content, user_id, milestone_id, status, create_time)
VALUES ('issue title 1', 'issue content 1', 1, 1, 'OPEN', '2020-06-10'),
       ('issue title 2', 'issue content 2', 1, 1, 'OPEN', '2020-06-10'),
       ('issue title 3', 'issue content 3', 1, 1, 'OPEN', '2020-06-10'),
       ('issue title 4', 'issue content 4', 2, 1, 'OPEN', '2020-06-10'),
       ('issue title 5', 'issue content 5', 2, 2, 'OPEN', '2020-06-10'),
       ('issue title 6', 'issue content 6', 2, 2, 'CLOSE', '2020-06-10');

INSERT INTO comment (content, create_time, issue_id, user_id)
VALUES ('comment content 1', '2020-06-10', 1, 1),
       ('comment content 2', '2020-06-10', 1, 2),
       ('comment content 1', '2020-06-10', 1, 1),
       ('comment content 1', '2020-06-10', 2, 1),
       ('comment content 1', '2020-06-10', 3, 1);

INSERT INTO label (name, description, text_color, background_color)
VALUES ('label BE', 'dev BE', '#fff', '#CB5CD0'),
       ('label FE', 'dev FE', '#fff', '#FA2877'),
       ('label OS', 'dev OS', '#000', '#56B92A'),
       ('label KM', 'dev KM', '#fff', '#7694E7'),
       ('label GG', 'dev GG', '#000', '#80B168');

INSERT INTO issue_has_label (issue_id, label_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 4),
       (3, 5);
