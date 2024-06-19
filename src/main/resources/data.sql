-- Insert data into organization table
INSERT INTO organization (name, description, parent_org)
VALUES ('Organization 1', 'Description 1', NULL);
INSERT INTO organization (name, description, parent_org)
VALUES ('Organization 2', 'Description 2', 1);

-- Insert data into address table
INSERT INTO address (street_number, address_1, address_2, city, state, country, zip)
VALUES ('123', 'Street 1', 'Apt 1', 'City 1', 'State 1', 'Country 1', 'Zip 1');
INSERT INTO address (street_number, address_1, address_2, city, state, country, zip)
VALUES ('456', 'Street 2', 'Apt 2', 'City 2', 'State 2', 'Country 2', 'Zip 2');

-- Insert data into rcrainfo_site table
INSERT INTO rcra_site (epa_id, name, type, gis_primary, mailing_address_id, site_address_id)
VALUES ('VATESTGEN001', 'Test Generator', 'Generator', true, 1, 2);
INSERT INTO rcra_site (epa_id, name, type, gis_primary, mailing_address_id, site_address_id)
VALUES ('VATESTSDF001', 'Test TSDF', 'Tsdf', false, 2, 1);