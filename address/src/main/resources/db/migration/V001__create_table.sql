CREATE TABLE IF NOT EXISTS addresses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    zip_code VARCHAR(10) NOT NULL,
    street VARCHAR(150),
    number VARCHAR(10),
    complement VARCHAR(150),
    neighborhood VARCHAR(100),
    city VARCHAR(100),
    state_abbreviation VARCHAR(2),
    state VARCHAR(100),
    country VARCHAR(30)
);