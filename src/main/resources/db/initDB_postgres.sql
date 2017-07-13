CREATE SEQUENCE company_seq START 100;

CREATE TABLE companies (
  id          INTEGER PRIMARY KEY DEFAULT nextval('company_seq'),
  name        VARCHAR UNIQUE NOT NULL,
  earnings    INTEGER DEFAULT 0,
  parent_id   INTEGER DEFAULT NULL,
  FOREIGN KEY (parent_id) REFERENCES companies (id) ON DELETE CASCADE
);

