CREATE TABLE IF NOT EXISTS user_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100) NOT NULL,
    phone VARCHAR (100),
    email VARCHAR (100)
);

CREATE TABLE IF NOT EXISTS skill (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS application (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_table,
    skill_id INTEGER REFERENCES skill,
    status VARCHAR (10) NOT NULL DEFAULT 'PENDING',
    date TIMESTAMP
);