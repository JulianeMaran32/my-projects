CREATE TABLE `customers` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `full_name` varchar(150) NOT NULL,
    `email` varchar(150) NOT NULL,
    `document_number` varchar(11) NOT NULL,
    `phone_number` varchar(15) NOT NULL,
    `active` bit(1) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_customers_email` (`email`),
    UNIQUE KEY `uk_customers_phone_number` (`phone_number`),
    UNIQUE KEY `uk_customers_document_number` (`document_number`)
);