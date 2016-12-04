-- Construction de la base

SET search_path = "data", pg_catalog;
alter user admin SET search_path = "data", pg_catalog;

drop SEQUENCE person_seq;
CREATE SEQUENCE person_seq START WITH 1
alter TABLE person_seq OWNER TO admin;