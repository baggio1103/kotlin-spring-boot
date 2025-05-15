CREATE TABLE items
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    stock       INTEGER        NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert 100 dummy items
INSERT INTO items (name, description, price, stock)
SELECT 'Item ' || i,
       'Description for item ' || i,
       round((random() * 100 + 1):: numeric, 2),
       (random() * 50) ::int
FROM generate_series(1, 100) AS s(i);

