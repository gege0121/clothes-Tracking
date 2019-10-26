ALTER TABLE customer
  DROP COLUMN sex;

ALTER TABLE customer
  ADD gender INTEGER DEFAULT 1;

ALTER TABLE customer
  RENAME TO customers;

ALTER TABLE clothes
  RENAME TO clothess;


ALTER TABLE history
  RENAME TO historys;