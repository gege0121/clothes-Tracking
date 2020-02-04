ALTER TABLE customers
ALTER COLUMN password TYPE varchar(150);


UPDATE roles SET (allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) =
('/', 'Y', 'Y', 'Y', 'Y') WHERE name = 'Admin';
UPDATE roles SET (allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) =
('/clothes,/clo,/customer,/history,/historys', 'Y', 'Y', 'Y', 'Y') WHERE name = 'Manager';
UPDATE roles SET (allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) =
('/clothes,/clo,/history,/historys', 'Y', 'N', 'N', 'N') WHERE name = 'user';