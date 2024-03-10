DROP TABLE IF EXISTS customer_chair;
DROP TABLE IF EXISTS chair;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS store;

CREATE TABLE store (
	store_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(256),
	address VARCHAR(128),
	city VARCHAR(60),
	state VARCHAR(40),
	zipcode VARCHAR(20),
	PRIMARY KEY (store_id)
);

CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	store_id INT,
	name VARCHAR(128),
	PRIMARY KEY (customer_id),
	FOREIGN KEY (store_id) REFERENCES store (store_id) ON DELETE CASCADE
);

CREATE TABLE chair (
	chair_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(256),
	brand VARCHAR(128),
	model VARCHAR(128),
	price VARCHAR(20),
	PRIMARY KEY (chair_id)
);

CREATE TABLE customer_chair (
	customer_id INT NOT NULL,
	chair_id INT NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE,
	FOREIGN KEY (chair_id) REFERENCES chair (chair_id) ON DELETE CASCADE
);