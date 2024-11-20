CREATE TABLE IF NOT EXISTS addresses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    street VARCHAR(150),
    complement VARCHAR(150),
    unit VARCHAR(50),
    neighborhood VARCHAR(100),
    city VARCHAR(100),
    state_abbreviation VARCHAR(2),
    state VARCHAR(100),
    country VARCHAR(100)
);