DELETE FROM companies;

ALTER SEQUENCE company_seq RESTART WITH 100;

INSERT INTO companies(name, earnings, parent_id)
    VALUES  ('Roshen', 25000, NULL),
            ('Roshen 1', 15000, 100),
            ('Roshen 2', 8000, 100),
            ('Roshen 3', 11000, 102),
            ('Roshen 4', 5000, 103),
            ('Konti', 13000, NULL),
            ('Konti 1', 10000, 105),
            ('Konti 2', 8000, 105),
            ('AVK', 16000, NULL);