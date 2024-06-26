-- Drop tables if they exist
DROP TABLE IF EXISTS rcra_site;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS organization;
DROP TYPE IF EXISTS site_type;

-- Create org table
CREATE TABLE organization
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255),
    parent_org  INTEGER,
    FOREIGN KEY (parent_org) REFERENCES organization (id)

);

-- Create address table
CREATE TABLE address
(
    id            SERIAL PRIMARY KEY,
    street_number VARCHAR(255),
    address_1     VARCHAR(255) NOT NULL,
    address_2     VARCHAR(255),
    city          VARCHAR(255),
    state         VARCHAR(255),
    country       VARCHAR(255),
    zip           VARCHAR(255)
);

-- Create rcra_site table
CREATE TYPE site_type AS ENUM ('Generator', 'Transporter', 'Tsdf');

CREATE TABLE rcra_site
(
    id                 SERIAL PRIMARY KEY,
    epa_id             VARCHAR(255),
    name               VARCHAR(255) NOT NULL,
    type               site_type    NOT NULL,
    gis_primary        BOOLEAN      NOT NULL,
    mailing_address_id INTEGER,
    site_address_id    INTEGER,
    FOREIGN KEY (mailing_address_id) REFERENCES address (id),
    FOREIGN KEY (site_address_id) REFERENCES address (id)
);

CREATE TABLE site
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    org         INTEGER,
    FOREIGN KEY (org) REFERENCES organization (id)
);
