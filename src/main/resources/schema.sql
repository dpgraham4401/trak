CREATE SCHEMA IF NOT EXISTS site;

CREATE TABLE IF NOT EXISTS site.rcrainfo_site
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    epa_id VARCHAR(15)
);

