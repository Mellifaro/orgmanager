DROP SEQUENCE IF EXISTS company_seq CASCADE;
DROP TABLE IF EXISTS companies CASCADE;

CREATE SEQUENCE company_seq START 100;

CREATE TABLE companies (
  id          BIGINT PRIMARY KEY DEFAULT nextval('company_seq'),
  name        VARCHAR UNIQUE NOT NULL,
  earnings    BIGINT DEFAULT 0,
  parent_id   INTEGER DEFAULT NULL,
  FOREIGN KEY (parent_id) REFERENCES companies (id) ON DELETE CASCADE
);

