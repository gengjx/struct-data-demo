CREATE DATABASE IF NOT EXISTS mysql_learning CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE mysql_learning;

DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(64) NOT NULL,
  email VARCHAR(128) NOT NULL,
  status TINYINT NOT NULL DEFAULT 1,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uk_users_username (username),
  UNIQUE KEY uk_users_email (email),
  KEY idx_users_created_at (created_at)
) ENGINE=InnoDB;

CREATE TABLE products (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  sku VARCHAR(64) NOT NULL,
  name VARCHAR(128) NOT NULL,
  price_cents INT NOT NULL,
  status TINYINT NOT NULL DEFAULT 1,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uk_products_sku (sku),
  KEY idx_products_status_created (status, created_at)
) ENGINE=InnoDB;

CREATE TABLE inventory (
  product_id BIGINT PRIMARY KEY,
  available INT NOT NULL,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_inventory_product FOREIGN KEY (product_id) REFERENCES products(id)
) ENGINE=InnoDB;

CREATE TABLE orders (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  status VARCHAR(32) NOT NULL,
  total_cents INT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  paid_at DATETIME NULL,
  KEY idx_orders_user_created (user_id, created_at),
  KEY idx_orders_status_created (status, created_at),
  CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;

CREATE TABLE order_items (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  order_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL,
  price_cents INT NOT NULL,
  KEY idx_order_items_order (order_id),
  KEY idx_order_items_product (product_id),
  CONSTRAINT fk_order_items_order FOREIGN KEY (order_id) REFERENCES orders(id),
  CONSTRAINT fk_order_items_product FOREIGN KEY (product_id) REFERENCES products(id)
) ENGINE=InnoDB;

INSERT INTO users (username, email, status, created_at) VALUES
('alice', 'alice@example.com', 1, '2025-01-01 10:00:00'),
('bob', 'bob@example.com', 1, '2025-01-02 10:00:00'),
('cathy', 'cathy@example.com', 1, '2025-01-03 10:00:00'),
('david', 'david@example.com', 0, '2025-01-04 10:00:00');

INSERT INTO products (sku, name, price_cents, status, created_at) VALUES
('SKU-BOOK-001', 'Book A', 3999, 1, '2025-01-01 12:00:00'),
('SKU-BOOK-002', 'Book B', 4999, 1, '2025-01-01 12:10:00'),
('SKU-FOOD-001', 'Snack A', 1299, 1, '2025-01-02 08:00:00'),
('SKU-TOY-001',  'Toy A',  9999, 0, '2025-01-03 09:00:00');

INSERT INTO inventory (product_id, available) VALUES
(1, 100),
(2, 100),
(3, 200),
(4, 0);

INSERT INTO orders (user_id, status, total_cents, created_at, paid_at) VALUES
(1, 'PAID',     5298, '2025-01-05 10:00:00', '2025-01-05 10:05:00'),
(1, 'CREATED',  3999, '2025-01-06 11:00:00', NULL),
(2, 'PAID',     3999, '2025-01-07 12:00:00', '2025-01-07 12:02:00'),
(3, 'CANCELED', 1299, '2025-01-08 13:00:00', NULL);

INSERT INTO order_items (order_id, product_id, quantity, price_cents) VALUES
(1, 3, 1, 1299),
(1, 1, 1, 3999),
(2, 1, 1, 3999),
(3, 2, 1, 4999),
(4, 3, 1, 1299);
