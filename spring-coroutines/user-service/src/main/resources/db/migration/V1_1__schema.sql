CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert 50 dummy users
INSERT INTO users (name, email)
SELECT 'User ' || i,
       'user' || i || '@example.com'
FROM generate_series(1, 50) AS s(i);
