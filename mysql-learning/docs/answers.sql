USE mysql_learning;

-- basic-3
SELECT *
FROM users
WHERE status = 1
ORDER BY created_at DESC
LIMIT 2;

-- basic-4
SELECT u.id, u.username, COUNT(o.id) AS order_count
FROM users u
LEFT JOIN orders o ON o.user_id = u.id
GROUP BY u.id, u.username
ORDER BY u.id;

-- basic-5
SELECT DATE(created_at) AS dt, COUNT(*) AS order_count
FROM orders
WHERE created_at >= '2025-01-01' AND created_at < '2025-01-08'
GROUP BY DATE(created_at)
ORDER BY dt;

-- basic-6
SELECT o.id AS order_id,
       u.username,
       o.status AS order_status,
       o.total_cents,
       p.sku,
       oi.quantity
FROM orders o
JOIN users u ON u.id = o.user_id
JOIN order_items oi ON oi.order_id = o.id
JOIN products p ON p.id = oi.product_id
ORDER BY o.id, oi.id;

-- basic-7
SELECT u.id, u.username
FROM users u
JOIN orders o ON o.user_id = u.id
GROUP BY u.id, u.username
HAVING COUNT(o.id) >= 2;

-- index-1 (示例索引)
-- CREATE INDEX idx_orders_user_created_desc ON orders(user_id, created_at);

-- tx-2 (示例：悲观锁扣库存)
-- START TRANSACTION;
-- SELECT available FROM inventory WHERE product_id = 1 FOR UPDATE;
-- UPDATE inventory SET available = available - 1 WHERE product_id = 1 AND available >= 1;
-- COMMIT;
