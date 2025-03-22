INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES 
    ('Ilya', '2003-08-31', 'Junior', 8700),
    ('Max', '1998-05-12', 'Senior', 12000),
    ('Anna', '2000-11-22', 'Middle', 5400),
    ('Oleh', '1995-07-19', 'Senior', 15000),
    ('Nina', '2004-03-05', 'Trainee', 900),
    ('Dmytro', '2001-09-30', 'Junior', 4500),
    ('Kateryna', '1997-06-25', 'Middle', 7200),
    ('Serhii', '1992-01-14', 'Senior', 18500),
    ('Viktoria', '2005-12-10', 'Trainee', 750),
    ('Andrii', '1999-08-08', 'Junior', 3900);

INSERT INTO client(NAME)
VALUES ('Carl'),('Makar'),('Mykola'),('Brad'),('Kratos');

INSERT INTO project (CLIENT_ID, NAME, START_DATE, FINISH_DATE)
VALUES 
    (5,'RPOJECT A', '2025-01-03', '2027-02-15'),
    (2,'RPOJECT B', '2024-06-10', '2024-07-15'), 
    (3,'RPOJECT C', '2023-09-01', '2026-09-01'), 
    (3,'RPOJECT D', '2024-02-20', '2025-12-20'), 
    (1,'RPOJECT E', '2026-05-01', '2027-04-30'), 
    (4,'RPOJECT F', '2022-11-11', '2025-11-11'), 
    (1,'RPOJECT G', '2024-08-01', '2026-08-01'), 
    (5,'RPOJECT H', '2023-01-05', '2028-05-05'), 
    (3,'RPOJECT J', '2025-10-10', '2026-12-10'), 
    (4,'RPOJECT K', '2020-03-15', '2028-07-15');

INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (1,1),(1,2),(1,3),
       (2,4),(2,5),
       (3,6),
       (4,7),(4,8),(4,9),(4,10),
       (5,2),
       (6,2),(6,7),(6,3),(6,8),(6,10),
       (7,6),(7,3),
       (8,6),(8,1),(8,7),(8,5),
       (9,2),(9,10),
       (10,4);