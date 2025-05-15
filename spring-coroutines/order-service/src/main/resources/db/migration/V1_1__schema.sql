CREATE TABLE orders
(
    id          SERIAL PRIMARY KEY,
    user_id     INTEGER        NOT NULL,
    item_id     INTEGER        NOT NULL,
    quantity    INTEGER        NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    order_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert 100 dummy orders (randomized)
-- Insert 100 dummy orders
INSERT INTO orders (user_id, item_id, quantity, total_price)
SELECT
    (random() * 49 + 1)::int,             -- user_id (1–50)
        (random() * 99 + 1)::int,             -- item_id (1–100)
        (random() * 5 + 1)::int AS quantity,  -- quantity (1–5)
        round(((random() * 100 + 1) * (random() * 5 + 1))::numeric, 2)  -- total_price
FROM generate_series(1, 100);
