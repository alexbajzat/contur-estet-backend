CREATE TABLE IF NOT EXISTS account(
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    password BINARY(60) NOT NULL,
    account_type INT NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)^;

CREATE TABLE IF NOT EXISTS file_resource(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    extension VARCHAR(50) NOT NULL,
    endpoint VARCHAR(255) NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)^;

CREATE TABLE IF NOT EXISTS category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    resource_id INT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT FOREIGN KEY(resource_id) REFERENCES file_resource(id)
)^;

CREATE TABLE IF NOT EXISTS topic(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT FOREIGN KEY(category_id) REFERENCES category(id) ON DELETE CASCADE
)^;

CREATE TABLE IF NOT EXISTS topic_resource (
    id INT PRIMARY KEY AUTO_INCREMENT,
    topic_id INT NOT NULL,
    resource_id INT NOT NULL,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

     CONSTRAINT FOREIGN KEY(topic_id) REFERENCES topic(id) ON DELETE CASCADE,
     CONSTRAINT FOREIGN KEY(resource_id) REFERENCES file_resource(id) ON DELETE CASCADE
)^;




