CREATE TABLE users (
    user_id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    roles VARCHAR(50)
);


CREATE TABLE restaurant (
    restaurant_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    photo VARCHAR(255),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type VARCHAR(50)
);