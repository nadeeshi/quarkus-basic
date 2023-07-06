CREATE TABLE services (
    service_id BIGSERIAL PRIMARY KEY,
    name VARCHAR UNIQUE,
    price NUMERIC(12,2)
);

CREATE TABLE customers (
    customer_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR,
    email VARCHAR,
    phone VARCHAR,
    address VARCHAR
);

CREATE TABLE vendors (
    vendor_id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    contact VARCHAR,
    phone VARCHAR,
    email VARCHAR,
    address VARCHAR
);

CREATE INDEX vendor_name_id ON vendors(name);