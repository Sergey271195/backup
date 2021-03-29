CREATE TABLE IF NOT EXISTS user_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100) NOT NULL,
    phone VARCHAR (100),
    email VARCHAR (100),
    role VARCHAR (20) NOT NULL 
);

CREATE TABLE IF NOT EXISTS skill (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS application (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_table,
    skill_id INTEGER REFERENCES skill,
    status VARCHAR (20) NOT NULL DEFAULT 'PENDING',
    date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_skill (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_table,
    skill_id INTEGER REFERENCES skill
);


CREATE TABLE IF NOT EXISTS free_time (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_table,
    weekday INTEGER NOT NULL,
    time TIME
);

CREATE TABLE IF NOT EXISTS interview (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_table,
    expert_id INTEGER REFERENCES user_table,
    date TIMESTAMP,
    skill_id INTEGER REFERENCES skill,
    status VARCHAR (20),
    review TEXT
);

INSERT INTO skill VALUES (1, 'Java');
INSERT INTO skill VALUES (2, 'JavaScript');
INSERT INTO skill VALUES (3, 'Python');
INSERT INTO skill VALUES (4, 'Ruby');
INSERT INTO skill VALUES (5, 'Go');
INSERT INTO skill VALUES (6, 'Haskell');